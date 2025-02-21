package com.biscuit.common.util;

import com.biscuit.common.dtos.RSAPairDTO;
import com.biscuit.common.enums.ResultEnum;
import com.biscuit.common.exception.BiscuitException;
import com.biscuit.common.factory.GsonFactory;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import static com.biscuit.common.util.RSAKeyPairUtil.*;

/**
 * 签名工具类
 *
 * @author biscuit
 */
public class SignUtil {

    private static final String SIGN_KEY = "Signature";

    /**
     * 初始化必填项（UUID、时间戳）
     */
    public static Map<String, Object> initMust(Map<String, Object> map, String accessKeyId) {
        map = JudgmentUtil.isNotEmpty(map) ? map : new TreeMap<>();
        map.put("AccessKeyId", accessKeyId);
        map.put("SignatureMethod", "HMAC-SHA1");
        map.put("SignatureNonce", GenerateUtil.uuid());
        map.put("Timestamp", System.currentTimeMillis());
        return map;
    }

    /**
     * 生成签名
     *
     * @param map             参数map
     * @param accessKeySecret 密钥
     * @param method          请求方式
     * @return 签名
     */
    public static String signature(Map<String, Object> map, String accessKeySecret, String method) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        String params = buildParams("POST", map);
        return calculate(params, accessKeySecret);
    }

    /**
     * 构建参数为字符串格式
     *
     * @return 字符串拼接格式
     */
    public static String buildParams(String method, Map<String, Object> params) throws UnsupportedEncodingException {
        TreeMap<String, Object> treeMap = params instanceof TreeMap ? (TreeMap<String, Object>) params : new TreeMap<>(params);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : treeMap.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        return method.toUpperCase() + "&%2F&" +
                URLEncoder.encode(sb.substring(0, sb.length() - 1), StandardCharsets.UTF_8.name());
    }

    public static String calculate(String params, String accessKeySecret) throws NoSuchAlgorithmException, InvalidKeyException {
        String key = accessKeySecret + "&";
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA1"));
        byte[] signData = mac.doFinal(params.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(signData);
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> map = initMust(null, "keyId");
        map.put(SIGN_KEY, signature(map, "99999", "GET"));
    }

}
