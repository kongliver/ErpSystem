package com.erpsystem.service.impl;

import java.sql.SQLException;

import com.erpsystem.dao.SupplierDao;
import com.erpsystem.dao.entity.Supplier;
import com.erpsystem.dao.impl.SupplierDaoImpl;
import com.erpsystem.service.SupplierService;

public class SupplierServiceImpl implements SupplierService {
	
	SupplierDao supplierDao=null;
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
	public Supplier queryById(String sId) throws SQLException {
		
		return supplierDao.queryById(sId);
	}

	@Override
	public Supplier queryByCompany(String supCompany) throws SQLException {
		
		return supplierDao.queryByCompany(supCompany);
	}

}
