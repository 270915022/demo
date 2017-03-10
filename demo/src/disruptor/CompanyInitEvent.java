package disruptor;

/**
 * RingBuffer中存储的单元
 * @author liuwei
 *
 */
public class CompanyInitEvent {
	/**
	 * 企业信息
	 */
	private Company  company;
	
	
	/**
	 * 用户信息
	 */
	private OperatorB2B operatorB2B;


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public OperatorB2B getOperatorB2B() {
		return operatorB2B;
	}


	public void setOperatorB2B(OperatorB2B operatorB2B) {
		this.operatorB2B = operatorB2B;
	}
	
	

}
