package com.erpsystem.domain;

/**
 * 
 * @Description 售后记录实体类
 * @author T2planet
 * @date 2018年10月2日下午4:40:30
 */
public class CustomerSupport {
	/** 售后记录编号 */
	private String csId;
	
	/** 关联的订单号 */
	private Long orderNum;
	
	/** 问题描述 */
	private String problem;
	
	/** 处理人 */
	private String handler;
	
	/** 处理时间 */
	private String handleTime;
	
	@Override
	public String toString() {
		return "CustomerSupport [csId=" + csId + ", orderNum=" + orderNum + ", problem=" + problem + ", handler="
				+ handler + ", handleTime=" + handleTime + "]";
	}
	
	//setter and getter start
	public String getCsId() {
		return csId;
	}
	public void setCsId(String csId) {
		this.csId = csId;
	}
	public Long getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getHandler() {
		return handler;
	}
	public void setHandler(String handler) {
		this.handler = handler;
	}
	public String getHandleTime() {
		return handleTime;
	}
	public void setHandleTime(String handleTime) {
		this.handleTime = handleTime;
	}
	//setter and getter end
	
}
