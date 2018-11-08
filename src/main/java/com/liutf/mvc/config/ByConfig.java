package com.liutf.mvc.config;

/**
 * 配置类
 *
 * @author ltf
 * @create 2018-09-01 下午 06:23
 */
public class ByConfig {

    //private List<ApiRedisConfig> apiRedisConfigList;

    private MemberRedisConfig memberRedisConfig;

    private SqlServerConfig sqlServerConfig;

    //public List<ApiRedisConfig> getApiRedisConfigList() {
    //    return apiRedisConfigList;
    //}
    //
    //public void setApiRedisConfigList(List<ApiRedisConfig> apiRedisConfigList) {
    //    this.apiRedisConfigList = apiRedisConfigList;
    //}

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
