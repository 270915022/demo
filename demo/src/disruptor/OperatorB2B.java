package disruptor;
/**
 * @author liuwei
 * @comment 用户信息
 * @createTime 2017-02-22
 */
public class OperatorB2B {
	
	/**
	 * 自动增长标识
	 */
	private Long id;
	
	/**
	 * 公司ID
	 */
	private Long companyId;
	
	/**
	 * 部门ID
	 */
	private Long department;
	
	/**
	 * 中文签字章
	 */
	private String chineseSignature;
	
	/**
	 * 英文签字章
	 */
	private String englishSignature;
	
	/**
	 * 角色ID
	 */
	private Long roleId;
	
	/**
	 * 管理类型
	 * [0]无
	 * [1]全公司
	 * [2]本部门
	 * [3]/自定义
	 */
	private Integer managementType;
	
	/**
	 * 登录次数
	 */
	private Long loginCount;
	
	/**
	 * 有效标志
	 * [0]无效
	 * [1]/有效
	 */
	private Integer flag;
	
	/**
	 * 新邮件签名
	 * [0]否
	 * [id]签名id
	 */
	private Long  newSignature;
	
	/**
	 * 回复签名
	 * [0]否
	 * [id]签名id
	 */
	private Long replySignature;
	
	/**
	 * 转发签名
	 * [0]否
	 * [id]签名id
	 */
	private Long forwordSignature;
	
	/**
	 * 职务
	 */
	private  Long job;
	
	/**
	 * 钉钉
	 */
	private String dingding;
	
	/**
	 * 主账号 
	 * [1]是 
	 * [0]否(默认)
	 */
	private Integer primaryAccount;
	
	/**
	 * 对应用户中心的用户ID
	 */
	private Long centerUserId;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getDepartment() {
		return department;
	}

	public void setDepartment(Long department) {
		this.department = department;
	}

	public String getChineseSignature() {
		return chineseSignature;
	}

	public void setChineseSignature(String chineseSignature) {
		this.chineseSignature = chineseSignature;
	}

	public String getEnglishSignature() {
		return englishSignature;
	}

	public void setEnglishSignature(String englishSignature) {
		this.englishSignature = englishSignature;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Integer getManagementType() {
		return managementType;
	}

	public void setManagementType(Integer managementType) {
		this.managementType = managementType;
	}

	public Long getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Long loginCount) {
		this.loginCount = loginCount;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Long getNewSignature() {
		return newSignature;
	}

	public void setNewSignature(Long newSignature) {
		this.newSignature = newSignature;
	}

	public Long getReplySignature() {
		return replySignature;
	}

	public void setReplySignature(Long replySignature) {
		this.replySignature = replySignature;
	}

	public Long getForwordSignature() {
		return forwordSignature;
	}

	public void setForwordSignature(Long forwordSignature) {
		this.forwordSignature = forwordSignature;
	}

	public Long getJob() {
		return job;
	}

	public void setJob(Long job) {
		this.job = job;
	}

	
	public String getDingding() {
		return dingding;
	}

	public void setDingding(String dingding) {
		this.dingding = dingding;
	}

	public Integer getPrimaryAccount() {
		return primaryAccount;
	}

	public void setPrimaryAccount(Integer primaryAccount) {
		this.primaryAccount = primaryAccount;
	}

	public Long getCenterUserId() {
		return centerUserId;
	}

	public void setCenterUserId(Long centerUserId) {
		this.centerUserId = centerUserId;
	}
	
}