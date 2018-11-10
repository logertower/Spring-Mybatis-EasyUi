package com.liutf.mvc.config;

/**
 * 配置类
 *
 * @author ltf
 * @create 2018-09-01 下午 06:23
 */
public class ByConfig {

    /**
     * 环境
     */
    private String environment;

    /**
     * 环境名（中文）
     */
    private String environmentName;

    /**
     * redis哨兵
     */
    private MemberRedisConfig memberRedisConfig;

    /**
     * sqlserver配置
     */
    private SqlServerConfig sqlServerConfig;

    /**
     * mysql配置
     */
    private MySqlConfig mysqlConfig;

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getEnvironmentName() {
        return environmentName;
    }

    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName;
    }

    public MySqlConfig getMysqlConfig() {
        return mysqlConfig;
    }

    public void setMysqlConfig(MySqlConfig mysqlConfig) {
        this.mysqlConfig = mysqlConfig;
    }

    public MemberRedisConfig getMemberRedisConfig() {
        return memberRedisConfig;
    }

    public void setMemberRedisConfig(MemberRedisConfig memberRedisConfig) {
        this.memberRedisConfig = memberRedisConfig;
    }

    public SqlServerConfig getSqlServerConfig() {
        return sqlServerConfig;
    }

    public void setSqlServerConfig(SqlServerConfig sqlServerConfig) {
        this.sqlServerConfig = sqlServerConfig;
    }
}
