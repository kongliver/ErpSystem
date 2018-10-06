package com.erpsystem.dao;

import java.sql.SQLException;

import com.erpsystem.dao.entity.Supplier;

public interface SupplierDao {
	public void addSupplier(Supplier supplier) throws SQLException;
	public void editSupplier(Supplier supplier) throws SQLException;
	public void deleteSupplier(String sId) throws SQLException;
	public Supplier queryById(String sId) throws SQLException;
	public Supplier queryByCompany(String supCompany) throws SQLException;
}
