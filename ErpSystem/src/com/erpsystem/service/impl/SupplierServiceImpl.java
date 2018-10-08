package com.erpsystem.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.erpsystem.dao.ISupplierDao;

import com.erpsystem.dao.impl.SupplierDaoImpl;

import com.erpsystem.domain.PageBean;
import com.erpsystem.domain.Supplier;
import com.erpsystem.service.ISupplierService;
/**
 * 
 * @功能描述 供应商service实现类
 * @作者	唐华禹
 * @时间 2018年10月8日 上午10:08:23
 * @地点 成都
 *
 */

public class SupplierServiceImpl implements ISupplierService {
	
	ISupplierDao supplierDao=null;
	public SupplierServiceImpl() {
		supplierDao=new SupplierDaoImpl();
	}
	@Override
	public void addSupplier(Supplier supplier) throws SQLException {
		supplierDao.addSupplier(supplier);

		
	}
	@Override
	public void edit(Supplier supplier) throws SQLException {
		supplierDao.editSupplier(supplier);
		
	}
	@Override
	public void delete(String sId) throws SQLException {
		supplierDao.deleteSupplier(sId);
		
	}
	@Override
	public Supplier getById(String sId) throws SQLException {
		// TODO Auto-generated method stub
		return supplierDao.getById(sId);
	}
	@Override
	public Supplier getByCompany(String supCompany) throws SQLException {
		// TODO Auto-generated method stub
		return supplierDao.getByCompany(supCompany);
	}
	@Override
	public List<Supplier> getAllSupplier() throws SQLException {
		List<Supplier> supplierList = supplierDao.getAllSupplier();
		return supplierList;
	}
	@Override
	public PageBean<Supplier> getPage(Integer currentCount, Integer currentPage) throws SQLException {
		PageBean<Supplier> pageBean = new PageBean<Supplier>();
		//设置一页显示多少条
		pageBean.setCurrentCount(currentCount);
		//设置当前页码
		pageBean.setCurrentPage(currentPage);
		//获取共有多少条记录
		Long totalCount = supplierDao.getTotalCount();
		pageBean.setTotalCount(totalCount.intValue());
		//获取总页数
		double totalPage = Math.ceil(1.0 * pageBean.getTotalCount() / pageBean.getCurrentCount());
		pageBean.setTotalPage((int)totalPage);
		
		// 当前页查询的角标
	    int index = (currentPage - 1) * currentCount;
		
	    List<Supplier> pageData = supplierDao.getPage(index, currentCount);
		pageBean.setList(pageData);
		
		return pageBean;
	}
	

}
