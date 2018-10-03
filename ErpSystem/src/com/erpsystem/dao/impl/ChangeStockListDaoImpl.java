package com.erpsystem.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.erpsystem.dao.IChangeStockListDao;
import com.erpsystem.domain.ChangeStockList;

/**
 * 
 * @function   库存异动记录持久化实现
 * @author     极客空
 * @date       2018年10月3日 下午12:07:44
 * @copyright  MR.Liu
 * @address    成都
 *
 */
public class ChangeStockListDaoImpl implements IChangeStockListDao {

    @Override
    public void save(ChangeStockList csl) throws SQLException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<ChangeStockList> getList() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ChangeStockList> getByPsid(String psid) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ChangeStockList> getByOprType(Integer oprType) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ChangeStockList> getByOprTime(String oprTime) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
