package com.erpsystem.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.erpsystem.domain.Customer;
import com.erpsystem.domain.PageBean;
import com.erpsystem.service.ICustomerSerivce;
import com.erpsystem.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class CustomerServlet
 */
/* (non-Javadoc)
 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	ICustomerSerivce customerService = new CustomerServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if(null != method) {
			
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
					delete(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
				
			case "edit":
				try {
					edit(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case "update":
				try {
					update(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "save":
				try {
					save(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			default:
				break;
			}
		}
	
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String unmae = request.getParameter("unmae");
		String orderNum = request.getParameter("orderNum");
		
		String currentPage = request.getParameter("currentPage");
		
		Integer currentPageInt = 1;
		if(null != currentPage && currentPage.length() != 0) {
			currentPageInt = Integer.valueOf(currentPage);
		}
		PageBean<Customer> pageBean = customerService.findAll(unmae, orderNum, currentPageInt);
		
		request.setAttribute("pageBean", pageBean);
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		String cid = request.getParameter("cid");
		customerService.delete(cid);
		
	}
	
	/**
	 * 编辑页面准备数据
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void edit(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		String cid = request.getParameter("cid");
		Customer customer = customerService.findById(cid);
		
		request.setAttribute("customer", customer);
		
		request.getRequestDispatcher("customerUpdate.jsp").forward(request, response);
	}
	
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, IllegalAccessException, InvocationTargetException{
		 
		Map<String, String[]> map = request.getParameterMap();
		Customer customer = new Customer();
		BeanUtils.populate(customer, map);
		
		customerService.update(customer);
		response.sendRedirect("CustomerServlet?method=list");
		
	}
	
	private void save(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, IllegalAccessException, InvocationTargetException{
		Map<String, String[]> map = request.getParameterMap();
		Customer customer = new Customer();
		BeanUtils.populate(customer, map);
		customerService.save(customer);
	}

		
	}
