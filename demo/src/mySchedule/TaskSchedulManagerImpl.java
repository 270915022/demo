package mySchedule;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class TaskSchedulManagerImpl implements ITaskSchedulManager {
	
    /** 运行状态 */
    protected String moduleState;

    /** 用于存放待处理事项 */
    //private BlockingQueue<ITask> list;

    /** 调度线程池 */
    private ScheduledExecutorService taskDispatchThreadPool = Executors.newScheduledThreadPool(5);
    
    /** 执行线程池 */
    private ExecutorService taskRunThreadPool = Executors.newCachedThreadPool();
    /** 用于 修改 删除 判断 任务执行状态 */
    private Map<String, Future<?>> futureMap = new HashMap<String, Future<?>>();

    /**
     * 取消正在执行的任务
     */
    public void cancelTask(String taskName) {
    	Future<?> future = futureMap.get(taskName);
    	if(future != null && !future.isCancelled()){
    		futureMap.remove(taskName);
    		future.cancel(true);
    	}
    }
    
    /**
     * 添加任务
     */
    @Override
    public void addTask(ITask task){
        if(task != null) {
            doTaskDispatch(task);
        }
    }
    

    /**
     * 事项调度
     * @param task
     * @throws ModuleException
     */
    private void doTaskDispatch(ITask task){
        TaskExecute te = new TaskExecute(task);
        Future<?> future = taskDispatchThreadPool.submit(te.taskDispatch);
        if(task.getTaskName() != null && task.getTaskName().length() > 0){
        	Future<?> oldFuture = futureMap.get(task.getTaskName());
        	// 如果原来的任务没有执行完毕  就覆盖原来的任务
        	if(oldFuture != null && !oldFuture.isCancelled()){
        		oldFuture.cancel(true);
        		futureMap.put(task.getTaskName(), future);
        	}else{
        		futureMap.put(task.getTaskName(), future);
        	}
        }
    }
    
    public class MyTask implements Runnable{
        
        private ITask task;
        
        public MyTask(ITask t){
            this.task = t;
        }

        /**
         * {@inheritDoc}
         */
        
        @Override
        public void run() {
            try{
                task.taskContent();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
    
    /**
     * 线程工厂
     * 自己定制一个线程工厂,可以控制线程数量的上线限(原生的支持这方面有问题)
     * 先不纳入使用
     */
    public static class MyThreadFactory implements ThreadFactory{

        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;
        private BlockingQueue<MyThread> queue = new ArrayBlockingQueue<MyThread>(20);

        public MyThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                                  Thread.currentThread().getThreadGroup();
            namePrefix = "pool-" +
                          poolNumber.getAndIncrement() +
                         "-thread-";
        }

        public Thread newThread(Runnable r) {
            MyThread t = queue.poll();
            t.setRun(r);
            return t;
        }
        
        protected Thread doNewThread(Runnable r) {
            Thread t = new MyThread(group, r,
                                  namePrefix + threadNumber.getAndIncrement(),
                                  0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
        
        public class MyThread extends Thread{
            
            AtomicReference<Runnable> run = new AtomicReference<Runnable>();

            public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
                super(group, target, name, stackSize);
                setRun(target);
            }

            public void setRun(Runnable run){
                this.run.set(run);
            }
            
            public Runnable getRun(){
                return this.run.get();
            }

            /**
             * {@inheritDoc}
             */
            
            @Override
            public void run() {
                try{
                    Runnable runnable = this.run.get();
                    if(runnable != null){
                        runnable.run();
                    }
                }catch (RuntimeException e) {
                    throw e;
                }catch (Error e) {
                    throw e;
                }catch (Throwable e) {
                    throw new Error(e);
                }finally{
                    setRun(null);
                    queue.add(this);
                }
            }
            
            
            
        }
        
    }
    
    /**
     * Task执行体
     */
    public class TaskExecute {
        
        TaskRun taskRun = null;
        
        TaskDispatch taskDispatch = null;
        
        ITask task = null;
        
        volatile Thread taskAddThread = null;
        
        public TaskExecute(ITask t){
            task = t;
            taskRun = new TaskRun(t);
            taskDispatch = new TaskDispatch(t);
            taskAddThread = Thread.currentThread();
        }
        
        public class TaskRun implements Runnable {

            ITask trueTask = null;

            public TaskRun(ITask t) {
                this.trueTask = t;
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void run() {
                try{
                    String name = Thread.currentThread().getName();
                    String runName = trueTask.getTaskName();
                    if(runName != null){
                        Thread.currentThread().setName(runName);
                    }
                    trueTask.taskContent();
                    if(runName != null){
                        Thread.currentThread().setName(name);
                    }
                    trueTask.getTrigger().next();
                    // 调度事项
                    taskDispatchThreadPool.submit(TaskExecute.this.taskDispatch);
                }catch (InterruptedException e) {
                	e.printStackTrace();
                }
            }
        }
        
        public class TaskDispatch implements Runnable {

            private ITask trueTask = null;

            public TaskDispatch(ITask t) {
                this.trueTask = t;
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void run() {
                long n = trueTask.getTrigger().hasNext();
                if(n == 0) {
                	Future<?> future =  taskRunThreadPool.submit(TaskExecute.this.taskRun);
                	if(trueTask.getTaskName() != null && trueTask.getTaskName().length() > 0){
                		futureMap.put(trueTask.getTaskName(), future);
                	}
                } else if(n > 0){
                	ScheduledFuture<?> future = taskDispatchThreadPool.schedule(this, n, TimeUnit.MILLISECONDS);
                	if(trueTask.getTaskName() != null && trueTask.getTaskName().length() > 0){
                		futureMap.put(trueTask.getTaskName(), future);
                	}
                } else {
                	if(trueTask.getTaskName() != null && trueTask.getTaskName().length() > 0){
                		futureMap.remove(trueTask.getTaskName());
                	}
                }
               
            }
        }
        
    }
    
}
