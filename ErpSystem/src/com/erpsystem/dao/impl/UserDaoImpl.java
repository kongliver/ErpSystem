package com.erpsystem.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.erpsystem.dao.UserDao;
import com.erpsystem.domain.User;
import com.erpsystem.utils.JdbcUtil2;


public class UserDaoImpl implements UserDao{
	
	/**
	 * 新增用户的业务逻辑
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	@Override
	public void addUser(User user) throws ClassNotFoundException, IOException, SQLException {
		Connection conn = JdbcUtil2.getConnection();
		String sql = "insert into user value(default,?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, user.getNickName());
		pst.setString(2, user.getUserName());
		pst.setString(3, user.getPassword());
		pst.setString(4, user.getPhone());
		pst.setInt(5, user.getUserTyep());
		pst.executeUpdate();
		conn.close();
		
	}
	
	/**
	 * 修改用户的业务逻辑
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	@Override
	public void edit(User user) throws ClassNotFoundException, IOException, SQLException {
		Connection conn = JdbcUtil2.getConnection();
		String sql = "update user set nickName=?,userName=?,password=?,phone=?,userType=? where uId=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, user.getNickName());
		pst.setString(2, user.getUserName());
		pst.setString(3, user.getPassword());
		pst.setString(4, user.getPhone());
		pst.setInt(5, user.getUserTyep());
		pst.setInt(6, user.getuId());
		pst.executeUpdate();
		conn.close();
	}

	
	/**
	 * 删除用户的业务逻辑
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	@Override
	public void delete(Integer id) throws ClassNotFoundException, IOException, SQLException {
		Connection conn = JdbcUtil2.getConnection();
		String sql = "delete from user where uId=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, id);
		pst.executeUpdate();
		conn.close();
	}

	
	/**
	 * 通过用户名账号去查询用户的业务逻辑
	 * @return 
	 */
	@Override
	public User querByUserName(String userName) throws ClassNotFoundException, IOException, SQLException {
		User user = null;
		Connection conn = JdbcUtil2.getConnection();
		String sql = "select * from user where userName=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, userName);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			user = new User();
			user.setuId(rs.getInt("uId"));
			user.setNickName(rs.getString("nickName"));
			user.setUserName(rs.getString("userName"));
			user.setPassword(rs.getString("password"));
			user.setPhone(rs.getString("phone"));
			user.setUserTyep(rs.getInt("userType"));
		}
		JdbcUtil2.close(conn, pst, rs);
		return user;
		
		
	}
	
	/**
	 * 通过用户名查询用户的业务逻辑
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	@Override
	public List<User> querByNickName(String nickName) throws ClassNotFoundException, IOException, SQLException {
		List<User> userList = null;
		Connection conn = JdbcUtil2.getConnection();
		String sql = "select * from user where nickName like ? ";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, "%" + nickName.trim() + "%");
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			if (null == userList)
				userList = new ArrayList<>();
			User user = new User();
			user.setuId(rs.getInt("uId"));
			user.setNickName(rs.getString("nickName"));
			user.setUserName(rs.getString("userName"));
			user.setPassword(rs.getString("password"));
			user.setPhone(rs.getString("phone"));
			user.setUserTyep(rs.getInt("userType"));
			userList.add(user);
		}
		JdbcUtil2.close(conn, pst, rs);
		return userList;
	}
	
	/**
	 * 通过编号查询用户的业务逻辑
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	@Override
	public User getById(Integer id) throws ClassNotFoundException, IOException, SQLException {
		User user = null;
		Connection conn = JdbcUtil2.getConnection();
		String sql = "select * from user where uId=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			user = new User();
			user.setuId(rs.getInt("uId"));
			user.setNickName(rs.getString("nickName"));
			user.setUserName(rs.getString("userName"));
			user.setPassword(rs.getString("password"));
			user.setPhone(rs.getString("phone"));
			user.setUserTyep(rs.getInt("userType"));
		}
		JdbcUtil2.close(conn, pst, rs);
		return user;
	}

	
	}


