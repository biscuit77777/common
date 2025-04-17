package com.biscuit.common.util;

import com.biscuit.common.dtos.IPInfoDTO;
import com.biscuit.common.tools.ip.IPInfoFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

/**
 * IP 工具类
 *
 * @author biscuit
 */
public abstract class IpUtil {

    // IPv4 正则表达式
    private static final String IPV4_REGEX =
            "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

    // IPv6 正则表达式（简化版）
    private static final String IPV6_REGEX =
            "^([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$";
    private static final Pattern IPV4_PATTERN = Pattern.compile(IPV4_REGEX);
    private static final Pattern IPV6_PATTERN = Pattern.compile(IPV6_REGEX);

    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.contains(",")) {
            return ip.split(",")[0];
        } else {
            return ip;
        }
    }

    public static boolean isValid(String ip) {
        if (ip == null || ip.isEmpty()) {
            return false;
        }
        if (ip.equals("localhost")) return true;
        return IPV4_PATTERN.matcher(ip).matches() || IPV6_PATTERN.matcher(ip).matches();
    }

    public static boolean isLocal(String ip) {
        try {
            InetAddress address = InetAddress.getByName(ip);
            return address.isLoopbackAddress() || address.isSiteLocalAddress();
        } catch (UnknownHostException e) {
            return false;
        }
    }

    public static IPInfoDTO getIpInfo(String ip) {
        // 是否合法IP
        AssertUtil.assertion(isValid(ip), "非法IP地址");

        // 校验是否为本地IP
        if (isLocal(ip)) return IPInfoDTO.builder().ip(ip).local(Boolean.TRUE).build();

        // 获取IP详细信息
        IPInfoDTO dto = IPInfoFactory.balancer().info(ip);
        dto.setLocal(Boolean.FALSE);
        return dto;
    }

}
