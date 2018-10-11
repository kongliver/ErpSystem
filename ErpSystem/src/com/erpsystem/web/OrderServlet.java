package com.erpsystem.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.erpsystem.domain.Customer;
import com.erpsystem.domain.Order;
import com.erpsystem.domain.PageBean;
import com.erpsystem.domain.ProductStock;
import com.erpsystem.service.ICustomerSerivce;
import com.erpsystem.service.IOrderService;
import com.erpsystem.service.IProductStockService;
import com.erpsystem.service.impl.CustomerServiceImpl;
import com.erpsystem.service.impl.OrderServiceImpl;
import com.erpsystem.service.impl.ProductStockServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	IOrderService orderService = new OrderServiceImpl();
	
	IProductStockService productStockService  = new ProductStockServiceImpl();
	
	ICustomerSerivce customerService = new CustomerServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if (null != method) {
			switch (method) {
			case "list":
				try {
					list(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case "delete":
				try {
					list(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case "save":
				try {
					save(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "findGoods":
				try {
					findGoods(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
					
			case "findCustomer":
				try {
					findCustomer(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
				
			default:
				break;
			}
		}
	}

	

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String cname = request.getParameter("cname");
		String orderNum = request.getParameter("orderNum");
		String orderTypeStr = request.getParameter("orderType");
		
		Integer orderType = 0;
		if (null == cname) {
			cname = "";
		}
		if (null == orderNum) {
			orderNum = "";
		}
		if (null != orderTypeStr && !"".equals(orderTypeStr)) {
			orderType = Integer.valueOf(orderTypeStr);
		}

		String currentPage = request.getParameter("currentPage");

		Integer currentPageInt = 1;
		if (null != currentPage && currentPage.length() != 0) {
			currentPageInt = Integer.valueOf(currentPage);
		}
		
		PageBean<Order> pageBean = orderService.findAll(cname, orderNum, orderType, 10, currentPageInt);
		
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("cname", cname);
		request.setAttribute("orderNum", orderNum);
		request.setAttribute("orderType", orderType);
		
		request.getRequestDispatcher("orderList.jsp").forward(request, response);

	}
	
	private void save(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException, IllegalAccessException, InvocationTargetException {
		
		Map<String, String[]> map = request.getParameterMap();
		Order order = new Order();
		BeanUtils.populate(order, map);
		
		orderService.insertOrder(order);
		
		response.sendRedirect("OrderServlet?method=list");
		
		
	}
	
	private void findGoods(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		List<ProductStock> list = productStockService.getByType(2);
		
		JSONArray jsonArray = JSONArray.fromObject(list); 
		
		response.setContentType("text/html;charset=utf-8");
		
		response.getWriter().write(jsonArray.toString());
		
	}
	
	private void findCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		List<Customer> list = customerService.findAll();
		
		JSONArray jsonArray = JSONArray.fromObject(list); 
		
		response.setContentType("text/html;charset=utf-8");
		
		response.getWriter().write(jsonArray.toString());
		
	}
	
	
}
