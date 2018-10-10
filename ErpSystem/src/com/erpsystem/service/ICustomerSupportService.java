package com.erpsystem.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.erpsystem.domain.CustomerSupport;
import com.erpsystem.domain.PageBean;

/**
 * 
 * @Description 售后service接口
 * @author T2planet
 * @date 2018年10月4日下午2:05:12
 */
public interface ICustomerSupportService {
	/**
	 * 新增售后记录
	 * @param cusSup 传入售后实体类
	 */
	public void saveCusSup(CustomerSupport cusSup) throws SQLException;
	/**
	 * 删除售后记录
	 * @param csId 传入售后的csId
	 */
	public void deleteCusSup(String csId) throws SQLException;
	/**
	 * 修改售后记录
	 * @param cusSup 传入售后实体类
	 */
	public void updateCusSup(CustomerSupport cusSup) throws SQLException;
	/**
	 * 查询所有售后记录
	 * @return 返回封装了售后实体类的list集合
	 */
	public List<CustomerSupport> getAllCusSup() throws SQLException;
	
	/**
	 * 根据csId查询基本单条售后记录
	 * @param csId 售后记录编号csId
	 * @return 返回单挑售后实体类
	 */
	public CustomerSupport getCusSupById(String csId) throws SQLException;
	/**
	 * 根据csId查询更多单条售后详情（加上商品名称、数量、订货公司名）
	 * @param csId 售后csId
	 * @return 封装了更多详情的map集合
	 * @throws SQLException
	 */
	public Map<String,Object> getMoreCusSupById(String csId) throws SQLException;
	
	/**
	 * 售后模糊查询
	 * @param orderNum 订单号(先定义为String)
	 * @param goodsName 商品名称
	 * @param cusCompany 客户公司名
	 * @return 返回封装了售后实体类的list集合
	 */
	public List<CustomerSupport> fuzzyQuery(String orderNum,String goodsName,String cusCompany) throws SQLException;
	
	/**
	 * 当前分页的所有数据（售后记录）
	 * @param currentPage 当前页码
	 * @param currentCount 一页有几条
	 * @return 当前分页的对象
	 * @throws SQLException
	 */
	public PageBean<CustomerSupport> getPageBean(int currentPage,int currentCount,String orderNum, String goodsName, String cusCompany) throws SQLException;
	
}