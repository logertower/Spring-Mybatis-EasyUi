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

        ApiRedisConfig apiRedisConfigOfMojie1 = new ApiRedisConfig();
        apiRedisConfigOfMojie1.setHost("192.158.98.22");
        apiRedisConfigOfMojie1.setPort(6379);

        ApiRedisConfig apiRedisConfigOfMojie2 = new ApiRedisConfig();
        apiRedisConfigOfMojie2.setHost("192.158.98.22");
        apiRedisConfigOfMojie2.setPort(6380);

        ApiRedisConfig apiRedisConfigOfMojie3 = new ApiRedisConfig();
        apiRedisConfigOfMojie2.setHost("192.158.98.22");
        apiRedisConfigOfMojie2.setPort(6381);

        apiRedisConfigListOfMojie.add(apiRedisConfigOfMojie1);
        apiRedisConfigListOfMojie.add(apiRedisConfigOfMojie2);
        apiRedisConfigListOfMojie.add(apiRedisConfigOfMojie3);

        byConfigOfMojie.setApiRedisConfigList(apiRedisConfigListOfMojie);

        //member redis 配置 一个哨兵
        MemberRedisConfig memberRedisConfigOfMojie = new MemberRedisConfig();
        memberRedisConfigOfMojie.setSentinel("");
        memberRedisConfigOfMojie.setMasterName("");

        byConfigOfMojie.setMemberRedisConfig(memberRedisConfigOfMojie);

        //sqlserver 配置 一个
        SqlServerConfig sqlServerConfigOfMojie = new SqlServerConfig();
        sqlServerConfigOfMojie.setUrl("");
        sqlServerConfigOfMojie.setUsername("");
        sqlServerConfigOfMojie.setPassword("");

        byConfigOfMojie.setSqlServerConfig(sqlServerConfigOfMojie);


        byConfigMap.put("mojie", byConfigOfMojie);


        /**
         * 初始化双子座配置
         */
        ByConfig byConfigOfShuangzi = new ByConfig();

        //api redis 配置 三个
        List<ApiRedisConfig> apiRedisConfigListOfShuangzi = new ArrayList<>();

        ApiRedisConfig apiRedisConfigOfShuangzi1 = new ApiRedisConfig();
        apiRedisConfigOfShuangzi1.setHost("192.158.98.22");
        apiRedisConfigOfShuangzi1.setPort(6379);

        ApiRedisConfig apiRedisConfigOfShuangzi2 = new ApiRedisConfig();
        apiRedisConfigOfShuangzi2.setHost("192.158.98.22");
        apiRedisConfigOfShuangzi2.setPort(6380);

        ApiRedisConfig apiRedisConfigOfShuangzi3 = new ApiRedisConfig();
        apiRedisConfigOfShuangzi2.setHost("192.158.98.22");
        apiRedisConfigOfShuangzi2.setPort(6381);

        apiRedisConfigListOfShuangzi.add(apiRedisConfigOfShuangzi1);
        apiRedisConfigListOfShuangzi.add(apiRedisConfigOfShuangzi2);
        apiRedisConfigListOfShuangzi.add(apiRedisConfigOfShuangzi3);

        byConfigOfShuangzi.setApiRedisConfigList(apiRedisConfigListOfShuangzi);

        //member redis 配置 一个哨兵
        MemberRedisConfig memberRedisConfigOfShuangzi = new MemberRedisConfig();
        memberRedisConfigOfShuangzi.setSentinel("");
        memberRedisConfigOfShuangzi.setMasterName("");

        byConfigOfShuangzi.setMemberRedisConfig(memberRedisConfigOfShuangzi);

        //sqlserver 配置 一个
        SqlServerConfig sqlServerConfigOfShuangzi = new SqlServerConfig();
        sqlServerConfigOfShuangzi.setUrl("");
        sqlServerConfigOfShuangzi.setUsername("");
        sqlServerConfigOfShuangzi.setPassword("");

        byConfigOfShuangzi.setSqlServerConfig(sqlServerConfigOfShuangzi);

        byConfigMap.put("shuangzi", byConfigOfShuangzi);


        /**
         * 初始化双鱼座配置
         */
        ByConfig byConfigOfShuangyu = new ByConfig();

        //api redis 配置 三个
        List<ApiRedisConfig> apiRedisConfigListOfShuangyu = new ArrayList<>();

        ApiRedisConfig apiRedisConfigOfShuangyu1 = new ApiRedisConfig();
        apiRedisConfigOfShuangyu1.setHost("192.158.98.22");
        apiRedisConfigOfShuangyu1.setPort(6379);

        ApiRedisConfig apiRedisConfigOfShuangyu2 = new ApiRedisConfig();
        apiRedisConfigOfShuangyu2.setHost("192.158.98.22");
        apiRedisConfigOfShuangyu2.setPort(6380);

        ApiRedisConfig apiRedisConfigOfShuangyu3 = new ApiRedisConfig();
        apiRedisConfigOfShuangyu2.setHost("192.158.98.22");
        apiRedisConfigOfShuangyu2.setPort(6381);

        apiRedisConfigListOfShuangyu.add(apiRedisConfigOfShuangyu1);
        apiRedisConfigListOfShuangyu.add(apiRedisConfigOfShuangyu2);
        apiRedisConfigListOfShuangyu.add(apiRedisConfigOfShuangyu3);

        byConfigOfShuangyu.setApiRedisConfigList(apiRedisConfigListOfShuangyu);

        //member redis 配置 一个哨兵
        MemberRedisConfig memberRedisConfigOfShuangyu = new MemberRedisConfig();
        memberRedisConfigOfShuangyu.setSentinel("");
        memberRedisConfigOfShuangyu.setMasterName("");

        byConfigOfShuangyu.setMemberRedisConfig(memberRedisConfigOfShuangyu);

        //sqlserver 配置 一个
        SqlServerConfig sqlServerConfigOfShuangyu = new SqlServerConfig();
        sqlServerConfigOfShuangyu.setUrl("");
        sqlServerConfigOfShuangyu.setUsername("");
        sqlServerConfigOfShuangyu.setPassword("");

        byConfigOfShuangyu.setSqlServerConfig(sqlServerConfigOfShuangyu);

        byConfigMap.put("Shuangyu", byConfigOfShuangyu);


        /**
         * 初始化白羊座配置
         */
        ByConfig byConfigOfBaiyang = new ByConfig();

        //api redis 配置 三个
        List<ApiRedisConfig> apiRedisConfigListOfBaiyang = new ArrayList<>();

        ApiRedisConfig apiRedisConfigOfBaiyang1 = new ApiRedisConfig();
        apiRedisConfigOfBaiyang1.setHost("192.158.98.22");
        apiRedisConfigOfBaiyang1.setPort(6379);

        ApiRedisConfig apiRedisConfigOfBaiyang2 = new ApiRedisConfig();
        apiRedisConfigOfBaiyang2.setHost("192.158.98.22");
        apiRedisConfigOfBaiyang2.setPort(6380);

        ApiRedisConfig apiRedisConfigOfBaiyang3 = new ApiRedisConfig();
        apiRedisConfigOfBaiyang2.setHost("192.158.98.22");
        apiRedisConfigOfBaiyang2.setPort(6381);

        apiRedisConfigListOfBaiyang.add(apiRedisConfigOfBaiyang1);
        apiRedisConfigListOfBaiyang.add(apiRedisConfigOfBaiyang2);
        apiRedisConfigListOfBaiyang.add(apiRedisConfigOfBaiyang3);

        byConfigOfBaiyang.setApiRedisConfigList(apiRedisConfigListOfBaiyang);

        //member redis 配置 一个哨兵
        MemberRedisConfig memberRedisConfigOfBaiyang = new MemberRedisConfig();
        memberRedisConfigOfBaiyang.setSentinel("");
        memberRedisConfigOfBaiyang.setMasterName("");

        byConfigOfBaiyang.setMemberRedisConfig(memberRedisConfigOfBaiyang);

        //sqlserver 配置 一个
        SqlServerConfig sqlServerConfigOfBaiyang = new SqlServerConfig();
        sqlServerConfigOfBaiyang.setUrl("");
        sqlServerConfigOfBaiyang.setUsername("");
        sqlServerConfigOfBaiyang.setPassword("");

        byConfigOfBaiyang.setSqlServerConfig(sqlServerConfigOfBaiyang);

        byConfigMap.put("Baiyang", byConfigOfBaiyang);
    }

    public static ByConfig get(String environment) {
        if (byConfigMap == null || byConfigMap.isEmpty()) {
            init();
        }
        return byConfigMap.get(environment);
    }

}
