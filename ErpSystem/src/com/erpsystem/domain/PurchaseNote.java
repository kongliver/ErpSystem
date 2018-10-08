package com.erpsystem.domain;
import java.util.Date;

public class PurchaseNote {

//	CREATE TABLE `purchase_note` (
//			  `pnid` varchar(50) NOT NULL DEFAULT '',
//			  `psid` varchar(50) DEFAULT NULL,
//			  `purchaseCount` int(50) DEFAULT NULL,
//			  `purTotalMoney` decimal(50,0) DEFAULT NULL,
//			  `purchaseTime` datetime DEFAULT NULL,
//			  `buyer` varchar(50) DEFAULT NULL,
//			  `sid` varchar(50) DEFAULT NULL,
//			  PRIMARY KEY (`pnid`)
//			) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
	private String pnid;
	private int purchaseCount;
	private double purTotalMoney;
	private Date purchaseTime;
	private String buyer;
	private String sid;
	private String psid;
	
	
	public String getPnid() {
		return pnid;
	}


	public void setPnid(String pnid) {
		this.pnid = pnid;
	}





	public Integer getPurchaseCount() {
		return purchaseCount;
	}


	public void setPurchaseCount(Integer purchaseCount) {
		this.purchaseCount = purchaseCount;
	}


	public double getPurTotalMoney() {
		return purTotalMoney;
	}


	public void setPurTotalMoney(double purTotalMoney) {
		this.purTotalMoney = purTotalMoney;
	}


	public Date getPurchaseTime() {
		return purchaseTime;
	}


	public void setPurchaseTime(Date purchaseTime) {
		this.purchaseTime = purchaseTime;
	}


	public String getBuyer() {
		return buyer;
	}


	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}


	public String getSid() {
		return sid;
	}


	public void setSid(String sid) {
		this.sid = sid;
	}


	public String getPsid() {
		return psid;
	}


	public void setPsid(String psid) {
		this.psid = psid;
	}


	@Override
	public String toString() {
		return "PurchaseNote [pnid=" + pnid + ", purchaseCount=" + purchaseCount + ", purTotalMoney=" + purTotalMoney
				+ ", purchaseTime=" + purchaseTime + ", buyer=" + buyer + ", sid=" + sid + ", psid=" + psid + "]";
	}



	
	
	
}
