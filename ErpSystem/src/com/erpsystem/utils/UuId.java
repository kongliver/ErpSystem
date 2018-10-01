package com.erpsystem.utils;

import java.util.UUID;

/**
 * @功能 得到uuid的工具类
 * @文件 UUID.java
 * @作者 张洪刚
 * @时间 2018-09-30 22:55
 * @地点 成都
 */
public class UuId {

	public static String getUUID() {
		return UUID.randomUUID().toString();
	}
}
