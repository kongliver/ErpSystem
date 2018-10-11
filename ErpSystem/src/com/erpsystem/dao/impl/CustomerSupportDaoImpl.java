package com.erpsystem.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.erpsystem.dao.ICustomerSupportDao;
import com.erpsystem.domain.CustomerSupport;
import com.erpsystem.utils.CommonUtil;
import com.erpsystem.utils.DateUtil;
import com.erpsystem.utils.JdbcUtil;
/**
 * 
 * @Description 售后记录dao层实现类
 * @author T2planet
 * @date 2018年10月2日下午5:27:46
 */
public class CustomerSupportDaoImpl implements ICustomerSupportDao {
	private QueryRunner qr = JdbcUtil.getQueryRunner();
	private Connection conn = null;
	
	public CustomerSupportDaoImpl() {}
	
	public CustomerSupportDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void saveCusSup(CustomerSupport cusSupport) throws SQLException {
		String sql = "insert into `customer_support_list` values(?,?,?,?,?)";
		qr.update(conn,sql,CommonUtil.getUUID(),cusSupport.getOrderNum(),cusSupport.getProblem(),cusSupport.getHandler(),DateUtil.formatTime(new Date()));
	}

	@Override
	public void deleteCusSup(String csId) throws SQLException {
		String sql = "delete from `customer_support_list` where csId=?";
		qr.update(sql,csId);
	}

	@Override
	public void updateCusSup(CustomerSupport cusSupport) throws SQLException {
		String sql = "update `customer_support_list` set orderNum=?,problem=?,handler=?,handlerTime=? where csId=?";
		qr.update(sql,cusSupport.getOrderNum(),cusSupport.getProblem(),cusSupport.getHandler(),new Date(),cusSupport.getCsId());
	}

	@Override
	public List<CustomerSupport> getAllCusSup() throws SQLException {
		String sql = "select * from `customer_support_list`";
		List<CustomerSupport> cusSupList = qr.query(sql, new BeanListHandler<CustomerSupport>(CustomerSupport.class));
		return cusSupList;
	}

	@Override
	public CustomerSupport getCusSupById(String csId) throws SQLException {
		String sql = "select * from `customer_support_list` where csId=?";
		CustomerSupport cusSupBean = qr.query(sql, new BeanHandler<CustomerSupport>(CustomerSupport.class),csId);
		return cusSupBean;
	}

	@Override
	public List<CustomerSupport> fuzzyQuery(String orderNum, String goodsName, String cusCompany) throws SQLException {
		String sql = "select cs.csId,cs.orderNum,cs.problem,cs.`handler`,cs.handlerTime" + 
				" from customer_support_list cs inner join `order` o inner join customer c" + 
				" on o.orderNum=cs.orderNum and c.cid=o.cid" + 
				" where cs.orderNum like ? and o.goodsName like ? and c.cusCompany like ?";
		List<CustomerSupport> cusList = qr.query(sql, new BeanListHandler<CustomerSupport>(CustomerSupport.class),"%"+orderNum+"%","%"+goodsName+"%","%"+cusCompany+"%");
		return cusList;
	}

	@Override
	public List<CustomerSupport> getPageData(int index, int currentCount, String orderNum, String goodsName, String cusCompany) throws SQLException {
		//String sql = "select * from `customer_support_list` limit ?,?";
		String sql = "select cs.*" + 
				" from customer_support_list cs inner join `order` o inner join customer c" + 
				" on o.orderNum=cs.orderNum and c.cid=o.cid" + 
				" where cs.orderNum like ? and o.goodsName like ? and c.cusCompany like ?" + 
				" limit ?,?";
		List<CustomerSupport> pageList = qr.query(sql, new BeanListHandler<CustomerSupport>(CustomerSupport.class),"%"+orderNum+"%","%"+goodsName+"%","%"+cusCompany+"%",index,currentCount);
		return pageList;
	}

	@Override
	public Long getTotalCount(String orderNum, String goodsName, String cusCompany) throws SQLException {
		//String sql = "select count(1) from `customer_support_list`";
		String sql = "select count(1)" + 
				" from customer_support_list cs inner join `order` o inner join customer c" + 
				" on o.orderNum=cs.orderNum and c.cid=o.cid" + 
				" where cs.orderNum like ? and o.goodsName like ? and c.cusCompany like ?";
		Long totalCount = (Long)qr.query(sql, new ScalarHandler<>(),"%"+orderNum+"%","%"+goodsName+"%","%"+cusCompany+"%");
		return totalCount;
	}

	@Override
	public Map<String, Object> getMoreCusSupById(String csId) throws SQLException {
		String sql = "select cs.csId,cs.orderNum,cs.problem,cs.`handler`,cs.handlerTime,o.goodsName,o.goodsCount,c.cusCompany " + 
				"from customer_support_list cs inner join `order` o inner join customer c " + 
				"on cs.orderNum=o.orderNum and o.cid=c.cid " + 
				"where cs.csid=?";
		Map<String, Object> map = qr.query(sql, new MapHandler(),csId);
		return map;
	}

}
