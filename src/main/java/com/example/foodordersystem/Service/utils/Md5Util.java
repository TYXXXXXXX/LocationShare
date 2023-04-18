package com.example.foodordersystem.Service.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {
    /**
     * 对字符串进行 MD5 加密
     * @param str 原始字符串
     * @return 加密后的字符串
     */
    public static String md5(String str) {
        try {
            // 创建 MessageDigest 对象，指定使用 MD5 算法
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 对原始字符串进行加密，得到加密后的字节数组
            byte[] bytes = md.digest(str.getBytes());
            // 将字节数组转换为十六进制字符串
            return new BigInteger(1, bytes).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}
