package com.erpsystem.dao;

import java.sql.SQLException;
import java.util.List;

import com.erpsystem.domain.ProductStock;
import com.erpsystem.domain.PurchaseNote;

public interface IPurchaseNoteDao {

	/**
	 * 查询库存中的所有物品
	 * @throws SQLException 
	 */
	public List<ProductStock> queryAllProduct() throws SQLException;
		
	/**
	 * 查询库存中的指定物品
	 * @throws SQLException 
	 */
	public 	ProductStock queryOneProduct(String psid) throws SQLException;
	
	/**
	 * 添加采购单（库存中采购单的物品需要添加进去）
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
	 * 查询采购单
	 * @throws SQLException 
	 */
	public List<PurchaseNote> queryTable() throws SQLException;
	
	/**
	 * 查询某一张采购单
	 * @throws SQLException 
	 */
	public PurchaseNote getOne(String pnid) throws SQLException;
}
