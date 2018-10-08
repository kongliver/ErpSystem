package com.erpsystem.service;

import java.sql.SQLException;
import java.util.List;
import com.erpsystem.dao.IPurchaseNoteDao;
import com.erpsystem.dao.impl.PurchaseNoteDaoImpl;
import com.erpsystem.domain.PurchaseNote;
import com.erpsystem.service.impl.ProductStockServiceImpl;

public class IPurchaseNoteService {
	
	IPurchaseNoteDao dao = new PurchaseNoteDaoImpl();

	/**
	 *  添加采购单
	 * @throws SQLException 
	 */
	public int addTable(PurchaseNote purchaseNote) throws SQLException {
		int num = 0;
		num = dao.addTable(purchaseNote);
		IProductStockService service = new ProductStockServiceImpl();
		service.changeStock( purchaseNote.getPsid(),  purchaseNote.getPurchaseCount(),  purchaseNote.getBuyer(),  1);
		return num;	
	}
	
	/**
	 *  删除采购单
	 * @throws SQLException 
	 */
	public int deleteTables(String pnid) throws SQLException {
		int num = 0;
		num = dao.deleteTables(pnid);
		return num;
	}
	
	/**
	 *  修改采购单
	 * @throws SQLException 
	 */
	public int updateTable(PurchaseNote purchaseNote) throws SQLException {
		int num = 0;
		num = dao.updateTable(purchaseNote);
		return num;
	}
	
	
	/**
	 *  查询采购单
	 * @throws SQLException 
	 */
	public List<PurchaseNote> queryTable() throws SQLException{
		List<PurchaseNote> list = null;
		list = dao.queryTable();
		return list;
	}
	/**
	 *  查询某一张采购单
	 * @throws SQLException 
	 */
	public PurchaseNote getOne(String pnid) throws SQLException {
		PurchaseNote purchaseNote = null;
		purchaseNote = dao.getOne(pnid);
		return purchaseNote;
	
	}
}
