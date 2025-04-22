package com.biscuit.common.tools.ip;

import com.biscuit.common.dtos.IPInfoDTO;

/**
 * @author biscuit
 */
public interface IPInfoAbstract {

    /**
     * 根据ip地址获取ip详情信息
     *
     * @param ip ip地址
     * @return IP详情信息
     */
    IPInfoDTO info(String ip);

}
