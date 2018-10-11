package com.erpsystem.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.erpsystem.dao.IChangeStockListDao;
import com.erpsystem.domain.ChangeStockList;
import com.erpsystem.utils.CommonUtil;
import com.erpsystem.utils.JdbcUtil;

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
    private Connection conn = null;
    
    public ChangeStockListDaoImpl() {}

    public ChangeStockListDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void save(ChangeStockList csl) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "insert into change_stock_list values(?, ?, ?, ?, ?, ?)";
        Object params[] = {CommonUtil.getUUID(), csl.getPsid(), csl.getChangeCount(), csl.getOprTime(), 
                csl.getOprPerson(), csl.getOprType()};
        qr.update(conn, sql, params);
    }

    @Override
    public List<ChangeStockList> getList() throws SQLException {
        QueryRunner qr = JdbcUtil.getQueryRunner();
        String sql = "select * from change_stock_list";
        return qr.query(sql, new BeanListHandler<ChangeStockList>(ChangeStockList.class));
    }

    @Override
    public List<ChangeStockList> getByPsid(String psid) throws SQLException {
        QueryRunner qr = JdbcUtil.getQueryRunner();
        String sql = "select * from change_stock_list where psid = ?";
        return qr.query(sql, new BeanListHandler<ChangeStockList>(ChangeStockList.class), psid);
    }

    @Override
    public List<ChangeStockList> getByOprType(Integer oprType) throws SQLException {
        QueryRunner qr = JdbcUtil.getQueryRunner();
        String sql = "select * from change_stock_list where oprType = ?";
        return qr.query(sql, new BeanListHandler<ChangeStockList>(ChangeStockList.class), oprType);
    }

    @Override
    public List<ChangeStockList> getByOprTime(String oprTime) throws SQLException {
        QueryRunner qr = JdbcUtil.getQueryRunner();
        String sql = "select * from change_stock_list where oprTime = ?";
        return qr.query(sql, new BeanListHandler<ChangeStockList>(ChangeStockList.class), oprTime);
    }

    @Override
    public Long getCount(String psid, String oprType, String oprTime) throws SQLException {
        QueryRunner qr = JdbcUtil.getQueryRunner();
        String sql = "select count(*) from change_stock_list where psid like ? and oprType like ? and oprTime like ?";
        return (Long)qr.query(sql, new ScalarHandler<>(), "%" + psid + "%", "%" + oprType + "%", "%" + oprTime + "%");
    }

    @Override
    public List<ChangeStockList> getPageData(int index, int pageCount, String psid, String oprType, String oprTime) throws SQLException {
        QueryRunner qr = JdbcUtil.getQueryRunner();
        String sql = "select * from change_stock_list "
                + "where psid like ? and oprType like ? and oprTime like ? limit ?, ?";
        return qr.query(sql, new BeanListHandler<ChangeStockList>(ChangeStockList.class), "%" + psid + "%", "%" + oprType + "%", "%" + oprTime + "%", index, pageCount);
    }

}
