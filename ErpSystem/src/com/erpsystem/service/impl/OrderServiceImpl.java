package com.erpsystem.service.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.erpsystem.dao.IOrderDao;
import com.erpsystem.dao.impl.OrderDaoImpl;
import com.erpsystem.domain.Order;
import com.erpsystem.domain.PageBean;
import com.erpsystem.service.IOrderService;
import com.erpsystem.utils.PrimaryKeyUtil;

/**
 * @功能 为订单提供服务的实现类
 * @文件 OrderServiceImpl.java
 * @作者 张洪刚
 * @时间 2018-10-01 08:52
 * @地点 成都
 */
public class OrderServiceImpl implements IOrderService {
	IOrderDao dao = new OrderDaoImpl();

	
	@Override
	public PageBean<Order> findAll(Integer currentCount, Integer currentPage) throws SQLException {
		PageBean<Order> pageBean = new PageBean<>();    //创建分页需要的javabean
		
		//1、封装条数
		pageBean.setCurrentCount(currentCount);
		
		//2、封装当前页
		pageBean.setCurrentPage(currentPage);
		
		//3、封装总条数
		Integer totalCount = dao.findCount();
		pageBean.setTotalCount(totalCount);
		//4、封装总页数
		Integer totalPage =(int)Math.ceil(totalCount * 1.0 / currentCount);
		pageBean.setTotalPage(totalPage);
		
		//5、封装当前页显示的订单
		Integer index = (currentPage - 1) * currentCount;     //当前页 - 1 * 一页的条数  = 当前从多少条查询
		List<Order> pageList = dao.findPage(index, currentCount);
		pageBean.setList(pageList);
		return pageBean;
	}


	@Override
	public List<Order> findAll() throws SQLException {
		return dao.findAll();
	}


	@Override
	public Order findById(Long id) throws SQLException {
		return dao.finById(id);
	}


	@Override
	public void insertOrder(Order order) throws SQLException {
		Date date = new Date();
		String maxKey = dao.findMaxKey();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 设置日期格式
		String newDateStr = df.format(date).toString();
		order.setBeginTime(newDateStr);
		
		Long Key = PrimaryKeyUtil.getOrderPrimarKey(date, maxKey);
		order.setOrderNum(Key);
		 
		dao.save(order);
	}
	
	
	
	
}
