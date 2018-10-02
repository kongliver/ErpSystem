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
public class PrimaryKeyUtil {

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
	
	/**
	 * 生成库存品主键，找出已有的库存品编号前四位的最大值，在最大值的基础上+1，如果没有则当前主键前四位为0001
	 * @param psid 已有库存品的编号集合
	 * @param productName 库存品名缩写
	 * @return 生成的主键
	 */
	public static String getProductStockPK(String maxPsid, String productName) {
	    Integer id = null;
	    if (maxPsid == null) {
            id = 1;
        } else {
            id = Integer.valueOf(maxPsid.substring(0, 4)) + 1;
        }
	    return String.format("%04d", id) + productName;
	}
	
}
