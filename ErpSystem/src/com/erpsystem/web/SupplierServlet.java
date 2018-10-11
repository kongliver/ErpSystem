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

import com.erpsystem.domain.PageBean;
import com.erpsystem.domain.Supplier;
import com.erpsystem.service.ISupplierService;
import com.erpsystem.service.impl.SupplierServiceImpl;

/**
 * Servlet implementation class SupplierServlet
 */
@WebServlet("/SupplierServlet")
public class SupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ISupplierService iss = new SupplierServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if(null != method) {
			switch (method) {
			case "list":
				try {
					list(request,response);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case "addSupplier":
				
				try {
					addSupplier(request,response);
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				break;
			case "edit":
				try {
					edit(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "update":
				try {
					update(request,response);
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case "delete":
				try {
					delete(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case "fuzzyQuery":
				try {
					fuzzyQuery(request,response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			case "getPageBean":
				try {
					getPageBean(request,response);
				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	

	private void getPageBean(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, SQLException, ServletException, IOException {
		String currentPage = request.getParameter("currentPage");
		String supCompany = request.getParameter("supCompany");
		if(supCompany == null) {
			supCompany = "";
		}
		PageBean<Supplier> pageBean = iss.getPage(supCompany,6,Integer.valueOf(currentPage).intValue() );
		
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("supCompany", supCompany);
		
		request.getRequestDispatcher("providerList.jsp").forward(request, response);
	}



	private void fuzzyQuery(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String supCompany = request.getParameter("supCompany");
		List<Supplier> supplierList = iss.getByCompany(supCompany);
		request.setAttribute("supplierList", supplierList);
		request.getRequestDispatcher("providerList.jsp").forward(request, response);
	}



	private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String sid = request.getParameter("sid");
		iss.delete(sid);
		response.sendRedirect("SupplierServlet?method=list");
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, InvocationTargetException, SQLException, IOException {
		String id = request.getParameter("sid");
		Map<String, String[]> map = request.getParameterMap();
		Supplier supplier = new Supplier();
		BeanUtils.populate(supplier,map);
		supplier.setsId(id);
		iss.edit(supplier);
		response.sendRedirect("SupplierServlet?method=list");
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String sid = request.getParameter("sid");
	
			Supplier supplier = iss.getById(sid);
	 
				request.setAttribute("supplier",supplier);
				
				request.getRequestDispatcher("providerUpdate.jsp").forward(request, response);
				
			
		
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
//		String snmae = request.getParameter("snmae");
//		String currentPage = request.getParameter("currentPage");
//		Integer currentPageInt = 1;
//		if(null != currentPage && currentPage.length() != 0) {
//			currentPageInt = Integer.valueOf(currentPage);
//		}
//		PageBean<Supplier> pageBean = new PageBean<>();
//		
//		pageBean.setList( iss.getAllSupplier());
//		request.setAttribute("pageBean", pageBean);
//		request.getRequestDispatcher("providerList.jsp").forward(request, response);
		
		String supCompany = request.getParameter("supCompany");
		if(supCompany == null) {
			supCompany = "";
			List<Supplier> supplierList = iss.getAllSupplier();
			request.setAttribute("supplierList",supplierList);
			request.getRequestDispatcher("providerList.jsp").forward(request, response);
		}
//		ISupplierService iss = new SupplierServiceImpl();
		
		List<Supplier> supplierList = iss.getByCompany(supCompany);
		request.setAttribute("supplierList",supplierList);
		request.getRequestDispatcher("providerList.jsp").forward(request, response);
		
	}

	private void addSupplier(HttpServletRequest request, HttpServletResponse response) throws SQLException, IllegalAccessException, InvocationTargetException, IOException, ServletException {
//		Map<String, String[]> map = request.getParameterMap();
		Supplier supplier = new Supplier();
//		
//			BeanUtils.populate(supplier, map);
//			iss.addSupplier(supplier);
//			response.sendRedirect("SupplierServlet?method=list");
		
		supplier.setSupCompany(request.getParameter("supCompany"));
		supplier.setSupContacts(request.getParameter("supContacts"));
		supplier.setSupPhone(request.getParameter("supPhone"));
		supplier.setSupAddress(request.getParameter("supAddress"));
		ISupplierService iss = new SupplierServiceImpl();
		try {
			iss.addSupplier(supplier);
//			this.list(request, response);
			response.sendRedirect("SupplierServlet?method=getPageBean&currentPage=1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
