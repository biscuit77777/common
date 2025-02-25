package com.biscuit.common.util;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author biscuit
 */
@Slf4j
public abstract class ThreadUtil {

    private static final ThreadPoolExecutor executor;

    static {
        executor = new ThreadPoolExecutor(
                2, // 核心线程数
                4, // 最大线程数
                60L, // 空闲线程存活时间
                TimeUnit.SECONDS, // 时间单位
                new LinkedBlockingQueue<>(10), // 阻塞队列
                new ThreadPoolExecutor.CallerRunsPolicy() // 拒绝策略
        );
        log.info("ThreadUtil - ThreadPoolExecutor 线程池创建成功");
    }

    /**
     * 获取线程池对象
     *
     * @return 线程池
     */
    public static ThreadPoolExecutor single() {
        return executor;
    }

}
