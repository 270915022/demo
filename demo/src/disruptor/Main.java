package disruptor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

public class Main {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException {
		 ExecutorService executor = Executors.newFixedThreadPool(2000);
		 CompanyInitEventFactory f = new CompanyInitEventFactory();
		 int bufferSize = 1024;
		 Disruptor<CompanyInitEvent> disruptor = new Disruptor<CompanyInitEvent>(f, bufferSize, executor);
		 disruptor.handleEventsWith(new CompanyInitConsumer());
		 disruptor.start();
		 RingBuffer<CompanyInitEvent> ringBuffer = disruptor.getRingBuffer();
		 long start = System.currentTimeMillis();
		 final CompanyInitProducer producer = new CompanyInitProducer(ringBuffer);
		 //开始循环生产
		 Thread t = new Thread(){
			 @Override
			public void run() {
				 for (int i = 0; i < 2000; i++) {
					 final Company c = new Company();
					 c.setName("哈士奇："+i);
					 final OperatorB2B o = new OperatorB2B();
					 o.setId(Long.parseLong(""+i));
					 producer.onData(c,o);
				 }
			}
		 };
		 t.start();
		 t.join();
		 long end = System.currentTimeMillis();
		/* disruptor.shutdown();
		 executor.shutdownNow();*/
		 System.out.println("耗时:"+(end-start));
		System.err.println("主线程开始执行.............................");
	}
}
