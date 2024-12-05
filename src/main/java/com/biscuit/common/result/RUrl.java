package com.biscuit.common.result;

/**
 * 通用地址响应参数
 * @author biscuit
 */
public class RUrl {

    /**
     * 地址
     */
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public RUrl(String url) {
        this.url = url;
    }

}
