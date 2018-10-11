package com.erpsystem.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erpsystem.domain.CustomerSupport;
import com.erpsystem.domain.PageBean;
import com.erpsystem.service.ICustomerSupportService;
import com.erpsystem.service.impl.CustomerSupportServiceImpl;
/**
 * 售后记录servlet
 */
/**
 * Servlet implementation class CustomerSupportServlet
 */
@WebServlet("/CustomerSupportServlet")
public class CustomerSupportServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private ICustomerSupportService cusSupSer = new CustomerSupportServiceImpl();
	
	/**
	 * 售后模糊查询
	 * @param request
	 * @param response
	 * @return
	 */
	protected String fuzzyQuery(HttpServletRequest request, HttpServletResponse response){
		String cusCompany = request.getParameter("cusCompany");
		String goodsName = request.getParameter("goodsName");
		String orderNum = request.getParameter("orderNum");
		if(cusCompany == null) {
			cusCompany = "";
		}
		if(goodsName == null) {
			goodsName = "";
		}
		if(orderNum == null) {
			orderNum = "";
		}
		try {
			List<CustomerSupport> cusSupList = cusSupSer.fuzzyQuery(orderNum, goodsName, cusCompany);
			for (CustomerSupport customerSupport : cusSupList) {
				System.out.println("fuzzyQuery:"+customerSupport);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "customer_supportList.jsp";
	}
	
	/**
	 * 获取分页数据
	 * @param request
	 * @param response
	 * @return
	 */
	protected String getPageBean(HttpServletRequest request, HttpServletResponse response){
		String currentPage = request.getParameter("currentPage");
		String orderNum = request.getParameter("orderNum");
		String goodsName = request.getParameter("goodsName");
		String cusCompany = request.getParameter("cusCompany");
		if(orderNum == null) {
			orderNum = "";
		}
		if(goodsName == null) {
			goodsName = "";
		}
		if(cusCompany == null) {
			cusCompany = "";
		}
		
		try {
			PageBean<CustomerSupport> pageBean = cusSupSer.getPageBean(Integer.valueOf(currentPage).intValue(), 6, orderNum, goodsName, cusCompany);
			List<CustomerSupport> list = pageBean.getList();
			System.out.println(list);
			
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("orderNum", orderNum);
			request.setAttribute("goodsName", goodsName);
			request.setAttribute("cusCompany", cusCompany);
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "customer_supportList.jsp";
	}
	
	/**
	 * 根据csId查看单条售后记录的更多详细信息
	 * @param request
	 * @param response
	 * @return
	 */
	protected String getOne(HttpServletRequest request, HttpServletResponse response){
		String csId = request.getParameter("csId");
		System.out.println("更多csId："+csId);
		try {
			Map<String, Object> cusSupMap = cusSupSer.getMoreCusSupById(csId);
			request.setAttribute("cusSupMap", cusSupMap);
			System.out.println("更多详情："+cusSupMap);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "customer_supportView.jsp";
	}
	
	/**
	 * 根据csId删除售后记录
	 * @param request
	 * @param response
	 * @return
	 */
	protected String deleteOne(HttpServletRequest request, HttpServletResponse response){
		String csId = request.getParameter("csId");
		System.out.println("delete_csId:"+csId);
		try {
			cusSupSer.deleteCusSup(csId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "CustomerSupportServlet?action=getPageBean&currentPage=1";
	}
	
	/**
	 * 保存售后记录
	 * @param request
	 * @param response
	 * @return
	 */
	protected String save(HttpServletRequest request, HttpServletResponse response){
		Long orderNum = Long.valueOf(request.getParameter("orderNum"));
		String problem = request.getParameter("problem");
		String handler = request.getParameter("handler");
		CustomerSupport cusSup = new CustomerSupport();
		cusSup.setOrderNum(orderNum);
		cusSup.setProblem(problem);
		cusSup.setHandler(handler);
		try {
			cusSupSer.saveCusSup(cusSup);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "CustomerSupportServlet?action=getPageBean&currentPage=1";
	}
	
	protected String toSave(HttpServletRequest request, HttpServletResponse response){
		String orderNum = request.getParameter("orderNum");
		request.setAttribute("orderNum", orderNum);
		return "customer_supportAdd.jsp";
	}
	
	
}
