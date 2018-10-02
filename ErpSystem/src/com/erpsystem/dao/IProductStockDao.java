package com.erpsystem.dao;

import java.sql.SQLException;
import java.util.List;

import com.erpsystem.domain.ProductStock;

/**
 * 
 * @function   库存单持久化接口
 * @author     极客空
 * @date       2018年10月2日 下午3:20:05
 * @copyright  MR.Liu
 * @address    成都
 *
 */
public interface IProductStockDao {

    /**
     * 保存库存品
     * @param ps 要保存的库存品
     */
    void save(ProductStock ps) throws SQLException;
    
    /**
     * 修改库存品信息
     * @param ps 要修改的库存品，只能修改物品名称、仓库编号和物品类型
     */
    void update(ProductStock ps) throws SQLException;
    
    /**
     * 通过编号删除库存品
     * @param psid 要删除库存品的编号
     */
    void delete(String psid) throws SQLException;
    
    /**
     * 获得所有库存品
     * @return 库存品集合
     */
    List<ProductStock> getList() throws SQLException;
    
    /**
     * 通过编号获取库存品
     * @param psid 要查询的的库存品编号
     * @return 查询到的库存品
     */
    ProductStock getById(String psid) throws SQLException;
    
    /**
     * 通过库存品类别获取库存品
     * @param productType 要查询的库存品类别
     * @return 查询到的库存品集合
     */
    List<ProductStock> getByType(Integer productType) throws SQLException;
    
    /**
     * 查询最大库存品编号
     * @return 最大的库存品编号
     */
    String getMaxPsid() throws SQLException;
    
    /**
     * 查询总条数
     * @return
     */
    Integer getCount() throws SQLException;
    
    /**
     * 获取分页信息
     * @param index 查询开始行数
     * @param pageCount 一页显示行数
     * @return 当页的所有库存品
     */
    List<ProductStock> getPageData(int index, int pageCount) throws SQLException;
}
