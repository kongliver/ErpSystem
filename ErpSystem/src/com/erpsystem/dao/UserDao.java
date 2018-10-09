package com.erpsystem.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.erpsystem.domain.User;



public interface UserDao {
	/**
	 * 新增用户
	 * @param user
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void addUser(User user) throws ClassNotFoundException, IOException, SQLException;
	
	/**
	 * 修改用户
	 * @param user
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void edit(User user) throws ClassNotFoundException, IOException, SQLException;
	
	/**
	 * 删除用户
	 * @param id
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void delete(Integer id) throws ClassNotFoundException, IOException, SQLException;
	
	/**
	 * 根据账号名查询用户
	 * @param userName
	 * @return 
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public User querByUserName(String userName) throws ClassNotFoundException, IOException, SQLException;
	
	/**
	 * 根据用户名查询用户
	 * @param nickName
	 * @return
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public List<User> querByNickName(String nickName) throws ClassNotFoundException, IOException, SQLException;
	
	/**
	 * 根据ID去查询用户
	 * @param id
	 * @return
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public User getById(Integer id) throws ClassNotFoundException, IOException, SQLException;
}
