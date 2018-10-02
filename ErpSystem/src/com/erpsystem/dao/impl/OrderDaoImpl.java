package com.erpsystem.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.erpsystem.dao.IOrderDao;
import com.erpsystem.domain.Order;
import com.erpsystem.utils.DruidConnection;

/**
 * @功能 用来为订单提供dao层的实现类
 * @文件 OrderDaoImpl.java
 * @作者 张洪刚
 * @时间 2018-10-01 08:54
 * @地点 成都
 */
public class OrderDaoImpl implements IOrderDao {
	QueryRunner qr = new QueryRunner(DruidConnection.getDataSource());
	
	@Override
	public Integer findCount() throws SQLException {
		String sql = "select count(*) from `order`";
		Long count = (Long)qr.query(sql, new ScalarHandler());
		return count.intValue();
	}

	@Override
	public List<Order> findPage(Integer index, Integer currentCount) throws SQLException {
		String sql = "select * from `order` limit ?,?";
		return qr.query(sql, new BeanListHandler<>(Order.class), index, currentCount);
	}

	@Override
	public List<Order> findAll() throws SQLException {
		String sql = "select * from `order`";
		return qr.query(sql, new BeanListHandler<>(Order.class));
	}

	@Override
	public Order finById(Long id) throws SQLException {
		String sql = "select * from `order` where orderNum=?";
		return qr.query(sql, new BeanHandler<>(Order.class), id);
	}

	@Override
	public String findMaxKey() throws SQLException {
		String sql = "select max(o.orderNum) from `order` o";
		Long num = qr.query(sql, new ScalarHandler<>());
		return String.valueOf(num);
	}

	@Override
	public void save(Order order) throws SQLException {
		String sql = "insert into `order` values(?,?,?,?,?,?,?,?)";
		Object[] obj = new Object[] {order.getOrderNum(), order.getGoodsName(), order.getGoodsCount(), order.getGoodsPrice(),
				order.getBeginTime(), order.getEndTime(), order.getOrderType(), order.getcId()};
		qr.update(sql, obj);
	}

}
