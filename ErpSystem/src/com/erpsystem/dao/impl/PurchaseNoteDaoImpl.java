package com.erpsystem.dao.impl;
/**
 *  采购单
 */
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
	

	/**
	 * 添加采购单
	 */
	@Override
	public int addTable(PurchaseNote purchaseNote) throws SQLException {
		String sql = "insert into purchase_note values(?,?,?,?,?,?,?) ";
		int num = qr.update(sql, purchaseNote.getPnid(),purchaseNote.getPsid() ,purchaseNote.getPurchaseCount(), purchaseNote.getPurTotalMoney(),purchaseNote.getPurchaseTime(),purchaseNote.getBuyer(),
								 purchaseNote.getSid());
		return num;
	}
	/**
	 * 删除采购单
	 */
	@Override
	public int deleteTables(String pnid) throws SQLException {
		String sql = "delete from purchase_note where pnid = ?";
		return qr.update(sql,pnid);
	}
	/**
	 * 修改采购单
	 */
	@Override
	public int updateTable(PurchaseNote purchaseNote) throws SQLException {
		String sql = "update purchase_note set psid = ?, purchaseCount = ? , purTotalMoney = ?,purchaseTime = ?,"
				+ " buyer =? ,sid=? where pnid = ?";
		return qr.update(sql, purchaseNote.getPsid() ,purchaseNote.getPurchaseCount(), purchaseNote.getPurTotalMoney(),purchaseNote.getPurchaseTime(),purchaseNote.getBuyer(),
								 purchaseNote.getSid(), purchaseNote.getPnid());
	}
	/**
	 * 查询所有采购单
	 */
	@Override
	public List<PurchaseNote> queryTable() throws SQLException {
		String sql = "select * from purchase_note";
		return qr.query(sql, new BeanListHandler<PurchaseNote>(PurchaseNote.class));
	}
	/**
	 * 查询某一采购单
	 */
	@Override
	public PurchaseNote getOne(String pnid) throws SQLException {
		String sql = "select * from purchase_note where pnid = ?";
		return qr.query(sql, new BeanHandler<PurchaseNote>(PurchaseNote.class), pnid);
	}
}
