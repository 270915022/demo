package threadLocal;

import java.util.concurrent.TimeUnit;
// ThreadLocal  每个线程独享自己的变量
public class ThreadLocalTest {
	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
		protected Integer initialValue() {
			return new Integer(1);
		};
	};
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			final int num = i;
			new Thread(num+""){
				@Override
				public void run() {
					threadLocal.set(num);
					System.out.println("线程"+super.getName()+"的值为:"+threadLocal.get().intValue());
				}
			}.start();
		}
	}
}
