package com.erpsystem.web;

import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erpsystem.domain.ChangeStockList;
import com.erpsystem.domain.PageBean;
import com.erpsystem.service.IChangeStockListService;
import com.erpsystem.service.impl.ChangeStockListServiceImpl;

/**
 * 
 * @function   库存异动控制层
 * @author     极客空
 * @date       2018年10月10日 下午5:05:51
 * @copyright  MR.Liu
 * @address    成都
 *
 */
@WebServlet("/ChangeStockListServlet")
public class ChangeStockListServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private IChangeStockListService changeStockListService = new ChangeStockListServiceImpl();

	/**
	 * 分页
	 * @param request
	 * @param response
	 * @return
	 */
	protected String getPageBean(HttpServletRequest request, HttpServletResponse response) {
	    Integer currentPage = Integer.valueOf(request.getParameter("currentPage"));
	    String psid = request.getParameter("psid");
	    String oprType = request.getParameter("oprType");
	    String oprTime = request.getParameter("oprTime");
	    if (psid == null) {
            psid = "";
        }
	    if (oprType == null) {
	        oprType = "";
        }
	    if (oprTime == null) {
	        oprTime = "";
        }
	    try {
            PageBean<ChangeStockList> pageBean = changeStockListService.getPageBean(currentPage, psid, oprType, oprTime);
            request.setAttribute("pageBean", pageBean);
            request.setAttribute("psid", psid);
            request.setAttribute("oprType", oprType);
            request.setAttribute("oprTime", oprTime);
            return "change_stockList.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
        }
	    return null;
	}
}
