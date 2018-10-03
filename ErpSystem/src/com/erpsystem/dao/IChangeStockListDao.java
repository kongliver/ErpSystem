package com.erpsystem.dao;

import java.sql.SQLException;
import java.util.List;

import com.erpsystem.domain.ChangeStockList;

/**
 * 
 * @function   库存异动记录持久化接口
 * @author     极客空
 * @date       2018年10月3日 上午11:19:36
 * @copyright  MR.Liu
 * @address    成都
 *
 */
public interface IChangeStockListDao {

    /**
     * 保存库存异动记录单
     * @param csl
     */
    void save(ChangeStockList csl) throws SQLException;
    
    /**
     * 查询所有异动记录
     * @return 异动记录集合
     */
    List<ChangeStockList> getList() throws SQLException;
    
    /**
     * 通过库存品编号查询异动记录
     * @param psid 库存品编号
     * @return 异动记录集合
     */
    List<ChangeStockList> getByPsid(String psid) throws SQLException;
    
    /**
     * 通过操作状态查询异动记录
     * @param oprType 操作状态（入库/出库）
     * @return 异动记录集合
     */
    List<ChangeStockList> getByOprType(Integer oprType) throws SQLException;
    
    /**
     * 通过操作时间查询异动记录
     * @param oprTime 操作时间
     * @return 异动记录集合
     */
    List<ChangeStockList> getByOprTime(String oprTime) throws SQLException;
}
