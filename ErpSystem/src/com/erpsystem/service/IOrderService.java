package com.erpsystem.service;

import java.sql.SQLException;
import java.util.List;

import com.erpsystem.domain.Order;
import com.erpsystem.domain.PageBean;

/**
 * @功能 用来为订单提供服务的接口
 * @文件 IOrderService.java
 * @作者 张洪刚
 * @时间 2018-09-30 22:47
 * @地点 成都
 */
public interface IOrderService {
	
	/**
	 * 用来查询所有订单的方法，包括分页，条件查询
	 * @return
	 */
	PageBean<Order> findAll(String cname, String orderNum,Integer orderType, Integer currentCount, Integer currentPage) throws SQLException;
	
	/**
	 * 查询全部订单
	 * @return
	 * @throws SQLException
	 */
	public List<Order> findAll()throws SQLException;
	
	/**
	 * 根据id查找
	 * @return
	 * @throws SQLException
	 */
	public Order findById(Long id) throws SQLException;
	
	/**
	 * 插入一条订单
	 * @param order
	 * @throws SQLException
	 */
	public void insertOrder(Order order) throws SQLException;
	
	/**
	 * 根据订单id完成出库的服务
	 * @param orderNum 订单id 
	 * @throws SQLException
	 */
	public boolean outStock(Long orderNum) throws SQLException;
	
	/**
	 * 根据传入的订单号，修改订单状态
	 * @param orderNum  订单id 
	 * @param statusCode 状态码
	 * @throws SQLException
	 */
	public void updateOrderStatu(Long orderNum, Integer statusCode)throws SQLException;
	

}
