package com.erpsystem.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.erpsystem.dao.ICustomerSupportDao;
import com.erpsystem.domain.CustomerSupport;
import com.erpsystem.utils.JdbcUtil;
/**
 * 
 * @Description 售后记录dao层实现类
 * @author T2planet
 * @date 2018年10月2日下午5:27:46
 */
public class CustomerSupportDaoImpl implements ICustomerSupportDao {
	private QueryRunner qr = JdbcUtil.getQueryRunner();
	
	@Override
	public void saveCusSup(CustomerSupport cusSupport) throws SQLException {
		String sql = "insert into `customer_support_list` values(?,?,?,?,?)";
		qr.update(sql,cusSupport.getCsId(),cusSupport.getOrderNum(),cusSupport.getProblem(),cusSupport.getHandler(),cusSupport.getHandleTime());
		System.out.println("添加售后记录成功");
	}

	@Override
	public void deleteCusSup(String csId) throws SQLException {
		String sql = "delete from `customer_support_list` where csId=?";
		qr.update(sql,csId);
		System.out.println("删除售后记录成功");
	}

	@Override
	public void updateCusSup(CustomerSupport cusSupport) throws SQLException {
		String sql = "update `customer_support_list` set orderNum=?,problem=?,handler=?,handlerTime=? where csId=?";
		qr.update(sql,cusSupport.getOrderNum(),cusSupport.getProblem(),cusSupport.getHandler(),cusSupport.getHandleTime(),cusSupport.getCsId());
		System.out.println("修改售后记录成功");
	}

	@Override
	public List<CustomerSupport> getAllCusSup() throws SQLException {
		String sql = "select * from `customer_support_list`";
		List<CustomerSupport> cusSupList = qr.query(sql, new BeanListHandler<CustomerSupport>(CustomerSupport.class));
		return cusSupList;
	}

	@Override
	public CustomerSupport getCupSupById(String csId) throws SQLException {
		String sql = "select * from `customer_support_list` where csId=?";
		CustomerSupport cusSupBean = qr.query(sql, new BeanHandler<CustomerSupport>(CustomerSupport.class),csId);
		return cusSupBean;
	}

}
