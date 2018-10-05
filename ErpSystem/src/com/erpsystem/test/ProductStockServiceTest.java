package com.erpsystem.test;

import java.sql.SQLException;

import org.junit.Test;

import com.erpsystem.domain.ProductStock;
import com.erpsystem.service.IProductStockService;
import com.erpsystem.service.impl.ProductStockServiceImpl;

public class ProductStockServiceTest {

    @Test
    public void testSave() {
        IProductStockService psService = new ProductStockServiceImpl();
        ProductStock ps = new ProductStock(null, "测试", 120, 1, 2);
        try {
            psService.save(ps);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testChangeStock() {
        IProductStockService psService = new ProductStockServiceImpl();
        try {
            psService.changeStock("0002测试", 40, "李四", 2);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
