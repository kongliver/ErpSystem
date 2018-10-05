package com.erpsystem.service;

import java.sql.SQLException;
import java.util.List;

import com.erpsystem.domain.PageBean;
import com.erpsystem.domain.ProductStock;

/**
 * 
 * @function   库存品服务层接口
 * @author     极客空
 * @date       2018年10月4日 上午11:10:56
 * @copyright  MR.Liu
 * @address    成都
 *
 */
public interface IProductStockService {

    /**
     * 新增库存品
     * @param productStock
     */
    void save(ProductStock productStock) throws SQLException, RuntimeException;
    
    /**
     * 更新库存品信息
     * @param productStock 要修改的库存品，只能修改物品名称、仓库编号和物品类型
     */
    void update(ProductStock productStock) throws SQLException;
    
    /**
     * 删除库存品信息
     * @param psid 要删除的库存品编号
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
     * 入库/出库
     * @param changeCount 变化数量
     * @param oprPerson 操作人
     * @param oprType 操作类型（入库：1，出库：2）
     */
    void changeStock(String psid, Integer changeCount, String oprPerson, Integer oprType) throws RuntimeException, SQLException;
    
    /**
     * 分页对象赋值封装
     * @param currentPage 当前页码
     * @return 封装好的分页对象
     */
    PageBean<ProductStock> getPageBean(int currentPage) throws SQLException;
}
