package com.erpsystem.service.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.erpsystem.dao.ICustomerDao;
import com.erpsystem.dao.IOrderDao;
import com.erpsystem.dao.IProductStockDao;
import com.erpsystem.dao.impl.CustomerDaoImpl;
import com.erpsystem.dao.impl.OrderDaoImpl;
import com.erpsystem.dao.impl.ProductStockDaoImpl;
import com.erpsystem.domain.Customer;
import com.erpsystem.domain.Order;
import com.erpsystem.domain.PageBean;
import com.erpsystem.domain.ProductStock;
import com.erpsystem.service.IOrderService;
import com.erpsystem.service.IProductStockService;
import com.erpsystem.utils.DateUtil;
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

	IProductStockDao stockDao = new ProductStockDaoImpl();

	ICustomerDao customerDao = new CustomerDaoImpl();
	
	IProductStockService product = new ProductStockServiceImpl();

	@Override
	public PageBean<Order> findAll(String cname, String orderNum, Integer orderType, Integer currentCount,
			Integer currentPage) throws SQLException {
		PageBean<Order> pageBean = new PageBean<>(); // 创建分页需要的javabean

		// 1、封装条数
		pageBean.setCurrentCount(currentCount);

		// 2、封装当前页
		pageBean.setCurrentPage(currentPage);

		// 3、封装总条数
		Integer totalCount = 0;

		// 3、封装总条数
		if (orderType == 0) {
			totalCount = dao.findCount(cname, orderNum);
		} else {
			totalCount = dao.findCount(cname, orderNum, orderType);
		}
		
		pageBean.setTotalCount(totalCount);
		// 4、封装总页数
		Integer totalPage = (int) Math.ceil(totalCount * 1.0 / currentCount);
		pageBean.setTotalPage(totalPage);

		// 5、封装当前页显示的订单
		Integer index = (currentPage - 1) * currentCount; // 当前页 - 1 * 一页的条数 = 当前从多少条查询

		List<Order> pageList = null;

		if (orderType != 0) {
			if (!"".equals(cname) && !"".equals(orderNum)) {
				pageList = dao.findPage(cname, orderNum, orderType, index, currentCount);
			} else if ("".equals(cname) && "".equals(orderNum)) {
				pageList = dao.findPage(orderType, index, currentCount);
			} else if (!"".equals(cname) && "".equals(orderNum)) {
				pageList = dao.findPage(cname, orderType, index, currentCount);
			} else if ("".equals(cname) && !"".equals(orderNum)) {
				pageList = dao.findPageByorderNum(orderNum, orderType, index, currentCount);
			}
		} else {

			if (!"".equals(cname) && !"".equals(orderNum)) {
				pageList = dao.findPage(cname, orderNum, index, currentCount);
			} else if ("".equals(cname) && "".equals(orderNum)) {
				pageList = dao.findPage(index, currentCount);
			} else if (!"".equals(cname) && "".equals(orderNum)) {
				pageList = dao.findPage(cname, index, currentCount);
			} else if ("".equals(cname) && !"".equals(orderNum)) {
				pageList = dao.findPageByorderNum(orderNum, index, currentCount);
			}

		}
		for (int i = 0; i < pageList.size(); i++) {
			Customer customer = customerDao.findById(pageList.get(i).getcId());
			if (null != customer) {
				pageList.get(i).setcId(customer.getCusCompany());
			}
			ProductStock stock = stockDao.getById(pageList.get(i).getGoodsName());
			if (null != stock) {
				pageList.get(i).setGoodsName(stock.getProductName());
			}

		}

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
	public boolean insertOrder(Order order, String oprPerson) throws SQLException {
		Date date = new Date();
		String maxKey = dao.findMaxKey();

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 设置日期格式
		String newDateStr = df.format(date).toString();
		order.setBeginTime(newDateStr);

		Long Key = PrimaryKeyUtil.getOrderPrimarKey(date, maxKey);
		order.setOrderNum(Key);
		boolean isSucceed = outStock(order, oprPerson);
		if(!isSucceed) {	
			order.setOrderType(1); // 新的订单的状态
		} else {
		    order.setEndTime(df.format(DateUtil.getNextDay(date)).toString());
		}
		dao.save(order);
		return isSucceed;
	}

	public boolean outStock(Order order, String oprPerson) throws SQLException {
							
		ProductStock productStock = stockDao.getById(order.getGoodsName());

		if (order.getGoodsCount() <= productStock.getProductCount()) {
//			productStock.setProductCount(productStock.getProductCount() - order.getGoodsCount()); // 减少库存
//			stockDao.updateCount(productStock.getPsid(), productStock.getProductCount());
			order.setOrderType(3);
			product.changeStock(productStock.getPsid(), order.getGoodsCount(), oprPerson, 2);
			return true;
		} else {
			return false;
		}
		
	}
	
	
	
	@Override
	public boolean outStock(Long orderNum, String oprPerson) throws SQLException {
		Order order = dao.finById(orderNum);

		ProductStock productStock = stockDao.getById(order.getGoodsName());

		if (order.getGoodsCount() <= productStock.getProductCount()) {
//			productStock.setProductCount(productStock.getProductCount() - order.getGoodsCount()); // 减少库存
//			stockDao.updateCount(productStock.getPsid(), productStock.getProductCount());
			updateOrderStatu(orderNum, 3); // 更改更新状态
			Date date = new Date();
            String endTime = DateUtil.formatTime(DateUtil.getNextDay(date));
            dao.updateEndTime(orderNum, endTime);
			product.changeStock(productStock.getPsid(), order.getGoodsCount(), oprPerson, 2);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void updateOrderStatu(Long orderNum, Integer statusCode) throws SQLException {
		dao.updateOrderStatu(orderNum, statusCode);
	}

}
