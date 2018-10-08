package com.erpsystem.dao;

import java.sql.SQLException;
import java.util.List;

import com.erpsystem.domain.ProductStock;
import com.erpsystem.domain.PurchaseNote;

public interface IPurchaseNoteDao {

	/**
	 * ��ѯ����е�������Ʒ
	 * @throws SQLException 
	 */
	public List<ProductStock> queryAllProduct() throws SQLException;
		
	/**
	 * ��ѯ����е�ָ����Ʒ
	 * @throws SQLException 
	 */
	public 	ProductStock queryOneProduct(String psid) throws SQLException;
	
	/**
	 * ��Ӳɹ���������вɹ�������Ʒ��Ҫ��ӽ�ȥ��
	 * @throws SQLException 
	 */
	public int addTable(PurchaseNote purchaseNote) throws SQLException;
	
	/**
	 * ɾ���ɹ���
	 * @throws SQLException 
	 */
	public int deleteTables(String pnid) throws SQLException;
	
	/**
	 * �޸Ĳɹ���
	 * @throws SQLException 
	 */
	public int updateTable(PurchaseNote purchaseNote) throws SQLException;
	
	/**
	 * ��ѯ�ɹ���
	 * @throws SQLException 
	 */
	public List<PurchaseNote> queryTable() throws SQLException;
	
	/**
	 * ��ѯĳһ�Ųɹ���
	 * @throws SQLException 
	 */
	public PurchaseNote getOne(String pnid) throws SQLException;
}
