package semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		SemaphoreTest st = new SemaphoreTest();
		Semaphore s = new Semaphore(5);
		for (int i = 0; i < 10; i++) {
			MyThread myThread = st.new MyThread(s, i);
			service.execute(myThread);
		}
	}
	
	/**
	 * 
	 * @author 010
	 *
	 */
	class MyThread implements Runnable{
		private Semaphore sh = null;
		private int count;
		public MyThread(Semaphore sh,int count) {
			this.sh = sh;
			this.count = count;
		}
		public MyThread() {
		}
		@Override
		public void run() {
			try {
				sh.acquire();
				System.err.println("线程"+count+"获取许可");
				System.out.println("-------------------------");
				Thread.sleep((long) (Math.random() * 10000));
				sh.release();
				System.err.println("线程"+count+"释放许可");
				System.out.println("-------------------------");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
