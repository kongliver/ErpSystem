package com.erpsystem.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.erpsystem.dao.ICustomerSupportDao;
import com.erpsystem.dao.impl.CustomerSupportDaoImpl;
import com.erpsystem.domain.CustomerSupport;
import com.erpsystem.domain.PageBean;
import com.erpsystem.service.ICustomerSupportService;
import com.erpsystem.service.impl.CustomerSupportServiceImpl;

/**
 * 
 * @Description 测试售后dao
 * @author T2planet
 * @date 2018年10月2日下午5:46:32
 */
public class CustomerSupportTest {
	public static void main(String[] args) throws SQLException {
		ICustomerSupportService css = new CustomerSupportServiceImpl();
		ICustomerSupportDao csd = new CustomerSupportDaoImpl();
		CustomerSupport cusSup = new CustomerSupport();
		cusSup.setCsId("567");
		cusSup.setOrderNum(201809L);
		cusSup.setProblem("问题009");
		cusSup.setHandler("wuwuwu五");
		
		//csd.saveCusSup(cusSup);
		//csd.updateCusSup(cusSup);
		//csd.deleteCusSup("321");
//		List<CustomerSupport> allCusSup = csd.getAllCusSup();
//		for (CustomerSupport customerSupport : allCusSup) {
//			System.out.println(customerSupport);
//		}
//		CustomerSupport cupSupById = csd.getCusSupById("567");
//		System.out.println(cupSupById);
		
//		List<CustomerSupport> fuzzyQueryList = csd.fuzzyQuery(2018010L, "", "");
//		for (CustomerSupport customerSupport : fuzzyQueryList) {
//			System.out.println(customerSupport);
//		}
		
		//测试service
		//css.saveCusSup(cusSup);
		//css.deleteCusSup("4afed304-c404-4648-994a-1a973ce7cf35");
		//css.updateCusSup(cusSup);
//		List<CustomerSupport> allCusSup = css.getAllCusSup();
//		for (CustomerSupport customerSupport : allCusSup) {
//			System.out.println(customerSupport);
//		}
//		CustomerSupport cusSupById = css.getCusSupById("b70e4023-3996-48a1-9286-0b6ac87e508f");
//		System.out.println(cusSupById);
//		Map<String, Object> moreCusSupById = css.getMoreCusSupById("567");
//		System.out.println(moreCusSupById);
		
//		List<CustomerSupport> fuzzyQuery = css.fuzzyQuery("", "", "");
//		for (CustomerSupport customerSupport : fuzzyQuery) {
//			System.out.println(customerSupport);
//		}
		
		//测试分页
//		PageBean pageBean = css.getPageBean(2,2);
//		List list = pageBean.getList();
//		for (Object object : list) {
//			System.out.println(object);
//		}
		
		
	}
}
