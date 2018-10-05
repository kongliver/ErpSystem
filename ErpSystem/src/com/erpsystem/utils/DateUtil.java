package com.erpsystem.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @function   时间工具类
 * @author     极客空
 * @date       2018年10月5日 下午4:23:39
 * @copyright  MR.Liu
 * @address    成都
 *
 */
public class DateUtil {

    public static String formatTime(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
    
}
