package com.erpsystem.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.erpsystem.dao.IChangeStockListDao;
import com.erpsystem.dao.IProductStockDao;
import com.erpsystem.dao.impl.ChangeStockListDaoImpl;
import com.erpsystem.dao.impl.ProductStockDaoImpl;
import com.erpsystem.domain.ChangeStockList;
import com.erpsystem.domain.PageBean;
import com.erpsystem.domain.ProductStock;
import com.erpsystem.service.IProductStockService;
import com.erpsystem.utils.DateUtil;
import com.erpsystem.utils.JdbcUtil;

/**
 * 
 * @function   库存品服务层实现
 * @author     极客空
 * @date       2018年10月5日 上午11:33:32
 * @copyright  MR.Liu
 * @address    成都
 *
 */
public class ProductStockServiceImpl implements IProductStockService {
    
    private IProductStockDao productStockDao = new ProductStockDaoImpl();

    @Override
    public void save(ProductStock productStock) throws RuntimeException, SQLException {
        ProductStock ps = productStockDao.getByProductName(productStock.getProductName());
        if (ps != null) {
            throw new RuntimeException("仓库中已经存在该名字的库存品，请勿重复添加");
        }
        productStockDao.save(productStock);
    }

    @Override
    public void update(ProductStock productStock) throws SQLException {
        productStockDao.update(productStock);
    }

    @Override
    public void delete(String psid) throws SQLException {
        productStockDao.delete(psid);
    }

    @Override
    public List<ProductStock> getList() throws SQLException {
        return productStockDao.getList();
    }

    @Override
    public ProductStock getById(String psid) throws SQLException {
        return productStockDao.getById(psid);
    }

    @Override
    public List<ProductStock> getByType(Integer productType) throws SQLException {
        return productStockDao.getByType(productType);
    }

    @Override
    public void changeStock(String psid, Integer changeCount, String oprPerson, Integer oprType) throws RuntimeException, SQLException {
        Connection conn = JdbcUtil.getConn();
        // 开启事务
        conn.setAutoCommit(false);
        IProductStockDao psDao = new ProductStockDaoImpl(conn);
        IChangeStockListDao cslDao = new ChangeStockListDaoImpl(conn);
        ChangeStockList csl = new ChangeStockList();
        ProductStock productStock = psDao.getById(psid);
        Integer newCount = null;
        if (productStock == null) {
            conn.rollback();
            throw new RuntimeException("库存品不存在，请先添加库存品");
        }
        if (oprType == 1) { // 入库
            newCount = productStock.getProductCount() + changeCount;
        } else if (oprType == 2) {  // 出库
            if (productStock.getProductCount() >= changeCount) {
                newCount = productStock.getProductCount() - changeCount;
            } else {
                conn.rollback();
                throw new RuntimeException("库存品数量小于出库数量，出库失败");
            }
        } else {
            conn.rollback();
            throw new RuntimeException("只有入库和出库操作");
        }
        // 更新库存品数量
        psDao.updateCount(psid, newCount);
        // 新增库存异动记录
        csl.setPsid(psid);
        csl.setChangeCount(changeCount);
        csl.setOprTime(DateUtil.formatTime(new Date()));
        csl.setOprPerson(oprPerson);
        csl.setOprType(oprType);
        cslDao.save(csl);
        // 提交事务
        conn.commit();
        conn.close();
    }

    @Override
    public PageBean<ProductStock> getPageBean(int currentPage, String psid, String productType) throws SQLException {
        PageBean<ProductStock> pageBean = new PageBean<>();
        // 设置当前页
        pageBean.setCurrentPage(currentPage);
        // 获取有多少条记录，从数据库当中查询
        Long totalCount = productStockDao.getCount(psid, productType);
        pageBean.setTotalCount(totalCount.intValue());
        // 设置一页展示多少条数据
        int pageCount = 5;
        pageBean.setCurrentCount(pageCount);
        // 总页数
        double totalPage = Math.ceil(1.0 * pageBean.getTotalCount() / pageBean.getCurrentCount());
        pageBean.setTotalPage((int)totalPage);
        // 当前页查询的角标
        int index = (pageBean.getCurrentPage() - 1) * pageBean.getCurrentCount();
        List<ProductStock> productStockList = productStockDao.getPageData(index, pageBean.getCurrentCount(), psid, productType);
        pageBean.setList(productStockList);
        return pageBean;
    }

    @Override
    public ProductStock getByProductName(String productName) throws RuntimeException, SQLException {
        ProductStock productStock = productStockDao.getByProductName(productName);
        if (productStock == null) {
            throw new RuntimeException("该库存品不存在");
        }
        return productStock;
    }

}
