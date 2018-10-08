package com.erpsystem.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.erpsystem.dao.ISupplierDao;
import com.erpsystem.domain.Supplier;
import com.erpsystem.utils.CommonUtil;

import com.erpsystem.utils.JdbcUtil;
/**
 * 
 * @功能描述 供应商dao层实现类
 * @作者	唐华禹
 * @时间 2018年10月8日 上午10:00:26
 * @地点 成都
 *
 */



public class SupplierDaoImpl implements ISupplierDao {
	
	private QueryRunner qr = JdbcUtil.getQueryRunner();
	@Override
	public void addSupplier(Supplier supplier) throws SQLException {
		String sql = "insert into `supplier` values(?,?,?,?,?)";
		qr.update(sql,CommonUtil.getUUID(),supplier.getSupCompany(),supplier.getSupAddress(),
				supplier.getSupContacts(),supplier.getSupPhone());

	}

	@Override
	public void editSupplier(Supplier supplier) throws SQLException {
		String sql="update `supplier` set supCompany=?,supAddress=?,supContacts=?,supPhone=?";
		qr.update(sql,supplier.getSupCompany(),supplier.getSupAddress(),
				supplier.getSupContacts(),supplier.getSupPhone());

	}

	@Override
	public void deleteSupplier(String sId) throws SQLException {
		String sql = "delete from `supplier` where sid=?";
		qr.update(sql,sId);

	}

	@Override
	public Supplier getById(String sId) throws SQLException {
		String sql = "select * from `supplier` where sid=?";
		Supplier supplier = qr.query(sql, new BeanHandler<Supplier>(Supplier.class),sId);
		return supplier;
	}

	@Override
	public Supplier getByCompany(String supCompany) throws SQLException {
		String sql = "select * from `supplier` where sid=?";
		Supplier supplier = qr.query(sql, new BeanHandler<Supplier>(Supplier.class),supCompany);
		return supplier;
	}

	@Override
	public List<Supplier> getAllSupplier() throws SQLException {
		String sql = "select * from `supplier`";
		List<Supplier> supplierList = qr.query(sql, new BeanListHandler<Supplier>(Supplier.class));
		return supplierList;
	}

	@Override
	public List<Supplier> getPage(Integer index, Integer currentCount) throws SQLException {
		String sql = "select * from `supplier` limit ?,?";
		List<Supplier> pageList = qr.query(sql, new BeanListHandler<Supplier>(Supplier.class),index,currentCount);
		return pageList;
	}

	

	@Override
	public Long getTotalCount() throws SQLException {
		String sql = "select count(1) from `customer_support_list`";
		Long totalCount = (Long)qr.query(sql, new ScalarHandler<>());
		return totalCount;
	}

}
