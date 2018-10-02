package com.erpsystem.test;

import java.sql.SQLException;
import java.util.List;

import com.erpsystem.dao.ICustomerSupportDao;
import com.erpsystem.dao.impl.CustomerSupportDaoImpl;
import com.erpsystem.domain.CustomerSupport;

/**
 * 
 * @Description 测试售后dao
 * @author T2planet
 * @date 2018年10月2日下午5:46:32
 */
public class CustomerSupportTest {
	public static void main(String[] args) throws SQLException {
		ICustomerSupportDao csd = new CustomerSupportDaoImpl();
		CustomerSupport cusSup = new CustomerSupport();
		cusSup.setCsId("567");
		cusSup.setOrderNum(312321123L);
		cusSup.setProblem("没问题");
		cusSup.setHandler("l范德萨");
		cusSup.setHandleTime("2018-8-8");
		
		//csd.saveCusSup(cusSup);
		//csd.updateCusSup(cusSup);
		//csd.deleteCusSup("321");
//		List<CustomerSupport> allCusSup = csd.getAllCusSup();
//		for (CustomerSupport customerSupport : allCusSup) {
//			System.out.println(customerSupport);
//		}
		CustomerSupport cupSupById = csd.getCupSupById("567");
		System.out.println(cupSupById);
	}
}
