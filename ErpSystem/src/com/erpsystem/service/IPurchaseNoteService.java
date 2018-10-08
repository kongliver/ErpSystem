package com.erpsystem.service;

import java.sql.SQLException;
import java.util.List;
import com.erpsystem.dao.IPurchaseNoteDao;
import com.erpsystem.dao.impl.PurchaseNoteDaoImpl;
import com.erpsystem.domain.ProductStock;
import com.erpsystem.domain.PurchaseNote;

public class IPurchaseNoteService {
	
	IPurchaseNoteDao dao = new PurchaseNoteDaoImpl();
//	��ѯ����е�������Ʒ
	public List<ProductStock> queryAllProduct(){
		List<ProductStock> list = null;
		try {
			list = dao.queryAllProduct();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
//	��ѯ����е�ָ����Ʒ
	public ProductStock queryOneProduct(String psid) {
		ProductStock productStock = null;
		try {
			productStock = dao.queryOneProduct(psid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productStock;
	}
	
//	��Ӳɹ���������вɹ�������Ʒ��Ҫ��ӽ�ȥ��
	public int addTable(PurchaseNote purchaseNote) {
		int num = 0;
		try {
			num = dao.addTable(purchaseNote);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;	
	}
	
//	ɾ���ɹ���
	public int deleteTables(String pnid) {
		int num = 0;
		try {
			num = dao.deleteTables(pnid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	
//	�޸Ĳɹ���
	public int updateTable(PurchaseNote purchaseNote) {
		int num = 0;
		try {
			num = dao.updateTable(purchaseNote);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	
	
//	��ѯ���вɹ���
	public List<PurchaseNote> queryTable(){
		List<PurchaseNote> list = null;
		try {
			list = dao.queryTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
//	��ѯĳһ�Ųɹ���
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
