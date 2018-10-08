package com.erpsystem.dao.entity;

public class Supplier {
	private String sId;		//编号
	private String supCompany;		//公司名称
	private String supAddress;		//公司地址
	private String supContacts;		//联系人
	private String supPhone;		//联系电话
	public Supplier() {}
	
	@Override
	public String toString() {
		return "Supplier [sId=" + sId + ", supCompany=" + supCompany + ", supAddress=" + supAddress + ", supContacts="
				+ supContacts + ", supPhone=" + supPhone + "]";
	}
	public String getsId() {
		return sId;
	}
	public void setsId(String sId) {
		this.sId = sId;
	}
	public String getSupCompany() {
		return supCompany;
	}
	public void setSupCompany(String supCompany) {
		this.supCompany = supCompany;
	}
	public String getSupAddress() {
		return supAddress;
	}
	public void setSupAddress(String supAddress) {
		this.supAddress = supAddress;
	}
	public String getSupContacts() {
		return supContacts;
	}
	public void setSupContacts(String supContacts) {
		this.supContacts = supContacts;
	}
	public String getSupPhone() {
		return supPhone;
	}
	public void setSupPhone(String supPhone) {
		this.supPhone = supPhone;
	}
	
}
