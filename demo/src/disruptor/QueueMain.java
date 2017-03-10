package disruptor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueMain {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newCachedThreadPool();
		LinkedBlockingQueue<CompanyInitEvent> queue = new LinkedBlockingQueue<CompanyInitEvent>(100);
		final QueueProducer p = new QueueProducer(queue);
		QueueCostumer c = new QueueCostumer(queue);
		long start = System.currentTimeMillis();
		final CountDownLatch cdl = new CountDownLatch(1);
		Thread t = new Thread(){
			@Override
			public void run() {
				 for (int i = 0; i < 2000; i++) {
				/*	 try {
						Thread.currentThread().sleep(0);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}*/
					 final Company com = new Company();
					 com.setName("哈士奇："+i);
					 final OperatorB2B o = new OperatorB2B();
					 o.setId(Long.parseLong(""+i));
					 p.onData(com,o);
				 }
				 cdl.countDown();
			}
		};
		 t.start();
		 service.execute(c);
		 service.shutdown();
		 cdl.await();
		 long end = System.currentTimeMillis();
		 System.out.println("耗时:"+(end-start));
		 System.err.println("主线程开始执行.............................");
	}
}
