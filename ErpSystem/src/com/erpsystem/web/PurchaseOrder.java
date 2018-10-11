package com.erpsystem.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.erpsystem.domain.ProductStock;
import com.erpsystem.domain.PurchaseNote;
import com.erpsystem.service.IProductStockService;
import com.erpsystem.service.IPurchaseNoteService;
import com.erpsystem.service.impl.ProductStockServiceImpl;
import com.erpsystem.utils.CommonUtil;


@WebServlet("/PurchaseOrder")
public class PurchaseOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String methodName = request.getParameter("method");
		if("QueryStock".equals(methodName)) {
			QueryStock(request,response);
		}else if("QueryAllStock".equals(methodName)){
			QueryAllStock(request,response);
		}else if("AddNote".equals(methodName)) {
			AddNote(request,response);
		}else if("DeleteNote".equals(methodName)) {
			DeleteNote(request,response);
		}else if("UpdateNote".equals(methodName)) {
			UpdateNote(request,response);
		}else if("UpdateNoteID".equals(methodName)) {
			UpdateNoteID(request,response);
	}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
    /**
     * 查询库存物品户或者某张采购单
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
	protected void QueryStock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String KuCun = request.getParameter("KuCun");
		String purchaseOrder = request.getParameter("purchaseOrder");
		if( KuCun.length() == 0 && purchaseOrder.length() != 0) {
			
			IPurchaseNoteService service = new IPurchaseNoteService();
			PurchaseNote note = null;
			try {
				note = service.getOne(purchaseOrder);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(note == null) {
				request.getRequestDispatcher("/purchaseList.jsp").forward(request, response);
			}else {
				request.setAttribute("note", note);
				request.getRequestDispatcher("/purchaseList.jsp").forward(request, response);
			}	
		}else {
			request.getRequestDispatcher("/purchaseList.jsp").forward(request, response);
		}
	}
	/**
	 * 查询所有订单
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void QueryAllStock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		IPurchaseNoteService service = new IPurchaseNoteService();
		List<PurchaseNote> list = null;
		try {
			list = service.queryTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(list ==null) {
			request.getRequestDispatcher("/purchaseList.jsp").forward(request, response);
		}else {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/purchaseList.jsp").forward(request, response);
//			response.sendRedirect(request.getContextPath() +"/QueryAllStock");
		
			
			
		}
	}
	
	/**
	 * 增加订单
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void AddNote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map<String, String[]> map = request.getParameterMap();
		
		PurchaseNote pur = new PurchaseNote();
		
		try {
			BeanUtils.populate(pur, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		pur.setPnid(CommonUtil.getUUID());
		pur.setPurchaseTime(new Date());
		
		IPurchaseNoteService service = new IPurchaseNoteService();
		try {
			service.addTable(pur);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/PurchaseOrder?method=QueryAllStock");
	}	
	/**
	 * 删除订单
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void DeleteNote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IPurchaseNoteService service = new IPurchaseNoteService();
		String pid = request.getParameter("pid");
		try {
			service.deleteTables(pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		request.getRequestDispatcher("/QueryAllStock").forward(request, response);
		response.sendRedirect(request.getContextPath()+"/PurchaseOrder?method=QueryAllStock");
	}
	
	
	
	
	/**
	 * 得到页面ID
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void UpdateNoteID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pnid = request.getParameter("pid");
		IPurchaseNoteService service = new IPurchaseNoteService();
		PurchaseNote note = null;
		try {
			note = service.getOne(pnid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("note", note);
		request.getRequestDispatcher("/purchaseUpdate.jsp").forward(request, response);
	
	}
	
	
	/**
	 * 修改页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void UpdateNote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
		Map<String, String[]> map = request.getParameterMap();
		
		PurchaseNote pur = new PurchaseNote();
			try {
				pur.setPurchaseTime(new Date());
				BeanUtils.populate(pur, map);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			IPurchaseNoteService service = new IPurchaseNoteService();
			try {
				service.updateTable(pur);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			response.sendRedirect(request.getContextPath()+"/PurchaseOrder?method=QueryAllStock");
	
	}
	
	
}
