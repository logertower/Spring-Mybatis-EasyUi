package com.liutf.mvc.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ltf
 * @create 2018-09-01 下午 06:33
 */
public class ByConfigUtils {

    public static Map<String, ByConfig> byConfigMap = new HashMap<>();

    public static void init() {
        /**
         * 初始化摩羯座配置
         */
        ByConfig byConfigOfMojie = new ByConfig();

        //api redis 配置 三个
        List<ApiRedisConfig> apiRedisConfigListOfMojie = new ArrayList<>();

        String hostOfMojie = "172.17.253.251";

        ApiRedisConfig apiRedisConfigOfMojie1 = new ApiRedisConfig();
        apiRedisConfigOfMojie1.setHost(hostOfMojie);
        apiRedisConfigOfMojie1.setPort(6379);

        ApiRedisConfig apiRedisConfigOfMojie2 = new ApiRedisConfig();
        apiRedisConfigOfMojie2.setHost(hostOfMojie);
        apiRedisConfigOfMojie2.setPort(6380);

        ApiRedisConfig apiRedisConfigOfMojie3 = new ApiRedisConfig();
        apiRedisConfigOfMojie3.setHost(hostOfMojie);
        apiRedisConfigOfMojie3.setPort(6381);

        apiRedisConfigListOfMojie.add(apiRedisConfigOfMojie1);
        apiRedisConfigListOfMojie.add(apiRedisConfigOfMojie2);
        apiRedisConfigListOfMojie.add(apiRedisConfigOfMojie3);

        byConfigOfMojie.setApiRedisConfigList(apiRedisConfigListOfMojie);

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

        String hostOfShuangzi = "172.17.12.251";

        //api redis 配置 三个
        List<ApiRedisConfig> apiRedisConfigListOfShuangzi = new ArrayList<>();

        ApiRedisConfig apiRedisConfigOfShuangzi1 = new ApiRedisConfig();
        apiRedisConfigOfShuangzi1.setHost(hostOfShuangzi);
        apiRedisConfigOfShuangzi1.setPort(6379);

        ApiRedisConfig apiRedisConfigOfShuangzi2 = new ApiRedisConfig();
        apiRedisConfigOfShuangzi2.setHost(hostOfShuangzi);
        apiRedisConfigOfShuangzi2.setPort(6380);

        ApiRedisConfig apiRedisConfigOfShuangzi3 = new ApiRedisConfig();
        apiRedisConfigOfShuangzi3.setHost(hostOfShuangzi);
        apiRedisConfigOfShuangzi3.setPort(6381);

        apiRedisConfigListOfShuangzi.add(apiRedisConfigOfShuangzi1);
        apiRedisConfigListOfShuangzi.add(apiRedisConfigOfShuangzi2);
        apiRedisConfigListOfShuangzi.add(apiRedisConfigOfShuangzi3);

        byConfigOfShuangzi.setApiRedisConfigList(apiRedisConfigListOfShuangzi);

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

        String hostOfShuangyu = "172.17.20.25";

        //api redis 配置 三个
        List<ApiRedisConfig> apiRedisConfigListOfShuangyu = new ArrayList<>();

        ApiRedisConfig apiRedisConfigOfShuangyu1 = new ApiRedisConfig();
        apiRedisConfigOfShuangyu1.setHost(hostOfShuangyu);
        apiRedisConfigOfShuangyu1.setPort(6379);

        ApiRedisConfig apiRedisConfigOfShuangyu2 = new ApiRedisConfig();
        apiRedisConfigOfShuangyu2.setHost(hostOfShuangyu);
        apiRedisConfigOfShuangyu2.setPort(6380);

        ApiRedisConfig apiRedisConfigOfShuangyu3 = new ApiRedisConfig();
        apiRedisConfigOfShuangyu3.setHost(hostOfShuangyu);
        apiRedisConfigOfShuangyu3.setPort(6381);

        apiRedisConfigListOfShuangyu.add(apiRedisConfigOfShuangyu1);
        apiRedisConfigListOfShuangyu.add(apiRedisConfigOfShuangyu2);
        apiRedisConfigListOfShuangyu.add(apiRedisConfigOfShuangyu3);

        byConfigOfShuangyu.setApiRedisConfigList(apiRedisConfigListOfShuangyu);

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

        String hostOfBaiyang = "";

        //api redis 配置 三个
        List<ApiRedisConfig> apiRedisConfigListOfBaiyang = new ArrayList<>();

        ApiRedisConfig apiRedisConfigOfBaiyang1 = new ApiRedisConfig();
        apiRedisConfigOfBaiyang1.setHost(hostOfBaiyang);
        apiRedisConfigOfBaiyang1.setPort(6379);

        ApiRedisConfig apiRedisConfigOfBaiyang2 = new ApiRedisConfig();
        apiRedisConfigOfBaiyang2.setHost(hostOfBaiyang);
        apiRedisConfigOfBaiyang2.setPort(6380);

        ApiRedisConfig apiRedisConfigOfBaiyang3 = new ApiRedisConfig();
        apiRedisConfigOfBaiyang3.setHost(hostOfBaiyang);
        apiRedisConfigOfBaiyang3.setPort(6381);

        apiRedisConfigListOfBaiyang.add(apiRedisConfigOfBaiyang1);
        apiRedisConfigListOfBaiyang.add(apiRedisConfigOfBaiyang2);
        apiRedisConfigListOfBaiyang.add(apiRedisConfigOfBaiyang3);

        byConfigOfBaiyang.setApiRedisConfigList(apiRedisConfigListOfBaiyang);

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
        if (byConfigMap == null || byConfigMap.isEmpty()) {
            init();
        }
        return byConfigMap.get(environment);
    }

}
