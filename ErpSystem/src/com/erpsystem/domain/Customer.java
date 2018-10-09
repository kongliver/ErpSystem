package com.erpsystem.domain;

/**
 * @功能 用来描述一个客户的类
 * @文件 Customer.java
 * @作者 张洪刚
 * @时间 2018-09-30 21:18
 * @地点 成都
 * CREATE TABLE `customer` (
  `cid` varchar(50) NOT NULL DEFAULT '',
  `cusCompany` varchar(50) NOT NULL,
  `cusContacts` varchar(50) NOT NULL,
  `cusPhone` varchar(50) NOT NULL,
  `cusAddress` varchar(50) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 */

public class Customer {
	
	/** 客户的主键id*/
	private String cid;
	/** 客户的公司名*/
	private String cusCompany;
	/** 客户的联系人*/
	private String cusContacts;
	/** 客户的联系方式*/
	private String cusPhone;
	/** 客户收货的地址*/
	private String cusAddress;
	
	private Long cOrderNum;

	
	
	

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cusCompany=" + cusCompany + ", cusContacts=" + cusContacts + ", cusPhone="
				+ cusPhone + ", cusAddress=" + cusAddress + ", cOrderNum=" + cOrderNum + "]";
	}
	public Long getcOrderNum() {
		return cOrderNum;
	}
	public void setcOrderNum(Long cOrderNum) {
		this.cOrderNum = cOrderNum;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCusCompany() {
		return cusCompany;
	}
	public void setCusCompany(String cusCompany) {
		this.cusCompany = cusCompany;
	}
	public String getCusContacts() {
		return cusContacts;
	}
	public void setCusContacts(String cusContacts) {
		this.cusContacts = cusContacts;
	}
	public String getCusPhone() {
		return cusPhone;
	}
	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}
	public String getCusAddress() {
		return cusAddress;
	}
	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}
	
	
}
