package com.erpsystem.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.erpsystem.domain.User;



public interface UserService {
	
	public void addUser(User user) throws ClassNotFoundException, IOException, SQLException;
	
	public void edit(User user) throws ClassNotFoundException, IOException, SQLException;
	
	public void delete(Integer id) throws ClassNotFoundException, IOException, SQLException;
	
	public User login(String userName,String password) throws ClassNotFoundException, IOException, SQLException, Exception;
	
	public boolean checkUser(String userName) throws ClassNotFoundException, IOException, SQLException;
	
	public List<User> querByNickName(String nickName) throws ClassNotFoundException, IOException, SQLException;
	
	public  List<User>querAll() throws ClassNotFoundException, IOException, SQLException;
	
	public void resetPwd(Integer id) throws ClassNotFoundException, IOException, SQLException;
	
	public void changePwd(Integer id,String newPwd) throws ClassNotFoundException, IOException, SQLException;
	
	public User GetUser(Integer id) throws ClassNotFoundException, IOException, SQLException;
	
}
