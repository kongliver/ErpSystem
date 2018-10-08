package com.erpsystem.service;

import java.sql.SQLException;
import java.util.List;
import com.erpsystem.dao.IPurchaseNoteDao;
import com.erpsystem.dao.impl.PurchaseNoteDaoImpl;
import com.erpsystem.domain.ProductStock;
import com.erpsystem.domain.PurchaseNote;

public class IPurchaseNoteService {
	
	IPurchaseNoteDao dao = new PurchaseNoteDaoImpl();
//	查询库存中的所有物品
	public List<ProductStock> queryAllProduct(){
		List<ProductStock> list = null;
		try {
			list = dao.queryAllProduct();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
//	查询库存中的指定物品
	public ProductStock queryOneProduct(String psid) {
		ProductStock productStock = null;
		try {
			productStock = dao.queryOneProduct(psid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productStock;
	}
	
//	添加采购单（库存中采购单的物品需要添加进去）
	public int addTable(PurchaseNote purchaseNote) {
		int num = 0;
		try {
			num = dao.addTable(purchaseNote);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;	
	}
	
//	删除采购单
	public int deleteTables(String pnid) {
		int num = 0;
		try {
			num = dao.deleteTables(pnid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	
//	修改采购单
	public int updateTable(PurchaseNote purchaseNote) {
		int num = 0;
		try {
			num = dao.updateTable(purchaseNote);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	
	
//	查询所有采购单
	public List<PurchaseNote> queryTable(){
		List<PurchaseNote> list = null;
		try {
			list = dao.queryTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
//	查询某一张采购单
	public PurchaseNote getOne(String pnid) {
		PurchaseNote purchaseNote = null;
		try {
			purchaseNote = dao.getOne(pnid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return purchaseNote;
	}
	
	
}
