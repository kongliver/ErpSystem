package com.erpsystem.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.erpsystem.dao.IChangeStockListDao;
import com.erpsystem.dao.impl.ChangeStockListDaoImpl;
import com.erpsystem.domain.ChangeStockList;
import com.erpsystem.domain.PageBean;
import com.erpsystem.service.IChangeStockListService;

/**
 * 
 * @function   库存异动表服务层实现
 * @author     极客空
 * @date       2018年10月5日 上午11:34:55
 * @copyright  MR.Liu
 * @address    成都
 *
 */
public class ChangeStockListServiceImpl implements IChangeStockListService {
    
    private IChangeStockListDao changeStockListDao = new ChangeStockListDaoImpl();

    @Override
    public List<ChangeStockList> getList() throws SQLException {
        return changeStockListDao.getList();
    }

    @Override
    public List<ChangeStockList> getByPsid(String psid) throws SQLException {
        return changeStockListDao.getByPsid(psid);
    }

    @Override
    public List<ChangeStockList> getByOprType(Integer oprType) throws SQLException {
        return changeStockListDao.getByOprType(oprType);
    }

    @Override
    public List<ChangeStockList> getByOprTime(String oprTime) throws SQLException {
        return changeStockListDao.getByOprTime(oprTime);
    }

    @Override
    public PageBean<ChangeStockList> getPageBean(int currentPage) throws SQLException {
        PageBean<ChangeStockList> pageBean = new PageBean<>();
        // 设置当前页
        pageBean.setCurrentPage(currentPage);
        // 获取有多少条记录，从数据库当中查询
        long totalCount = changeStockListDao.getCount();
        pageBean.setTotalCount((int)totalCount);
        // 设置一页展示多少条数据
        int pageCount = 5;
        pageBean.setCurrentCount(pageCount);
        // 总页数
        double totalPage = Math.ceil(1.0 * pageBean.getTotalCount() / pageBean.getCurrentCount());
        pageBean.setTotalPage((int)totalPage);
        // 当前页查询的角标
        int index = (pageBean.getCurrentPage() - 1) * pageBean.getCurrentCount();
        List<ChangeStockList> changeStockList = changeStockListDao.getPageData(index, pageBean.getCurrentCount());
        pageBean.setList(changeStockList);
        return pageBean;
    }

}
