package com.biscuit.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.biscuit.common.base.BaseAMO;
import com.biscuit.common.enums.ResultEnum;
import com.biscuit.common.exception.LoginException;
import com.biscuit.common.factory.GsonFactory;
import com.biscuit.common.result.R;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Jwt 工具类
 *
 * @author biscuit
 */
public abstract class JwtUtil {

    public final static String USER_ID_KEY = "user_id";
    public final static String CLAIMS_KEY = "claim_map";

    private final static String SALT = "$]{{@%$BisCuiT_-_=4486As?vC*/912ttkX";

    /**
     * 获取 token 并设置 token 过期时间为5天，在 token 中存储 userId
     *
     * @param userId userId
     * @return token
     */
    public static String getToken(Long userId) {
        return getToken(USER_ID_KEY, userId, 60 * 60 * 24 * 5); // 默认设置5天过期时间
    }

    /**
     * 获取 token 并设置 token 过期时间，在 token 中存储 userId
     *
     * @param key    key
     * @param data   存储数据
     * @param second 过期时间（秒）
     * @return token
     */
    public static String getToken(String key, Object data, int second) {
        // 创建 jwt 对象构造器
        JWTCreator.Builder builder = JWT.create();

        // 设置过期时间
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, second);
        builder.withExpiresAt(instance.getTime());

        // 根据不同数据类型存储数据
        if (data instanceof Boolean) {
            builder.withClaim(key, (Boolean) data);
        }
        if (data instanceof Integer) {
            builder.withClaim(key, (Integer) data);
        }
        if (data instanceof Long) {
            builder.withClaim(key, (Long) data);
        }
        if (data instanceof Double) {
            builder.withClaim(key, (Double) data);
        }
        if (data instanceof String) {
            builder.withClaim(key, (String) data);
        }
        if (data instanceof Date) {
            builder.withClaim(key, (Date) data);
        }
        if (data instanceof Map) {
            builder.withClaim(key, (Map) data);
        }
        if (data instanceof List) {
            builder.withClaim(key, (List<?>) data);
        }

        // 生成 token
        return builder.sign(Algorithm.HMAC256(SALT));
    }

    /**
     * 获取 token 并设置 token 过期时间，在 token 中存储特定数据
     */
    public static String getToken(Map<String, Object> claims, int second) {
        return getToken(CLAIMS_KEY, claims, second);
    }

    /**
     * 获取 token 中的 userId
     *
     * @param token token
     * @return userId
     */
    public static Long getUserId(String token) {
        return getClaims(token).get(USER_ID_KEY).asLong();
    }

    /**
     * 获取 token 中的特殊数据
     *
     * @param key   key
     * @param token token
     * @param clazz 数据类型
     * @return 特定数据
     */
    public static <T> T get(String key, String token, Class<T> clazz) {
        return getClaims(token).get(key).as(clazz);
    }

    /**
     * 获取 token 中的 特别数据 Map
     *
     * @param token token
     * @return Map
     */
    public static Map<String, Object> getMap(String token) {
        return getClaims(token).get(CLAIMS_KEY).asMap();
    }

    /**
     * 校验是否过期
     *
     * @param token token
     * @return true 过期，false 未过期
     */
    public static boolean isExpire(String token) {
        try {
            return JWT.require(Algorithm.HMAC256(SALT)).build().verify(token).getExpiresAt().before(new Date());
        } catch (Exception e) {
            return true;
        }
    }

    private static Map<String, Claim> getClaims(String token) {
        try {
            return JWT.require(Algorithm.HMAC256(SALT)).build().verify(token).getClaims();
        } catch (Exception e) {
            throw new LoginException(ResultEnum.TOKEN_TAMPER.getCode(), e.getMessage());
        }
    }

}
