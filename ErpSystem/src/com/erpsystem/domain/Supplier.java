package com.erpsystem.domain;

/**
 * 
 * @功能描述 供应商实现类
 * @作者	唐华禹
 * @时间 2018年10月8日 上午9:51:10
 * @地点 成都
 *
 */

public class Supplier {
	/**
	 * 编号
	 */
	private String sid;		
	/**
	 * 公司名称
	 */
	private String supCompany;		
	/**
	 * 公司地址
	 */
	private String supAddress;		
	/**
	 * 联系人
	 */
	private String supContacts;		
	/**
	 * 联系电话
	 */
	private String supPhone;
	public Supplier() {}
	
	@Override
	public String toString() {
		return "Supplier [sId=" + sid + ", supCompany=" + supCompany + ", supAddress=" + supAddress + ", supContacts="
				+ supContacts + ", supPhone=" + supPhone + "]";
	}
	public String getsId() {
		return sid;
	}
	public void setsId(String sid) {
		this.sid = sid;
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
