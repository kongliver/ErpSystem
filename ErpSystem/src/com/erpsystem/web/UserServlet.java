package com.erpsystem.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erpsystem.domain.User;
import com.erpsystem.service.UserService;
import com.erpsystem.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		this.doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		switch (action) {
		case"login":
			login(req,resp);
			break;
		case"query":
			query(req,resp);
			break;
		case"exist":
			exist(req,resp);
			break;
		case"add":
			add(req,resp);
			break;
		case"detaul":
			detaul(req,resp);
			break;
		case"reset":
			reset(req,resp);
			break;
		case"delete":
			delete(req,resp);
			break;
		case"toUpdate":
			toUpdate(req,resp);
			break;
		case"update":
			update(req,resp);
			break;
		
		}
	}

	
	/**
	 * 修改的业务逻辑
	 * @param req
	 * @param resp
	 */
	private void update(HttpServletRequest req, HttpServletResponse resp) {
		User user = new User();
		user.setuId(Integer.valueOf(req.getParameter("uId")));
		user.setNickName(req.getParameter("nickName"));
		user.setUserName(req.getParameter("userName"));
		user.setPassword(req.getParameter("password"));
		user.setPhone(req.getParameter("phone"));
		user.setUserTyep(Integer.valueOf(req.getParameter("userType")));
		
		UserService us = new UserServiceImpl();
		try {
			us.edit(user);
			req.setAttribute("user", user);
			this.query(req, resp);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	/**
	 * 修改的跳转到查询业务逻辑
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void toUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("uid"));
		UserService us = new UserServiceImpl();
		User user = null;
		
			try {
				user = us.GetUser(id);
				req.setAttribute("user", user);
				req.getRequestDispatcher("userUpdate.jsp").forward(req, resp);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
	}

	/**
	 * 删除的业务逻辑
	 * @param req
	 * @param resp
	 */
	private void delete(HttpServletRequest req, HttpServletResponse resp) {
		Integer id = Integer.parseInt(req.getParameter("uid"));
		UserService us = new UserServiceImpl();
		try {
			us.delete(id);
			this.query(req, resp);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * 修改密码的业务逻辑
	 * @param req
	 * @param resp
	 */
	private void reset(HttpServletRequest req, HttpServletResponse resp) {
		Integer id = Integer.parseInt(req.getParameter("uId"));
		String newPwd = req.getParameter("newPwd");
		UserService us = new UserServiceImpl();
		try {
			us.changePwd(id, newPwd);
			req.getRequestDispatcher("userAction?action=query").forward(req, resp);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * 查看详情的业务逻辑
	 * @param req
	 * @param resp
	 */
	private void detaul(HttpServletRequest req, HttpServletResponse resp) {
		
		Integer id = Integer.parseInt(req.getParameter("uid"));
		
		UserService us = new UserServiceImpl();
		User user = null;
		try {
			user = us.GetUser(id);
			req.setAttribute("user", user);
			req.getRequestDispatcher("userView.jsp").forward(req, resp);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	/**
	 * 新增用户的业务逻辑
	 * @param req
	 * @param resp
	 */
	private void add(HttpServletRequest req, HttpServletResponse resp) {
		User user = new User();
		user.setNickName(req.getParameter("nickName"));
		user.setUserName(req.getParameter("userName"));
		user.setPassword(req.getParameter("password"));
		user.setPhone(req.getParameter("phone"));
		user.setUserTyep(Integer.valueOf(req.getParameter("userType")));
		
		UserService us = new UserServiceImpl();
		try {
			us.addUser(user);
			this.query(req, resp);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 判断是否由相同的名字
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void exist(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String uname = req.getParameter("userName");
		UserService us = new UserServiceImpl();
		PrintWriter out = resp.getWriter();
		boolean isExist = false;
		try {
			isExist = us.checkUser(uname);
			if (isExist) {
				out.write("用户名已经存在！");
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**
	 * 查询的业务逻辑
	 * @param req
	 * @param resp
	 */
	private void query(HttpServletRequest req, HttpServletResponse resp) {
		String uname = req.getParameter("name");
		String action = req.getParameter("action");
		
		//如果是从新增页面或者删除动作跳转过来的
		if (action.equals("add")	||		action.equals("delete")		||	action.equals("update")) {
			uname = "";
		}
		
		UserService us = new UserServiceImpl();
		List<User> userList = null;
		try {
			userList = us.querByNickName(uname);
			req.setAttribute("list", userList);
			req.getRequestDispatcher("userList.jsp").forward(req, resp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * 登陆的业务逻辑
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		User user = null;
		UserService us = new UserServiceImpl();
		try {
			user = us.login(uname, pwd);
			req.getSession().setAttribute("USER", user);
			
			resp.sendRedirect("index.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("error", "用户名或密码错误，请重新输入");
			
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		
		
	}
}
