package com.erpsystem.dao;

import java.sql.SQLException;
import java.util.List;

import com.erpsystem.domain.CustomerSupport;

/**
 * 
 * @Description 售后记录dao层的接口
 * @author T2planet
 * @date 2018年10月2日下午5:11:43
 */
public interface ICustomerSupportDao {
	/**
	 * 添加售后记录
	 * @param cusSupport 传入售后记录的实体类
	 */
	public void saveCusSup(CustomerSupport cusSupport) throws SQLException;
	
	/**
	 * 根据售后编号来删除相应售后记录
	 * @param csId 传入售后记录的编号
	 */
	public void deleteCusSup(String csId) throws SQLException;
	
	/**
	 * 修改售后记录
	 * @param cusSupport 传入售后记录的实体类
	 */
	public void updateCusSup(CustomerSupport cusSupport) throws SQLException;
	
	/**
	 * 查询所有售后记录
	 * @return 返回List(CustomerSupport)集合
	 */
	public List<CustomerSupport> getAllCusSup() throws SQLException;
	
	/**
	 * 根据售后id来查询售后记录
	 * @param csId 传入售后id
	 * @return 返回相应的CustomerSupport实体类
	 */
	public CustomerSupport getCupSupById(String csId) throws SQLException;
	
	
}
