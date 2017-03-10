package disruptor;
import java.util.concurrent.CountDownLatch;

import org.junit.Assert;

import com.lmax.disruptor.EventTranslatorVararg;
import com.lmax.disruptor.RingBuffer;
/**
 * 事件生产者
 * @author liuwei
 */
public class CompanyInitProducer{
	
	private final RingBuffer<CompanyInitEvent> ringBuffer;
	


	public CompanyInitProducer(RingBuffer<CompanyInitEvent> ringBuffer) {
		super();
		this.ringBuffer = ringBuffer;
	}


	/*private final static EventTranslatorVararg<CompanyInitEvent> translator = new EventTranslatorVararg<CompanyInitEvent>() {
      *//**
       * 处理事件  
       *//*
	   public void translateTo(CompanyInitEvent companyInitEvent, long seq, Object... objs) {
		   companyInitEvent.setCompany((Company) objs[0]);
		   companyInitEvent.setOperatorB2B((OperatorB2B) objs[1]);
	   }
	};*/
	
	

	
	public void onData(Object...objs) {
		Assert.assertNotNull("objs cannot be null", objs);
		long seq = this.ringBuffer.next();
		CompanyInitEvent com = this.ringBuffer.get(seq);
		if ("Company".equals(objs[0].getClass().getSimpleName())) {
			com.setCompany((Company)objs[0]);
		}
		if ("OperatorB2B".equals(objs[1].getClass().getSimpleName())) {
			com.setOperatorB2B((OperatorB2B)objs[1]);
		}
		this.ringBuffer.publish(seq);
	}
}
