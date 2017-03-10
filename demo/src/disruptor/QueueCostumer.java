package disruptor;

import java.util.concurrent.LinkedBlockingQueue;

public class QueueCostumer implements Runnable{
	private LinkedBlockingQueue<CompanyInitEvent> queue;
	
	public QueueCostumer(LinkedBlockingQueue<CompanyInitEvent> queue) {
		this.queue = queue;
	}

	public LinkedBlockingQueue<CompanyInitEvent> getQueue() {
		return queue;
	}

	public void setQueue(LinkedBlockingQueue<CompanyInitEvent> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			CompanyInitEvent c;
			while (true) {
				if ((c = queue.take()) != null) {
					System.out.println(queue.size());
					Thread.currentThread().sleep(100);
					System.out.println("company:"+c.getCompany()==null?"null":c.getCompany().getName());
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
