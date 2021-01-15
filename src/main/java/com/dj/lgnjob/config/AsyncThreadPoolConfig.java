package com.dj.lgnjob.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @ClassName AsyncThreadPoolConfig
 * @Description 陶渊明
 * 结庐在人境，而无车马喧。
 * 问君何能尔？心远地自偏。
 * 采菊东篱下，悠然见南山。
 * 山气日夕佳，飞鸟相与还。
 * 此中有真意，欲辨已忘言。
 * @Author LiuGuiNan
 * @Date 2021/1/15 14:29
 * @Version 1.0
 **/

@Configuration
public class AsyncThreadPoolConfig {

    @Bean
    public Executor getThreadPool() {

        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();

        // 指定线程池的核心线程数
        taskExecutor.setCorePoolSize(5);
        // 指定线程池的最大线程数
        taskExecutor.setMaxPoolSize(10);
        // 缓冲任务的阻塞队列 默认使用linkedBlockQueue,根据业务设置大小
        taskExecutor.setQueueCapacity(50);
        // 线程空闲的最大时常
        taskExecutor.setKeepAliveSeconds(60);
        // 核心线程也可以回收，默认不回收false
//        taskExecutor.setAllowCoreThreadTimeOut(true);
        // 设置产生线程的线程工厂
//        taskExecutor.setThreadFactory();
        // 设置任务的拒绝策略，也可以自己重写，默认是使用AbortPolicy,抛出异常
//        taskExecutor.setRejectedExecutionHandler();
        // 设置开启的线程前缀名，便于日志查询
        taskExecutor.setThreadNamePrefix("LiuGuiNan-task");

        taskExecutor.initialize();
        return taskExecutor;
    }

}
