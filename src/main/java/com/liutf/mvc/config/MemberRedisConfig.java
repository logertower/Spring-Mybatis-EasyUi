package com.liutf.mvc.config;

/**
 * @author ltf
 * @create 2018-09-01 下午 06:25
 */
public class MemberRedisConfig {

    String sentinelHost;
    String masterName;

    public String getSentinelHost() {
        return sentinelHost;
    }

    public void setSentinelHost(String sentinelHost) {
        this.sentinelHost = sentinelHost;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }
}
