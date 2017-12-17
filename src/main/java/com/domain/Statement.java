package com.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Statement {

	@JsonFormat(pattern="yyyy-MM-dd")
	private String from;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private String to;
	
	private String transactionType;
	private String transactionNo;
	private String policyName;
	private String transactionId;

	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionNo() {
		return transactionNo;
	}
	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	@Override
	public String toString() {
		return "Statement [from=" + from + ", to=" + to + ", transactionType=" + transactionType + ", transactionNo="
				+ transactionNo + ", policyName=" + policyName + ", transactionId=" + transactionId + "]";
	}
	
}
