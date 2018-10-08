package com.erpsystem.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.erpsystem.dao.IPurchaseNoteDao;
import com.erpsystem.domain.ProductStock;
import com.erpsystem.domain.PurchaseNote;
import com.erpsystem.utils.DruidConnection;


public class PurchaseNoteDaoImpl implements IPurchaseNoteDao {
	QueryRunner qr = new QueryRunner(DruidConnection.getDataSource());
	
	@Override
	public List<ProductStock> queryAllProduct() throws SQLException {
		String sql = "select * from product_stock";
		return qr.query(sql, new BeanListHandler<ProductStock>(ProductStock.class));
	}

	@Override
	public ProductStock queryOneProduct(String psid) throws SQLException {
		String sql = "select * from product_stock where psid = ?";
		return qr.query(sql, new BeanHandler<ProductStock>(ProductStock.class), psid);
	
	}

	@Override
	public int addTable(PurchaseNote purchaseNote) throws SQLException {
		String sql = "insert into purchase_note values(?,?,?,?,?,?,?) ";
		int num = qr.update(sql, purchaseNote.getPnid(),purchaseNote.getPsid() ,purchaseNote.getPurchaseCount(), purchaseNote.getPurTotalMoney(),purchaseNote.getPurchaseTime(),purchaseNote.getBuyer(),
								 purchaseNote.getSid());
		return num;
	}
	
	@Override
	public int deleteTables(String pnid) throws SQLException {
		String sql = "delete from purchase_note where pnid = ?";
		return qr.update(sql,pnid);
	}

	@Override
	public int updateTable(PurchaseNote purchaseNote) throws SQLException {
		String sql = "update purchase_note set psid = ?, purchaseCount = ? , purTotalMoney = ?,purchaseTime = ?,"
				+ " buyer =? ,sid=? where pnid = ?";
		return qr.update(sql, purchaseNote.getPsid() ,purchaseNote.getPurchaseCount(), purchaseNote.getPurTotalMoney(),purchaseNote.getPurchaseTime(),purchaseNote.getBuyer(),
								 purchaseNote.getSid(), purchaseNote.getPnid());
	}
	
	@Override
	public List<PurchaseNote> queryTable() throws SQLException {
		String sql = "select * from purchase_note";
		return qr.query(sql, new BeanListHandler<PurchaseNote>(PurchaseNote.class));
	}

	@Override
	public PurchaseNote getOne(String pnid) throws SQLException {
		String sql = "select * from purchase_note where pnid = ?";
		return qr.query(sql, new BeanHandler<PurchaseNote>(PurchaseNote.class), pnid);
	}
}
