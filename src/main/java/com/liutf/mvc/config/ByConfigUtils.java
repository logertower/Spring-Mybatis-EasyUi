package com.liutf.mvc.config;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ltf
 * @create 2018-09-01 下午 06:33
 */
@Component
public class ByConfigUtils {

    public static Map<String, ByConfig> byConfigMap = new HashMap<>();

    @PostConstruct
    public static void init() {
        //TODO LTF 从配置文件（json）结构中，加载初始化数据

        /**
         * 初始化摩羯座配置
         */
        ByConfig byConfigOfMojie = new ByConfig();

        byConfigOfMojie.setEnvironment("mojie");
        byConfigOfMojie.setEnvironmentName("摩羯");

        //member redis 配置 一个哨兵
        MemberRedisConfig memberRedisConfigOfMojie = new MemberRedisConfig();
        memberRedisConfigOfMojie.setSentinelHost("172.17.253.251:27002");
        memberRedisConfigOfMojie.setMasterName("byMaster7002");

        byConfigOfMojie.setMemberRedisConfig(memberRedisConfigOfMojie);

        //sqlserver 配置 一个
        SqlServerConfig sqlServerConfigOfMojie = new SqlServerConfig();
        sqlServerConfigOfMojie.setUrl("jdbc:sqlserver://172.17.253.249:1433;database=by_dz_new");
        sqlServerConfigOfMojie.setUsername("by_test");
        sqlServerConfigOfMojie.setPassword("0-dev..Com");

        byConfigOfMojie.setSqlServerConfig(sqlServerConfigOfMojie);


        byConfigMap.put("mojie", byConfigOfMojie);


        /**
         * 初始化双子座配置
         */
        ByConfig byConfigOfShuangzi = new ByConfig();
        byConfigOfShuangzi.setEnvironment("shuangzi");
        byConfigOfShuangzi.setEnvironmentName("双子");

        //member redis 配置 一个哨兵
        MemberRedisConfig memberRedisConfigOfShuangzi = new MemberRedisConfig();
        memberRedisConfigOfShuangzi.setSentinelHost("172.17.12.251:27002");
        memberRedisConfigOfShuangzi.setMasterName("byMaster7002");

        byConfigOfShuangzi.setMemberRedisConfig(memberRedisConfigOfShuangzi);

        //sqlserver 配置 一个
        SqlServerConfig sqlServerConfigOfShuangzi = new SqlServerConfig();
        sqlServerConfigOfShuangzi.setUrl("jdbc:sqlserver://172.17.12.249:1433;database=by_dz_new");
        sqlServerConfigOfShuangzi.setUsername("by_test");
        sqlServerConfigOfShuangzi.setPassword("0-dev..Com");

        byConfigOfShuangzi.setSqlServerConfig(sqlServerConfigOfShuangzi);

        byConfigMap.put("shuangzi", byConfigOfShuangzi);


        /**
         * 初始化双鱼座配置
         */
        ByConfig byConfigOfShuangyu = new ByConfig();

        byConfigOfShuangyu.setEnvironment("shuangyu");
        byConfigOfShuangyu.setEnvironmentName("双鱼");

        //member redis 配置 一个哨兵
        MemberRedisConfig memberRedisConfigOfShuangyu = new MemberRedisConfig();
        memberRedisConfigOfShuangyu.setSentinelHost("172.17.20.254:27002");
        memberRedisConfigOfShuangyu.setMasterName("byMaster7002");

        byConfigOfShuangyu.setMemberRedisConfig(memberRedisConfigOfShuangyu);

        //sqlserver 配置 一个
        SqlServerConfig sqlServerConfigOfShuangyu = new SqlServerConfig();
        sqlServerConfigOfShuangyu.setUrl("jdbc:sqlserver://172.17.20.249:1433;database=by_dz_new");
        sqlServerConfigOfShuangyu.setUsername("by_test");
        sqlServerConfigOfShuangyu.setPassword("0-dev..Com");

        byConfigOfShuangyu.setSqlServerConfig(sqlServerConfigOfShuangyu);

        byConfigMap.put("shuangyu", byConfigOfShuangyu);


        /**
         * 初始化白羊座配置
         */
        ByConfig byConfigOfBaiyang = new ByConfig();

        byConfigOfBaiyang.setEnvironment("baiyang");
        byConfigOfBaiyang.setEnvironmentName("白羊");

        //member redis 配置 一个哨兵
        MemberRedisConfig memberRedisConfigOfBaiyang = new MemberRedisConfig();
        memberRedisConfigOfBaiyang.setSentinelHost("172.17.17.251:27002");
        memberRedisConfigOfBaiyang.setMasterName("byMaster7002");

        byConfigOfBaiyang.setMemberRedisConfig(memberRedisConfigOfBaiyang);

        //sqlserver 配置 一个
        SqlServerConfig sqlServerConfigOfBaiyang = new SqlServerConfig();
        sqlServerConfigOfBaiyang.setUrl("jdbc:sqlserver://172.17.17.249:1433;database=by_dz_new");
        sqlServerConfigOfBaiyang.setUsername("by_test");
        sqlServerConfigOfBaiyang.setPassword("0-dev..Com");

        byConfigOfBaiyang.setSqlServerConfig(sqlServerConfigOfBaiyang);

        byConfigMap.put("baiyang", byConfigOfBaiyang);
    }

    public static ByConfig get(String environment) {
        return byConfigMap.get(environment);
    }

}
