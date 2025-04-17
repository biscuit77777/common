package com.biscuit.common.tools.ip.impl;

import com.biscuit.common.dtos.IPInfoDTO;
import com.biscuit.common.factory.GsonFactory;
import com.biscuit.common.tools.ip.IPInfoAbstract;
import com.biscuit.common.util.HttpUtil;
import com.google.gson.Gson;

import java.util.Map;

/**
 * @author zihao.ma
 */
public class DBIPStrategy implements IPInfoAbstract {

    @Override
    @SuppressWarnings("unchecked")
    public IPInfoDTO info(String ip) {
        String url = "https://api.db-ip.com/v2/free/" + ip;
        String result = HttpUtil.get(url);
        Gson gson = GsonFactory.get();
        Map<String, Object> map = gson.fromJson(result, Map.class);
        return IPInfoDTO.builder()
                .ip(ip)
                .country(map.get("countryName").toString())
                .province(map.get("stateProv").toString())
                .city(map.get("city").toString())
                .build();
    }

}