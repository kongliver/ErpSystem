package com.erpsystem.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.erpsystem.dao.ICustomerDao;
import com.erpsystem.dao.impl.CustomerDaoImpl;
import com.erpsystem.domain.Customer;
import com.erpsystem.domain.Order;
import com.erpsystem.domain.PageBean;
import com.erpsystem.service.ICustomerSerivce;
import com.erpsystem.utils.CommonUtil;
import com.erpsystem.utils.PrimaryKeyUtil;

/**
 * @功能 用来提供客户服务的实现类
 * @文件 CustomerServiceImpl.java
 * @作者 张洪刚
 * @时间 2018-10-01 18:05
 * @地点 成都
 */
public class CustomerServiceImpl implements ICustomerSerivce{
	ICustomerDao dao = new CustomerDaoImpl();
	@Override
	public PageBean<Customer> findAll(String unmae, String phone, Integer currentPage) throws SQLException {
		PageBean<Customer> pageBean = new PageBean<>();
		
		pageBean.setCurrentCount(10);
		
		pageBean.setCurrentPage(currentPage);

		
		//封装总条数
		Integer totalCount = dao.findCount(unmae, phone);
		
		pageBean.setTotalCount(totalCount);
		
		Integer totalPage =(int)Math.ceil(totalCount * 1.0 / 10);
		
		pageBean.setTotalPage(totalPage);
		
		Integer index = (currentPage - 1) * 10;     //当前页 - 1 * 一页的条数  = 当前从多少条查询
		List<Customer> pageList = null ;
		
		if(!"".equals(phone.trim()) && !"".equals(unmae.trim())) {
			 pageList = dao.findPage(index, 10, unmae, phone);
		}else if("".equals(phone.trim()) && "".equals(unmae.trim())){
			pageList = dao.findPage(index, 10);
		}else if(!"".equals(phone.trim()) && "".equals(unmae.trim())) {
			 pageList = dao.findPage(index, 10, phone);
		}else if("".equals(phone.trim()) && !"".equals(unmae.trim())) {
			pageList = dao.findPageByName(index, 10, unmae);
		}
		pageBean.setList(pageList);
		return pageBean;
		
	}
	
	
	@Override
	public List<Customer> findAll() throws SQLException {
		
		return dao.findAll();
	}
	
	
	@Override
	public void delete(String cid) throws SQLException {
		dao.delete(cid);
	}
	@Override
	public Customer findById(String cid) throws SQLException {
		return dao.findById(cid);
	}
	@Override
	public void update(Customer customer) throws SQLException {
		dao.update(customer);
	}
	@Override
	public void save(Customer customer) throws SQLException {
	
		customer.setCid(CommonUtil.getUUID());
		dao.save(customer);
		
	}


	
}
