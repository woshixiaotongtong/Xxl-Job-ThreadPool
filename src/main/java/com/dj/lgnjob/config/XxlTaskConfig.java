package com.dj.lgnjob.config;


import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName XxlTaskConfig
 * @Description 陶渊明
 * 结庐在人境，而无车马喧。
 * 问君何能尔？心远地自偏。
 * 采菊东篱下，悠然见南山。
 * 山气日夕佳，飞鸟相与还。
 * 此中有真意，欲辨已忘言。
 * @Author LiuGuiNan
 * @Date 2021/1/15 14:22
 * @Version 1.0
 * @Description XxlJob任务Executor配置
 **/
@Configuration
public class XxlTaskConfig {

    @Autowired
    private TaskConfig taskConfig;

    @Bean(initMethod = "start", destroyMethod = "destroy")
    public XxlJobSpringExecutor xxlJobExecutor() {
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(taskConfig.getAdminAddresses());
        xxlJobSpringExecutor.setAppname(taskConfig.getAppName());
        xxlJobSpringExecutor.setIp(taskConfig.getIp());
        xxlJobSpringExecutor.setPort(taskConfig.getPort());
        xxlJobSpringExecutor.setAccessToken(taskConfig.getAccessToken());
        xxlJobSpringExecutor.setLogPath(taskConfig.getLogPath());
        xxlJobSpringExecutor.setLogRetentionDays(taskConfig.getLogRetentionDays());
        return xxlJobSpringExecutor;
    }

}
