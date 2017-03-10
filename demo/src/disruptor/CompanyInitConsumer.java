package disruptor;

import java.util.concurrent.TimeUnit;

import com.lmax.disruptor.EventHandler;

/**
 * 事件消费者
 * @author liuwei
 */
public class CompanyInitConsumer implements EventHandler<CompanyInitEvent>{

	@Override
	public void onEvent(CompanyInitEvent event, long sequence,boolean endOfBatch) throws Exception {
		try {
			System.out.println("company:"+event.getCompany()==null?"null":event.getCompany().getName());
			System.out.println("OperatorB2BId:"+event.getOperatorB2B()==null?"null":event.getOperatorB2B().getId());
		} catch (Exception e) {
		}
		
	}

}
