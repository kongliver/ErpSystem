package com.erpsystem.service;

import java.sql.SQLException;

import com.erpsystem.domain.Customer;
import com.erpsystem.domain.PageBean;

/**
 * @功能 用来提供客户服务的接口
 * @文件 ICustomerSerivce.java
 * @作者 张洪刚
 * @时间 2018-10-01 18:04
 * @地点 成都
 */
public interface ICustomerSerivce {

	/**
	 *  查询客户， 包括两个查询条件, 分页查询
	 * @param unmae
	 * @param orderNum
	 */
	PageBean<Customer> findAll(String unmae, String orderNum, Integer currentPage) throws SQLException ;

	/**
	 * 删除客户的服务
	 * @param cid
	 * @throws SQLException
	 */
	void delete(String cid)throws SQLException ;

	/**
	 * 根据客户id查询
	 * @param cid
	 * @return
	 * @throws SQLException
	 */
	Customer findById(String cid) throws SQLException ;

	/**
	 * 修改客户信息的方法
	 * @param customer
	 */
	void update(Customer customer)throws SQLException ;

	/**
	 * 保存客户的方法
	 * @param customer
	 * @throws SQLException
	 */
	void save(Customer customer)throws SQLException;

}
