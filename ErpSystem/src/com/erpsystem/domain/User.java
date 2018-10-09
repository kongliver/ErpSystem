/**
 * 用户表的属性
 */

package com.erpsystem.domain;

public class User {
	private Integer uId;			//用户表的编号
	private String nickName;		//用户表的用户名
	private String userName;		//用户表的账号
	private String password;		//用户表的密码
	private String phone;			//用户表的电话
	private	Integer userTyep;		//用户表的权限
	
	
	
	
	
	/**
	 * 无参方法
	 */
	public User() {
		super();
	}
	
	/**
	 * 带参方法
	 * @param uId					//用户表的编号
	 * @param nickName				//用户表的用户名
	 * @param userName				//用户表的账号
	 * @param password				//用户表的密码
	 * @param phone					//用户表的电话
	 * @param userTyep				//用户表的权限
	 */
	public User(Integer uId, String nickName, String userName, String password, String phone, Integer userTyep) {
		super();
		this.uId = uId;
		this.nickName = nickName;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.userTyep = userTyep;
	}
	
	
	
	
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getUserTyep() {
		return userTyep;
	}
	public void setUserTyep(Integer userTyep) {
		this.userTyep = userTyep;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", nickName=" + nickName + ", userName=" + userName + ", password=" + password
				+ ", phone=" + phone + ", userTyep=" + userTyep + "]";
	}
	
	
	
	 
	
	
}
