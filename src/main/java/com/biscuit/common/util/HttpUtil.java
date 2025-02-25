package com.biscuit.common.util;


import com.biscuit.common.enums.ResultEnum;
import com.biscuit.common.exception.BiscuitException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author biscuit
 */
@Slf4j
public abstract class HttpUtil {

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    /**
     * 发送POST请求
     *
     * @param url  请求的URL
     * @param json JSON格式的请求体
     * @return 响应体字符串
     */
    public static String post(String url, String json) {
        try {
            HttpPost request = new HttpPost(url);
            request.setHeader("Content-Type", "application/json");

            StringEntity entity = new StringEntity(json, "UTF-8");
            request.setEntity(entity);

            CloseableHttpResponse response = httpClient.execute(request);
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                return EntityUtils.toString(responseEntity);
            }
            return null;
        } catch (Exception e) {
            throw new BiscuitException(ResultEnum.FAIL.getCode(), "HttpUtil 发送 POST 请求失败");
        }
    }

    /**
     * 发送GET请求
     *
     * @param url 请求的URL
     * @return 响应体字符串
     */
    public static String get(String url) {
        try {
            HttpGet request = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(request);

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return EntityUtils.toString(entity);
            }
            return null;
        } catch (Exception e) {
            throw new BiscuitException(ResultEnum.FAIL.getCode(), "HttpUtil 发送 GET 请求失败");
        }
    }

    /**
     * 发送GET请求
     *
     * @param url    请求的URL
     * @param params 请求参数
     * @return 响应体字符串
     */
    public static String get(String url, Map<String, Object> params) {
        try {
            StringBuilder queryString = new StringBuilder(url);
            if (!url.contains("?")) {
                queryString.append("?");
            } else if (!url.endsWith("&")) {
                queryString.append("&");
            }

            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (queryString.length() > url.length()) {
                    queryString.append("&");
                }
                queryString.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8.name()))
                        .append("=")
                        .append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8.name()));
            }
            return get(queryString.toString());
        } catch (Exception e) {
            throw new BiscuitException(ResultEnum.FAIL.getCode(), "HttpUtil 发送 GET 请求失败");
        }
    }

}
