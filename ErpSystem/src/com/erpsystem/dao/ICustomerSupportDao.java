package com.erpsystem.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
	public void saveCusSup(CustomerSupport cusSupport,Connection conn) throws SQLException;
	
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
	 * 根据售后id来查询基本的售后记录
	 * @param csId 传入售后id
	 * @return 返回相应的CustomerSupport实体类
	 */
	public CustomerSupport getCusSupById(String csId) throws SQLException;
	
	/**
	 * 根据售后id查询更多售后详情（加上商品名称、数量、订货公司）
	 * @param csId 售后id
	 * @return 返回封装了相应售后数据的map集合
	 */
	public Map<String,Object> getMoreCusSupById(String csId) throws SQLException;
	
	/**
	 * 售后模糊查询
	 * @param orderNum 订单号
	 * @param goodsName 商品名称
	 * @param cusCompany 公司名
	 * @return 返回封装了售后实体类的list集合
	 */
	public List<CustomerSupport> fuzzyQuery(String orderNum, String goodsName, String cusCompany) throws SQLException;
	
	/**
	 * 获取分页数据
	 * @param index 从第几条数据开始
	 * @param currentCount 查多少条数据
	 * @return 返回当前页的所有数据
	 */
	public List<CustomerSupport> getPageData(int index, int currentCount) throws SQLException;
	
	/**
	 * 获取总共由多少条记录
	 * @return 返回总记录条数
	 * @throws SQLException
	 */
	public Long getTotalCount() throws SQLException;
	
	
}
