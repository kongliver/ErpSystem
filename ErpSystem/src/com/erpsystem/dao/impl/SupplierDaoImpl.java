package com.erpsystem.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.erpsystem.dao.SupplierDao;
import com.erpsystem.dao.entity.Supplier;
import com.erpsystem.utils.JdbcUtil;



public class SupplierDaoImpl implements SupplierDao {
	
	QueryRunner qr = new QueryRunner(JdbcUtil.getQueryRunner());
	@Override
	public void addSupplier(Supplier supplier) throws SQLException {
		String sql = "insert into provider values(?,?,?,?,?)";
		qr.update(sql,supplier.getsId(),supplier.getSupCompany(),supplier.getSupAddress(),
				supplier.getSupContacts(),supplier.getSupPhone());

	}

	@Override
	public void editSupplier(Supplier supplier) throws SQLException {
		String sql="update supplier set sid=?,supCompany=?,supAddress=?,supContacts=?,supPhone=?";
		qr.update(sql,supplier.getsId(),supplier.getSupCompany(),supplier.getSupAddress(),
				supplier.getSupContacts(),supplier.getSupPhone());

	}

	@Override
	public void deleteSupplier(String sId) throws SQLException {
		String sql = "delete from supplier where sid=?";
		qr.update(sql,sId);

	}

	@Override
	public Supplier queryById(String sId) throws SQLException {
		String sql = "select * from supplier where sid=?";
		Supplier supplier = qr.query(sql, new BeanHandler<Supplier>(Supplier.class),sId);
		return supplier;
	}

	@Override
	public Supplier queryByCompany(String supCompany) throws SQLException {
		String sql = "select * from supplier where sid=?";
		Supplier supplier = qr.query(sql, new BeanHandler<Supplier>(Supplier.class),supCompany);
		return supplier;
	}

}
