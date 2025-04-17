package com.biscuit.common.dtos;


import lombok.*;

/**
 * @author biscuit
 */
@Getter
@Setter
@Builder
public class IPInfoDTO {

    private String ip;

    /**
     * 是否本地地址
     */
    private boolean local;

    /**
     * 国家
     */
    private String country;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

}
