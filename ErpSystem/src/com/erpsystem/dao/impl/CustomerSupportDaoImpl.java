package com.erpsystem.dao.impl;

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
		
		qr.update(sql,CommonUtil.getUUID(),cusSupport.getOrderNum(),cusSupport.getProblem(),cusSupport.getHandler(),new Date());
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
		qr.update(sql,cusSupport.getOrderNum(),cusSupport.getProblem(),cusSupport.getHandler(),new Date(),cusSupport.getCsId());
		System.out.println("修改售后记录成功");
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
		System.out.println("售后模糊查询成功");
		return cusList;
	}

	@Override
	public List<CustomerSupport> getPageData(int index, int currentCount) throws SQLException {
		String sql = "select * from `customer_support_list` limit ?,?";
		List<CustomerSupport> pageList = qr.query(sql, new BeanListHandler<CustomerSupport>(CustomerSupport.class),index,currentCount);
		return pageList;
	}

	@Override
	public Long getTotalCount() throws SQLException {
		String sql = "select count(1) from `customer_support_list`";
		Long totalCount = (Long)qr.query(sql, new ScalarHandler());
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
