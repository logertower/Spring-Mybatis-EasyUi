package com.liutf.mvc.config;

/**
 * @author ltf
 * @create 2018-09-01 下午 06:25
 */
public class MemberRedisConfig {

    private String sentinel;

    private String masterName;

    public String getSentinel() {
        return sentinel;
    }

    public void setSentinel(String sentinel) {
        this.sentinel = sentinel;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }
}
