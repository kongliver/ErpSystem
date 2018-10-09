package com.erpsystem.web;

import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erpsystem.domain.PageBean;
import com.erpsystem.domain.ProductStock;
import com.erpsystem.service.IProductStockService;
import com.erpsystem.service.impl.ProductStockServiceImpl;

/**
 * 
 * @function   库存品控制层
 * @author     极客空
 * @date       2018年10月9日 下午5:36:28
 * @copyright  MR.Liu
 * @address    成都
 *
 */
@WebServlet("/ProductStockServlet")
public class ProductStockServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private IProductStockService productStockService = new ProductStockServiceImpl();

	/**
	 * 获取分页商品列表
	 * @param request
	 * @param response
	 * @return
	 */
	protected String getPageBean(HttpServletRequest request, HttpServletResponse response) {
	    // 获取当前页码
	    String currentPage = request.getParameter("currentPage");
	    try {
            PageBean<ProductStock> pageBean = productStockService.getPageBean(Integer.valueOf(currentPage));
            request.setAttribute("pageBean", pageBean);
            return "productList.jsp";
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	    return null;
	}
}
