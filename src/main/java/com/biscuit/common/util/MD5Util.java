package com.biscuit.common.util;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;

/**
 * @author biscuit
 */
@Slf4j
public abstract class MD5Util {

    private static MessageDigest digest;

    private final static String SALT = "@,as741-##@~!";

    static {
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            log.error("BCryptUtil MessageDigest getInstance MD5 error => {}", e.getMessage());
        }
    }

    public static String encrypt(String text) {
        // 将输入的字符串转换为字节数组，并更新摘要信息
        digest.update((text + SALT).getBytes());

        // 获取加密后的字节数组结果
        byte[] bytes = digest.digest();

        // 将字节数组转换为十六进制字符串表示形式
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }

}
