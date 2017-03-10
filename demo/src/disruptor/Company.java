package disruptor;

import java.util.Date;

/**
 * 
 * @类功能说明：企业
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：宁波中晟信息科技有限公司
 * @部门：技术部
 * @作者：tandeng
 * @创建时间：2015-11-12下午2:34:53
 * @版本：V1.0
 *
 */
public class Company {
	
	/**
	 * 企业标识
	 */
    private Long id;
	
	/**
	 * 用户名
	 */
    private String companyName;
	
	/**
	 * 密码
	 */
    private String password;
	
	/**
	 * 企业编号
	 */
    private String code;
	
	/**
	 * 企业名称
	 */
    private String name;

    /**
     * 邮件
     */
    private String email;
	
	/**
	 * 电话
	 */
    private String tel;
	
	/**
	 * 传真
	 */
    private String fax;
	
	/**
	 * 邮编
	 */
    private String postCode;
	
	/**
	 * 企业网站
	 */
    private String website;
	
	/**
	 * 地址
	 */
    private String address;
    
    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 联系人性别
     */
    private Integer sex;
	
	/**
	 * 有效标志:
	 * [0]无效
	 * [1]有效
	 * [2]需要审核而且邮件未激活
	 * [3]需要审核而且点击了激活但是仍在审核中
	 * [4]不需要审核邮件未激活
	 * [5]审核驳回,或者未提交审核信息
	 * [6]身份信息未提交
	 */
    private Integer flag;
	
	/**
	 * 创建时间
	 */
    private Date createTime;
	
	/**
	 * 更新用户ID
	 */
    private Long updateId;
	
	/**
	 * 更新时间
	 */
    private Date updateTime;
    /**
	 * 激活时间
	 */
    private Date dealTime;
    
    private String activationCode;
    
    /**
     * 	启用时间
     */
    private Date enableTime;
    
    /**
     * 禁用时间
     */
    private Date disableTime;
   
    /**
     * Saas订单号
     */
    private String saasCode;    
    /**
     * 订购信息
     */
    private String orderInfo;  
    
    /**
     * 邀请码
     */
   private String invitationCode;
   
   /**
    * 对应省份的id
    */
   private Long provinceId;
   
   /**
    * 对应的城市的id
    */
   private Long cityId;
   
   /**
    * 对应的县区id
    */
   private Long areaId;
   
   /**
    * 订购状态
    * [0]未付费
    * [1]包年服务
    */
   private Integer orderStatus;
   
   /**
    * 辅助用
    */
   private Long centerCompanyId;
    
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
   

	public Date getDealTime() {
		return dealTime;
	}

	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}
	
	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	public Date getEnableTime() {
		return enableTime;
	}

	public void setEnableTime(Date enableTime) {
		this.enableTime = enableTime;
	}

	public Date getDisableTime() {
		return disableTime;
	}

	public void setDisableTime(Date disableTime) {
		this.disableTime = disableTime;
	}

	public String getSaasCode() {
		return saasCode;
	}

	public void setSaasCode(String saasCode) {
		this.saasCode = saasCode;
	}

	public String getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(String orderInfo) {
		this.orderInfo = orderInfo;
	}

	public String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Long getCenterCompanyId() {
		return centerCompanyId;
	}

	public void setCenterCompanyId(Long centerCompanyId) {
		this.centerCompanyId = centerCompanyId;
	}
	
	

}