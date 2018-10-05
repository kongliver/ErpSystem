package com.erpsystem.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.erpsystem.dao.IProductStockDao;
import com.erpsystem.domain.ProductStock;
import com.erpsystem.utils.JdbcUtil;
import com.erpsystem.utils.PrimaryKeyUtil;

/**
 * 
 * @function   库存品持久化接口
 * @author     极客空
 * @date       2018年10月2日 下午8:07:25
 * @copyright  MR.Liu
 * @address    成都
 *
 */
public class ProductStockDaoImpl implements IProductStockDao {
    
    private Connection conn = null;
    
    public ProductStockDaoImpl() {}

    public ProductStockDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Integer save(ProductStock ps) throws SQLException {
        QueryRunner qr = JdbcUtil.getQueryRunner();
        String sql = "insert into product_stock values(?, ?, ?, ?, ?)";
        Object params[] = {PrimaryKeyUtil.getProductStockPK(this.getMaxPsid(), ps.getProductName()), 
                ps.getProductName(), ps.getProductCount(), ps.getRepertoryNum(), ps.getProductType()};
        return qr.update(sql, params);
    }

    @Override
    public void update(ProductStock ps) throws SQLException {
        QueryRunner qr = JdbcUtil.getQueryRunner();
        String sql = "update product_stock set productName = ?, repertoryNum = ?, productType = ? where psid = ?";
        Object params[] = {ps.getProductName(), ps.getRepertoryNum(), ps.getProductType(), ps.getPsid()};
        qr.update(sql, params);
    }

    @Override
    public Integer updateCount(String psid, Integer newCount) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "update product_stock set productCount = ? where psid = ?";
        return qr.update(conn, sql, newCount, psid);
    }
    
    @Override
    public void delete(String psid) throws SQLException {
        QueryRunner qr = JdbcUtil.getQueryRunner();
        String sql = "delete from product_stock where psid = ?";
        qr.update(sql, psid);
    }

    @Override
    public List<ProductStock> getList() throws SQLException {
        QueryRunner qr = JdbcUtil.getQueryRunner();
        String sql = "select * from product_stock";
        return qr.query(sql, new BeanListHandler<ProductStock>(ProductStock.class));
    }

    @Override
    public ProductStock getById(String psid) throws SQLException {
        QueryRunner qr = JdbcUtil.getQueryRunner();
        String sql = "select * from product_stock where psid = ?";
        return qr.query(sql, new BeanHandler<ProductStock>(ProductStock.class), psid);
    }

    @Override
    public List<ProductStock> getByType(Integer productType) throws SQLException {
        QueryRunner qr = JdbcUtil.getQueryRunner();
        String sql = "select * from product_stock where productType = ?";
        return qr.query(sql, new BeanListHandler<ProductStock>(ProductStock.class), productType);
    }

    @Override
    public String getMaxPsid() throws SQLException {
        QueryRunner qr = JdbcUtil.getQueryRunner();
        String sql = "select max(substring(p.psid, 1, 4)) from product_stock p";
        return (String) qr.query(sql, new ScalarHandler<>());
    }

    @Override
    public Integer getCount() throws SQLException {
        QueryRunner qr = JdbcUtil.getQueryRunner();
        String sql = "select count(*) from product_stock";
        return qr.query(sql, new ScalarHandler<>());
    }

    @Override
    public List<ProductStock> getPageData(int index, int pageCount) throws SQLException {
        QueryRunner qr = JdbcUtil.getQueryRunner();
        String sql = "select * from product_stock limit ?, ?";
        return qr.query(sql, new BeanListHandler<ProductStock>(ProductStock.class), index, pageCount);
    }

}
