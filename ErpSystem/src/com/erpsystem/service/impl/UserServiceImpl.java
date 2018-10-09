package com.erpsystem.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.erpsystem.dao.UserDao;
import com.erpsystem.dao.impl.UserDaoImpl;
import com.erpsystem.domain.User;
import com.erpsystem.service.UserService;



public class UserServiceImpl implements UserService {
	UserDao userDao = null;
	public UserServiceImpl() {
				userDao = new UserDaoImpl();
 
	}
	
	/**
	 * 新增用户
	 */
	@Override
	public void addUser(User user) throws ClassNotFoundException, IOException, SQLException {
		userDao.addUser(user);
		
	}
	
	/**
	 * 修改用户
	 */
	@Override
	public void edit(User user) throws ClassNotFoundException, IOException, SQLException {
		userDao.edit(user);
		
	}
	
	/**
	 * 删除用户
	 */
	@Override
	public void delete(Integer id) throws ClassNotFoundException, IOException, SQLException {
		userDao.delete(id);
		
	}
	
	/**
	 * 登陆判断
	 */
	@Override
	public User login(String userName, String password) throws Exception {
		User user = userDao.querByUserName(userName);
		if(null == user || !user.getPassword().equals(password)) {
			throw new Exception("用户名或密码错误，请重新输入！");
		}
		return user;
	}
	
	
	
	@Override
	public boolean checkUser(String userName) throws ClassNotFoundException, IOException, SQLException {
		User user = userDao.querByUserName(userName);
		return user == null?false:true;
	}

	@Override
	public List<User> querByNickName(String nickName) throws ClassNotFoundException, IOException, SQLException {
		
		return userDao.querByNickName(nickName);
	}

	@Override
	public List<User> querAll() throws ClassNotFoundException, IOException, SQLException {
		return userDao.querByNickName("");
	}
	
	
	/**
	 * 重置密码
	 */
	@Override
	public void resetPwd(Integer id) throws ClassNotFoundException, IOException, SQLException {
		this.changePwd(1, "123456");
		
	}
	
	/**
	 * 修改密码
	 */
	@Override
	public void changePwd(Integer id, String newPwd) throws ClassNotFoundException, IOException, SQLException {
		User user = userDao.getById(id);
		user.setPassword(newPwd);
		userDao.edit(user);
		
	}
	
	/**
	 * 通过ID查询
	 */
	@Override
	public User GetUser(Integer id) throws ClassNotFoundException, IOException, SQLException {
		User user = userDao.getById(id);
		return user;
	}

	

}
