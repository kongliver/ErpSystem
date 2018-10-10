package com.erpsystem.service;

import java.sql.SQLException;
import java.util.List;

import com.erpsystem.domain.ChangeStockList;
import com.erpsystem.domain.PageBean;

/**
 * 
 * @function   库存异动表服务层接口
 * @author     极客空
 * @date       2018年10月4日 上午11:11:43
 * @copyright  MR.Liu
 * @address    成都
 *
 */
public interface IChangeStockListService {

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
    
    /**
     * 分页对象赋值封装
     * @param currentPage 当前页码
     * @return 封装好的分页对象
     */
    PageBean<ChangeStockList> getPageBean(int currentPage, String psid, String oprType, String oprTime) throws SQLException;
}
