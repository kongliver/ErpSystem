package com.erpsystem.dao;
/**
 *  采购单
 */
import java.sql.SQLException;
import java.util.List;

import com.erpsystem.domain.ProductStock;
import com.erpsystem.domain.PurchaseNote;

public interface IPurchaseNoteDao {

	
	/**
	 * 添加采购单
	 * @throws SQLException 
	 */
	public int addTable(PurchaseNote purchaseNote) throws SQLException;
	
	/**
	 * 删除采购单
	 * @throws SQLException 
	 */
	public int deleteTables(String pnid) throws SQLException;
	
	/**
	 * 修改采购单
	 * @throws SQLException 
	 */
	public int updateTable(PurchaseNote purchaseNote) throws SQLException;
	
	/**
	 * 查询所有采购单
	 * @throws SQLException 
	 */
	public List<PurchaseNote> queryTable() throws SQLException;
	
	/**
	 * 查询某一采购单
	 * @throws SQLException 
	 */
	public PurchaseNote getOne(String pnid) throws SQLException;
}
