package com.erpsystem.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.erpsystem.dao.ICustomerDao;
import com.erpsystem.domain.Customer;
import com.erpsystem.domain.Order;
import com.erpsystem.utils.DruidConnection;

/**
 * @功能 用来实现客户的dao层
 * @文件 CustomerDaoImpl.java
 * @作者 张洪刚
 * @时间 2018-10-01 18:03
 * @地点 成都
 */
public class CustomerDaoImpl implements ICustomerDao{

	@Override
	public Integer findCount() throws SQLException {
		QueryRunner qr = new QueryRunner(DruidConnection.getDataSource());
		String sql = "select count(*) from `customer`";
		Long count = (Long)qr.query(sql, new ScalarHandler<>());
		return count.intValue();
	}

	@Override
	public List<Customer> findPage(Integer index, Integer size, String unmae, String orderNum) throws SQLException {
		QueryRunner qr = new QueryRunner(DruidConnection.getDataSource());
		String sql = "select * from `customer` where 1=1 and cusCompany LIKE ? and cOrderNum LIKE ? limit ?,?";
		String cusCompany = "";
		String cOrderNum = "";
		
		if(null != unmae && !"".equals(unmae.trim())) {		
			cusCompany = "%" +unmae +"%";
		}else {
			cusCompany = "%%";
		}
		
		if(null != orderNum && !"".equals(orderNum.trim())) {
			cOrderNum = "%" + orderNum +"%";
		}else {
			cOrderNum = "%%";
		}
		
		return qr.query(sql, new BeanListHandler<>(Customer.class), cusCompany, cOrderNum, index, size);
	}

	@Override
	public void delete(String cid) throws SQLException {
		QueryRunner qr = new QueryRunner(DruidConnection.getDataSource());

		String sql = "delete from `customer` where cid = ?";
		qr.update(sql, cid);
	}

	@Override
	public Customer findById(String cid) throws SQLException {
		QueryRunner qr = new QueryRunner(DruidConnection.getDataSource());		
		
		String sql = "select * from `customer` where cid = ?";
		
		return qr.query(sql, new BeanHandler<>(Customer.class), cid);
	}

	@Override
	public void update(Customer customer) throws SQLException {
		QueryRunner qr = new QueryRunner(DruidConnection.getDataSource());		
		String sql = "update `customer` set cusCompany = ?, cusContacts = ?, cusPhone = ?, cusAddress = ? where cid = ?";
		qr.update(sql, customer.getCusCompany(), customer.getCusContacts(), customer.getCusPhone(), customer.getCusAddress(), customer.getCid());
	}

	@Override
	public String findMaxKey() throws SQLException {
		QueryRunner qr = new QueryRunner(DruidConnection.getDataSource());
		String sql = "select max(c.cid) from `customer` c";
		Long num = qr.query(sql, new ScalarHandler<>());
		return String.valueOf(num);
	}

	@Override
	public void save(Customer customer) throws SQLException {
		QueryRunner qr = new QueryRunner(DruidConnection.getDataSource());
		String sql = "insert into `customer` values(?,?,?,?,?,?)";
		Object[] obj = new Object[] {customer.getCid(), customer.getCusCompany(), customer.getCusContacts(), customer.getCusPhone(), customer.getCusAddress(), customer.getcOrderNum()};
		qr.update(sql, obj);
	}
	
}
