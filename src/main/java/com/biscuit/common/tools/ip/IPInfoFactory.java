package com.biscuit.common.tools.ip;

import com.biscuit.common.tools.ip.impl.DBIPStrategy;
import com.biscuit.common.tools.ip.impl.Open1Strategy;
import com.biscuit.common.tools.ip.impl.Open2Strategy;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zihao.ma
 */
public abstract class IPInfoFactory {

    private static final AtomicInteger atomic = new AtomicInteger(0);

    private static final List<IPInfoAbstract> LIST = Arrays.asList(
            new DBIPStrategy(), new Open1Strategy(), new Open2Strategy());

    public static IPInfoAbstract balancer() {
        int current = atomic.getAndIncrement();
        if (current > 10000) atomic.set(0);
        return LIST.get(current % LIST.size());
    }

}
