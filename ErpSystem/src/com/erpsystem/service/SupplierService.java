package com.erpsystem.service;

import java.sql.SQLException;

import com.erpsystem.dao.entity.Supplier;

public interface SupplierService {
	public void addSupplier(Supplier supplier) throws SQLException;
	public void edit(Supplier supplier) throws SQLException;
	public void delete(String sId) throws SQLException;
	public Supplier queryById(String sId) throws SQLException;
	public Supplier queryByCompany(String supCompany) throws SQLException;
}
