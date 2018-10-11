package com.erpsystem.dao;

import java.sql.SQLException;
import java.util.List;

import com.erpsystem.domain.Customer;
import com.erpsystem.domain.Order;

/**
 * @功能 用来提供客户的dao层的接口
 * @文件 ICustomerDao.java
 * @作者 张洪刚
 * @时间 2018-10-01 18:02
 * @地点 成都
 */
public interface ICustomerDao {

	/**
	 * 查询数据总条数
	 * @return
	 */
	Integer findCount(String unmae, String phone) throws SQLException ;

	/**
	 * 查询页码需要的数据
	 * @param index
	 * @param size
	 * @return
	 * @throws SQLException
	 */
	List<Customer> findPage(Integer index, Integer size, String unmae, String phone)throws SQLException;
	
	List<Customer> findPage(Integer index, Integer size, String phone)throws SQLException;
	
	List<Customer> findPage(Integer index, Integer size)throws SQLException;
	
	List<Customer> findPageByName(Integer index, Integer size, String unmae)throws SQLException;

	void delete(String cid) throws SQLException;

	Customer findById(String cid) throws SQLException;

	void update(Customer customer)throws SQLException;

	void save(Customer customer)throws SQLException;

	List<Customer> findAll()throws SQLException ;

}
