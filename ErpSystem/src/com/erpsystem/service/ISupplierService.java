package com.erpsystem.service;

import java.sql.SQLException;
import java.util.List;

import com.erpsystem.domain.PageBean;
import com.erpsystem.domain.Supplier;



public interface ISupplierService {
	/**
	 * 
	 * 增加供应商的方法
	 * @throws SQLException
	 */
	public void addSupplier(Supplier supplier) throws SQLException;
	/**
	 * 
	 * 修改供应商的方法
	 * @throws SQLException
	 */
	public void edit(Supplier supplier) throws SQLException;
	/**
	 * 
	 * 删除供应商的方法
	 * @throws SQLException
	 */
	public void delete(String sId) throws SQLException;
	/**
	 * 
	 * 根据id查询供应商的方法
	 * @return
	 * @throws SQLException
	 */
	public Supplier getById(String sId) throws SQLException;
	/**
	 * 
	 * 根据公司名称查询供应商的方法
	 * @return
	 * @throws SQLException
	 */
	public List<Supplier> getByCompany(String supCompany) throws SQLException;
	
	/**
	 * 查询所有供应商
	 * @return
	 * @throws SQLException 
	 */
	public List<Supplier> getAllSupplier() throws SQLException;
	/**
	 * 当前分页的所有数据（供应商）
	 * @param currentPage 当前页码
	 * @param currentCount 一页有几条
	 * @return 当前分页的对象
	 * @throws SQLException
	 */
	public PageBean<Supplier> getPage(String supCompany,int currentCount, int currentPage) throws SQLException;
}
