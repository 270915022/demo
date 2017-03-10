package disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * 声明了一个EventFactory来实例化Event对象
 * @author liuwei
 *
 */
public class CompanyInitEventFactory implements EventFactory<CompanyInitEvent>{

	@Override
	public CompanyInitEvent newInstance() {
		
		return new CompanyInitEvent();
	}

}
