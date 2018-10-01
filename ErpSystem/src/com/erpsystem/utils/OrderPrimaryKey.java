package com.erpsystem.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @功能 用来生成order的主键
 * @文件 OrderPrimaryKey.java
 * @作者 张洪刚
 * @时间 2018-10-01 10:34
 * @地点 成都
 */
public class OrderPrimaryKey {

	/**
	 * 传入当前时间，以及在数据库中的最大订单号，比较是否 是同一天，如果不是使用新时间的日期，如果是同一天使用数据的日期，并且订单号 + 1
	 * 
	 * @param newDate 当前时间
	 * @param maxKey  数据库的订单
	 * @return 订单号
	 */
	public static Long getOrderPrimarKey(Date newDate, String maxKey) {

		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd"); // 设置日期格式
		String newDateStr = df.format(newDate).toString();

		String dateMaxKey = maxKey.substring(0, 8); // 得到数据库订单号的日期

		
		if (newDateStr.equals(dateMaxKey)) {    //判断当前时间是否和 最大订单号日期相同
			Integer num = Integer.valueOf(maxKey.substring(8));
			num++;
			String str = String.format("%05d", num);
			return Long.valueOf(newDateStr + str);
		} else {
			return Long.valueOf(newDateStr + "00001");
		}
	}

}
