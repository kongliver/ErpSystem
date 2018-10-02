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
	PageBean<Order> findAll(Integer currentCount, Integer currentPage) throws SQLException;
	
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

}
