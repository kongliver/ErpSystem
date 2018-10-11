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
import com.erpsystem.utils.DruidConnection;

/**
 * 
 * @功能描述 供应商dao层实现类
 * @作者	唐华禹
 * @时间 2018年10月8日 上午10:00:26
 * @地点 成都
 *
 */



public class SupplierDaoImpl implements ISupplierDao {
	
//	private QueryRunner qr = JdbcUtil.getQueryRunner();
//	private Connection conn = null;
//	
//	public SupplierDaoImpl() {}
//	
//	
//	public SupplierDaoImpl(Connection conn) {
//		this.conn = conn;
//	}
	@Override
	public void addSupplier(Supplier supplier) throws SQLException {
		QueryRunner qr = new QueryRunner(DruidConnection.getDataSource());
		String sql = "insert into `supplier` values(?,?,?,?,?)";
		qr.update(sql,CommonUtil.getUUID(),supplier.getSupCompany(),supplier.getSupAddress(),
				supplier.getSupContacts(),supplier.getSupPhone());
		
	}

	@Override
	public void editSupplier(Supplier supplier) throws SQLException {
		QueryRunner qr = new QueryRunner(DruidConnection.getDataSource());
		String sql="update `supplier` set supCompany=?,supAddress=?,supContacts=?,supPhone=? where sid=?";
		qr.update(sql,supplier.getSupCompany(),supplier.getSupAddress(),
				supplier.getSupContacts(),supplier.getSupPhone(),supplier.getsId());
		
	}

	@Override
	public void deleteSupplier(String sid) throws SQLException {
		QueryRunner qr = new QueryRunner(DruidConnection.getDataSource());
		String sql = "delete from `supplier` where sid=?";
		qr.update(sql,sid);

	}

	@Override
	public Supplier getById(String sid) throws SQLException {
		QueryRunner qr = new QueryRunner(DruidConnection.getDataSource());
		String sql = "select * from `supplier` where sid=?";
		Supplier supplier = qr.query(sql, new BeanHandler<Supplier>(Supplier.class),sid);
		return supplier;
	}

	@Override
	public List<Supplier> getByCompany(String supCompany) throws SQLException {
		QueryRunner qr = new QueryRunner(DruidConnection.getDataSource());
		String sql = "select * from `supplier` where supCompany like ?";
		List<Supplier> supplierList = qr.query(sql, new BeanListHandler<Supplier>(Supplier.class),"%"+supCompany+"%");
		return supplierList;
	}

	@Override
	public List<Supplier> getAllSupplier() throws SQLException {
		QueryRunner qr = new QueryRunner(DruidConnection.getDataSource());
		String sql = "select * from `supplier`";
		List<Supplier> supplierList = qr.query(sql, new BeanListHandler<>(Supplier.class));
		return supplierList;
	}

	@Override
	public List<Supplier> getPage(String supCompany, int currentCount,int index) throws SQLException {
		QueryRunner qr = new QueryRunner(DruidConnection.getDataSource());
		String sql = "select * from `supplier` where supCompany like ?  limit ?,?";
		List<Supplier> pageList = qr.query(sql, new BeanListHandler<Supplier>(Supplier.class),"%"+supCompany+"%",index,currentCount);
		return pageList;
	}

	

	@Override
	public Long getTotalCount(String supCompany) throws SQLException {
		QueryRunner qr = new QueryRunner(DruidConnection.getDataSource());
		String sql = "select count(1) from `supplier` where supCompany like ?";
		Long totalCount = (Long)qr.query(sql, new ScalarHandler<>(),"%"+supCompany+"%");
		return totalCount;
	}

}
