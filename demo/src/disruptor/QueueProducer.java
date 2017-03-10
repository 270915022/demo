package disruptor;

import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Assert;

public class QueueProducer {
	private LinkedBlockingQueue<CompanyInitEvent> queue;
	
	public QueueProducer(LinkedBlockingQueue<CompanyInitEvent> queue) {
		this.queue = queue;
	}
	
	public void onData(Object...objs) {
		CompanyInitEvent e = new CompanyInitEvent();
		Assert.assertNotNull("objs cannot be null", objs);
		if ("Company".equals(objs[0].getClass().getSimpleName())) {
			e.setCompany((Company)objs[0]);
		}
		if ("OperatorB2B".equals(objs[1].getClass().getSimpleName())) {
			e.setOperatorB2B((OperatorB2B)objs[1]);
		}
		try {
			boolean offer = this.queue.offer(e);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public LinkedBlockingQueue<CompanyInitEvent> getQueue() {
		return queue;
	}

	public void setQueue(LinkedBlockingQueue<CompanyInitEvent> queue) {
		this.queue = queue;
	}
}
