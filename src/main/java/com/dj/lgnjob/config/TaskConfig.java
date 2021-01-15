package com.dj.lgnjob.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName TaskConfig
 * @Description 陶渊明
 * 结庐在人境，而无车马喧。
 * 问君何能尔？心远地自偏。
 * 采菊东篱下，悠然见南山。
 * 山气日夕佳，飞鸟相与还。
 * 此中有真意，欲辨已忘言。
 * @Author LiuGuiNan
 * @Date 2021/1/15 14:22
 * @Version 1.0
 * @Description XxlJob基本参数配置
 **/
@Configuration
@ConfigurationProperties(prefix = "xxl.job")
public class TaskConfig {
    private String adminAddresses;

    private String appName;

    private String ip;

    private int port;

    private String accessToken;

    private String logPath;

    private int logRetentionDays;

    public String getAdminAddresses() {
        return adminAddresses;
    }

    public void setAdminAddresses(String adminAddresses) {
        this.adminAddresses = adminAddresses;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getLogPath() {
        return logPath;
    }

    public void setLogPath(String logPath) {
        this.logPath = logPath;
    }

    public int getLogRetentionDays() {
        return logRetentionDays;
    }

    public void setLogRetentionDays(int logRetentionDays) {
        this.logRetentionDays = logRetentionDays;
    }
}
