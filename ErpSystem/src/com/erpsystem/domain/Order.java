package com.erpsystem.domain;

/**
 * @功能 用来描述一个订单
 * @文件 Order.java
 * @作者 张洪刚
 * @时间 2018-09-30 21:22
 * @地点 成都
 * CREATE TABLE `order` (
  `orderNum` int(10) NOT NULL,
  `goodsName` varchar(50) NOT NULL,
  `goodsCount` int(10) NOT NULL,
  `goodsPrice` decimal(10,0) NOT NULL,
  `beginTime` datetime NOT NULL,
  `endTime` datetime NOT NULL,
  `orderType` tinyint(50) NOT NULL,
  `cid` varchar(50) NOT NULL,
  PRIMARY KEY (`orderNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 */
public class Order {
	/** 客户的订单号唯一标识主键id   采用201809300001格式*/
	private Long orderNum;
	
	/** 订单所包含的商品名称*/
	private String goodsName;
	
	/** 订单包含的商品数量*/
	private Integer goodsCount;
	
	/** 商品的单价*/
	private Double goodsPrice;
	
	/** 下订单的时间*/
	private String beginTime;
	
	/** 交货时间*/
	private String endTime;
	
	/** 1:刚的提交订单 2:完成出库订单   3: 有售后问题的订单
	 * 
	 **/	
	private Integer orderType;
	
	/** 订单属于那个客户的id*/
	private Integer cId;

	

	
	@Override
	public String toString() {
		return "Order [orderNum=" + orderNum + ", goodsName=" + goodsName + ", goodsCount=" + goodsCount
				+ ", goodsPrice=" + goodsPrice + ", beginTime=" + beginTime + ", endTime=" + endTime + ", orderType="
				+ orderType + ", cId=" + cId + "]";
	}

	public Long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}



	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}

	public Double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}
	
	
	
	
}
