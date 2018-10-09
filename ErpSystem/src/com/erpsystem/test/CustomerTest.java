package com.erpsystem.test;

import java.sql.SQLException;

import org.junit.Test;

import com.erpsystem.domain.Customer;
import com.erpsystem.domain.PageBean;
import com.erpsystem.service.ICustomerSerivce;
import com.erpsystem.service.impl.CustomerServiceImpl;

public class CustomerTest {
	ICustomerSerivce customerService = new CustomerServiceImpl();
	@Test
	public void test() throws SQLException {
		PageBean<Customer> findAll = customerService.findAll(null, "123", 1);
		
		System.out.println(findAll.getList().get(0));
	}
	
	@Test
	public void delete() throws SQLException {
		Customer customer = customerService.findById("1");
		
	}
}
