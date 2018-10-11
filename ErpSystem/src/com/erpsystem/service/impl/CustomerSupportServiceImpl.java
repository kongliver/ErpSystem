package com.erpsystem.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.erpsystem.dao.ICustomerSupportDao;
import com.erpsystem.dao.impl.CustomerSupportDaoImpl;
import com.erpsystem.domain.CustomerSupport;
import com.erpsystem.domain.Order;
import com.erpsystem.domain.PageBean;
import com.erpsystem.service.ICustomerSupportService;
import com.erpsystem.service.IOrderService;
import com.erpsystem.utils.JdbcUtil;

public class CustomerSupportServiceImpl implements ICustomerSupportService {
	private ICustomerSupportDao cusSupDao = new CustomerSupportDaoImpl();
	
	
	@Override
	public void saveCusSup(CustomerSupport cusSup) throws SQLException {
		Connection conn = JdbcUtil.getConn();
		IOrderService orderService = new OrderServiceImpl();
		ICustomerSupportDao csDao = new CustomerSupportDaoImpl(conn);
		// 开启事务
		conn.setAutoCommit(false);
		
		Order order = orderService.findById(cusSup.getOrderNum());
//		System.out.println("order是："+order);
		if(order == null) {
			conn.rollback();
			throw new RuntimeException("该订单不存在！");
		}
		csDao.saveCusSup(cusSup);
		orderService.updateOrderStatu(cusSup.getOrderNum(), 4);
		
		conn.commit();
	}

	@Override
	public void deleteCusSup(String csId) throws SQLException {
		cusSupDao.deleteCusSup(csId);
	}

	@Override
	public void updateCusSup(CustomerSupport cusSup) throws SQLException {
		cusSupDao.updateCusSup(cusSup);
	}

	@Override
	public List<CustomerSupport> getAllCusSup() throws SQLException {
		List<CustomerSupport> cusSupList = cusSupDao.getAllCusSup();
		return cusSupList;
	}

	@Override
	public CustomerSupport getCusSupById(String csId) throws SQLException {
		CustomerSupport cusSup = cusSupDao.getCusSupById(csId);
		return cusSup;
	}

	@Override
	public List<CustomerSupport> fuzzyQuery(String orderNum, String goodsName, String cusCompany) throws SQLException {
		List<CustomerSupport> fuzzyList = cusSupDao.fuzzyQuery(orderNum, goodsName, cusCompany);
		return fuzzyList;
	}

	@Override
	public PageBean<CustomerSupport> getPageBean(int currentPage,int currentCount,String orderNum, String goodsName, String cusCompany) throws SQLException {
		PageBean<CustomerSupport> pageBean = new PageBean<CustomerSupport>();
		//设置一页显示多少条
		pageBean.setCurrentCount(currentCount);
		//设置当前页码
		pageBean.setCurrentPage(currentPage);
		//获取共有多少条记录
		Long totalCount = cusSupDao.getTotalCount(orderNum,goodsName,cusCompany);
		pageBean.setTotalCount(totalCount.intValue());
		//获取总页数
		double totalPage = Math.ceil(1.0 * pageBean.getTotalCount() / pageBean.getCurrentCount());
		pageBean.setTotalPage((int)totalPage);
		
		// 当前页查询的角标
	    int index = (currentPage - 1) * currentCount;
		
	    List<CustomerSupport> pageData = cusSupDao.getPageData(index, currentCount, orderNum, goodsName, cusCompany);
		pageBean.setList(pageData);
		
		return pageBean;
	}

	@Override
	public Map<String, Object> getMoreCusSupById(String csId) throws SQLException {
		Map<String, Object> moreMap = cusSupDao.getMoreCusSupById(csId);
		return moreMap;
	}

}
