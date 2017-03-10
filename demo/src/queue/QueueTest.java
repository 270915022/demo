package queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class QueueTest {
	public static void main(String[] args) throws InterruptedException {
		SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>();
		Integer take = queue.take();
		queue.put(123);
		System.out.println(take);
	}
}
