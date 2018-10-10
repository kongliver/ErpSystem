package com.erpsystem.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

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
	    String psid = request.getParameter("psid");
	    String productType = request.getParameter("productType");
	    if (psid == null) {
            psid = "";
        }
	    if (productType == null) {
	        productType = "";
        }
	    try {
            PageBean<ProductStock> pageBean = productStockService.getPageBean(Integer.valueOf(currentPage), psid, productType);
            request.setAttribute("pageBean", pageBean);
            request.setAttribute("psid", psid);
            request.setAttribute("productType", productType);
            return "productList.jsp";
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	    return null;
	}
	
	/**
	 * 保存库存品
	 * @param request
	 * @param response
	 * @return
	 */
	protected String save(HttpServletRequest request, HttpServletResponse response) {
	    Map<String, String[]> parameterMap = request.getParameterMap();
	    ProductStock productStock = new ProductStock();
            try {
                BeanUtils.populate(productStock, parameterMap);
                productStockService.save(productStock);
                response.sendRedirect("ProductStockServlet?action=getPageBean&currentPage=1");
            } catch (RuntimeException e) {
                request.setAttribute("error", e.getMessage());
                return "productAdd.jsp";
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
	    return null;
	}
	
	/**
	 * 删除库存品
	 * @param request
	 * @param response
	 * @return
	 */
	protected String delete(HttpServletRequest request, HttpServletResponse response) {
	    String psid = request.getParameter("psid");
	    try {
            productStockService.delete(psid);
            return "ProductStockServlet?action=getPageBean&currentPage=1&psid=";
        } catch (SQLException e) {
            e.printStackTrace();
        }
	    return null;
	}
	
	/**
	 * 通过编号查询
	 * @param request
	 * @param response
	 * @return
	 */
	protected String getById(HttpServletRequest request, HttpServletResponse response) {
	    String psid = request.getParameter("psid");
	    try {
            ProductStock productStock = productStockService.getById(psid);
            request.setAttribute("productStock", productStock);
            return "productUpdate.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
        }
	    return null;
	}
	
	/**
	 * 修改库存品
	 * @param request
	 * @param response
	 * @return
	 */
	protected String update(HttpServletRequest request, HttpServletResponse response) {
	    Map<String, String[]> parameterMap = request.getParameterMap();
	    ProductStock productStock = new ProductStock();
	    try {
            BeanUtils.populate(productStock, parameterMap);
            productStockService.update(productStock);
            return "ProductStockServlet?action=getPageBean&currentPage=1&psid=&productType=";
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	    return null;
	}
	
	/**
	 * 通过名字查询
	 * @param request
	 * @param response
	 * @return
	 */
	protected String getByProductName(HttpServletRequest request, HttpServletResponse response) {
	    String productName = request.getParameter("productName");
            try {
                ProductStock productStock = productStockService.getByProductName(productName);
                request.setAttribute("productStock", productStock);
                return "productUpdateCount.jsp";
            } catch (RuntimeException e) {
                request.setAttribute("error", e.getMessage());
                return "productUpdateCount.jsp";
            } catch (SQLException e) {
                e.printStackTrace();
            }
	    return null;
	}
	
	protected String intoStock(HttpServletRequest request, HttpServletResponse response) {
	    String psid = request.getParameter("psid");
	    Integer changeCount = Integer.valueOf(request.getParameter("changeCount"));
	    String oprPerson = request.getParameter("oprPerson");
	    try {
            productStockService.changeStock(psid, changeCount, oprPerson, 1);
            return "ProductStockServlet?action=getPageBean&currentPage=1";
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	    return null;
	}
}
