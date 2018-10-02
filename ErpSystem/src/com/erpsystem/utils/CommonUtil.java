package com.erpsystem.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * 
 * @function   通用工具方法
 * @author     极客空
 * @date       2018年10月2日 上午11:17:51
 * @copyright  MR.Liu
 * @address    成都
 *
 */
public class CommonUtil {

    /**
     * 使用md5加密
     * @param plainText 需要加密的String
     * @return 返回加密成功的String
     */
    public static String getMd5(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }
    
    /**
     * 获得uuid
     * @return 生成的uuid
     */
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }
    
}
