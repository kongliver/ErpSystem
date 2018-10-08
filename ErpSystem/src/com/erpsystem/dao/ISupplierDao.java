package com.erpsystem.dao;


import java.sql.SQLException;
import java.util.List;

import com.erpsystem.domain.Supplier;

/**
 * 
 * @功能描述 供应商dao层接口
 * @作者	唐华禹
 * @时间 2018年10月8日 上午9:54:39
 * @地点 成都
 *
 */

public interface ISupplierDao {
	/**
	 * 增加供应商
	 * @throws SQLException
	 */
	public void addSupplier(Supplier supplier) throws SQLException;
	/**
	 * 修改供应商
	 * @throws SQLException
	 */
	public void editSupplier(Supplier supplier) throws SQLException;
	/**
	 * 删除供应商
	 * @throws SQLException
	 */
	public void deleteSupplier(String sId) throws SQLException;
	/**
	 * 根据供应商id来查询供应商
	 * @throws SQLException
	 */
	public Supplier getById(String sId) throws SQLException;
	/**
	 * 根据公司名称查询供应商
	 * @throws SQLException
	 */
	public Supplier getByCompany(String supCompany) throws SQLException;
	/**
	 * 查询所有供应商
	 * @return
	 * @throws SQLException 
	 */
	public List<Supplier> getAllSupplier() throws SQLException;
	/**
	 * 分页查询数据
	 * @param index  当前从第几条开始查询
	 * @param currentCount  一页的条数
	 * @return
	 * @throws SQLException 
	 */
	public List<Supplier> getPage(Integer index, Integer currentCount) throws SQLException;
	
	/**
	 * 获取总共由多少条记录
	 * @return 返回总记录条数
	 * @throws SQLException
	 */
	public Long getTotalCount() throws SQLException;
	
}
