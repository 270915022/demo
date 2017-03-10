package disruptor;

import java.math.BigDecimal;
import java.util.Date;

public class Order{
    private Long id;

    private Long companyId;

    private Long operatorId;

    private String saleContractNo;

    private Date signDate;

    private String customerContractNo;

    private String tradeMethod;

    private Long customerId;

    private String customerName;

    private Long contactId;

    private Long salemanId;

    private String contactName;

    private String contactEmail;

    private String currency;

    private BigDecimal exchangeRate;

    private String priceTerms;

    private String transportationMode;

    private String paymentTerms;

    private String paymentDesc;

    private String destinationCountry;

    private String shipmentTime;

    private String loadingPort;

    private String unloadingPort;

    private String batches;

    private String transshipment;

    private BigDecimal prePaymentRate;

    private BigDecimal prePayment;

    private BigDecimal moreOrLess;

    private BigDecimal contractAmount;

    private String remarks;

    private Long createId;

    private Date createTime;

    private Long updateId;

    private Date updateTime;

    private Byte terminatedStatus;

    private Byte status;

    private Byte flag;
    
    private Byte approvalType;

    private Integer version;

    

    public Byte getApprovalType() {
		return approvalType;
	}

	public void setApprovalType(Byte approvalType) {
		this.approvalType = approvalType;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

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

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getSaleContractNo() {
        return saleContractNo;
    }

    public void setSaleContractNo(String saleContractNo) {
        this.saleContractNo = saleContractNo == null ? null : saleContractNo.trim();
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public String getCustomerContractNo() {
        return customerContractNo;
    }

    public void setCustomerContractNo(String customerContractNo) {
        this.customerContractNo = customerContractNo == null ? null : customerContractNo.trim();
    }

    public String getTradeMethod() {
        return tradeMethod;
    }

    public void setTradeMethod(String tradeMethod) {
        this.tradeMethod = tradeMethod == null ? null : tradeMethod.trim();
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public Long getSalemanId() {
        return salemanId;
    }

    public void setSalemanId(Long salemanId) {
        this.salemanId = salemanId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail == null ? null : contactEmail.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getPriceTerms() {
        return priceTerms;
    }

    public void setPriceTerms(String priceTerms) {
        this.priceTerms = priceTerms == null ? null : priceTerms.trim();
    }

    public String getTransportationMode() {
        return transportationMode;
    }

    public void setTransportationMode(String transportationMode) {
        this.transportationMode = transportationMode == null ? null : transportationMode.trim();
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms == null ? null : paymentTerms.trim();
    }

    public String getPaymentDesc() {
        return paymentDesc;
    }

    public void setPaymentDesc(String paymentDesc) {
        this.paymentDesc = paymentDesc == null ? null : paymentDesc.trim();
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry == null ? null : destinationCountry.trim();
    }

    public String getShipmentTime() {
        return shipmentTime;
    }

    public void setShipmentTime(String shipmentTime) {
        this.shipmentTime = shipmentTime == null ? null : shipmentTime.trim();
    }

    public String getLoadingPort() {
        return loadingPort;
    }

    public void setLoadingPort(String loadingPort) {
        this.loadingPort = loadingPort == null ? null : loadingPort.trim();
    }

    public String getUnloadingPort() {
        return unloadingPort;
    }

    public void setUnloadingPort(String unloadingPort) {
        this.unloadingPort = unloadingPort == null ? null : unloadingPort.trim();
    }

    public String getBatches() {
		return batches;
	}

	public void setBatches(String batches) {
		this.batches = batches;
	}

	public String getTransshipment() {
		return transshipment;
	}

	public void setTransshipment(String transshipment) {
		this.transshipment = transshipment;
	}

	public BigDecimal getPrePaymentRate() {
        return prePaymentRate;
    }

    public void setPrePaymentRate(BigDecimal prePaymentRate) {
        this.prePaymentRate = prePaymentRate;
    }

    public BigDecimal getPrePayment() {
        return prePayment;
    }

    public void setPrePayment(BigDecimal prePayment) {
        this.prePayment = prePayment;
    }

    public BigDecimal getMoreOrLess() {
        return moreOrLess;
    }

    public void setMoreOrLess(BigDecimal moreOrLess) {
        this.moreOrLess = moreOrLess;
    }

    public BigDecimal getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(BigDecimal contractAmount) {
        this.contractAmount = contractAmount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
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

    public Byte getTerminatedStatus() {
        return terminatedStatus;
    }

    public void setTerminatedStatus(Byte terminatedStatus) {
        this.terminatedStatus = terminatedStatus;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getFlag() {
        return flag;
    }

    public void setFlag(Byte flag) {
        this.flag = flag;
    }
}