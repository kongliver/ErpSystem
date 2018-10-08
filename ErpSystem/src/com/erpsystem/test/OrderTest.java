package com.erpsystem.test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.erpsystem.dao.IOrderDao;
import com.erpsystem.dao.impl.OrderDaoImpl;
import com.erpsystem.domain.Order;
import com.erpsystem.service.IOrderService;
import com.erpsystem.service.impl.OrderServiceImpl;
import com.erpsystem.utils.PrimaryKeyUtil;

/**
 * @功能 用来测试订单的所有方法
 * @文件 OrderTest.java
 * @作者 张洪刚
 * @时间 2018-09-30 22:45
 * @地点 成都
 */
public class OrderTest {
	IOrderDao dao = new OrderDaoImpl();
	IOrderService service = new OrderServiceImpl();
	@Test
	public void findCount() throws SQLException {
		Integer findCount = dao.findCount();
		System.out.println(findCount);
	}
	
	
	@Test
	public void findPageTest() throws SQLException {
		List<Order> list = dao.findPage(0, 1);
		System.out.println(list);
	}
	
	@Test 
	public void findByIdTest() throws SQLException {
		Order ordeer = dao.finById(2018100100001L);
		System.out.println(ordeer);
	}
	
	@Test
	public void getOrderNum() {
		System.out.println(
		PrimaryKeyUtil.getOrderPrimarKey(new Date(), "2018100100001"));
	}
	
	@Test
	public void findMaxKey() throws SQLException {
		System.out.println(dao.findMaxKey());
		
	}
	
	@Test
	public void insertOrderTest() throws SQLException {
		Order order = new Order();
		
		order.setGoodsCount(1);
		order.setGoodsName("1");
		order.setGoodsPrice(11.1);
		order.setOrderType(1);
		order.setcId(1);
		service.insertOrder(order);
	}
}
