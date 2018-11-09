package com.liutf.mvc.redis;

import com.by.bimdb.model.BPipeline;
import com.by.bimdb.service.RedisSentinelService;
import com.by.bimdb.service.impl.RedisSentinelServiceImpl;
import com.liutf.mvc.config.ByConfig;
import com.liutf.mvc.config.ByConfigUtils;
import com.liutf.mvc.config.MemberRedisConfig;
import com.liutf.mvc.utils.MyThreadLocal;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Pipeline;

/**
 * 用户缓存服务
 *
 * @author ltf
 * @create 2018-09-01 下午 06:16
 */
@Service
public class ToolsRedisService {

    /**
     * 清除api的用户缓存
     */
    public boolean delCustomerCacheOfApi(Integer customerId, Integer idcard, String mobile, String wechatUnionid, String qqOpenId) {

        String environment = MyThreadLocal.get();

        ByConfig byConfig = ByConfigUtils.get(environment);

        try {
            RedisSentinelService redisSentinelService = getSentinel();
            BPipeline bp = redisSentinelService.pipeline();
            Pipeline pipelined = bp.pipeline();

            if (customerId != null && customerId > 0) {
                String key = "customer_uid_" + customerId;
                pipelined.del(key);
            }
            if (idcard != null && idcard > 0) {
                String key = "customer_idcard_" + idcard;
                pipelined.del(key);
            }
            if (StringUtils.isNotBlank(mobile)) {
                String key = "customer_mobile_" + mobile;
                pipelined.del(key);
            }
            if (StringUtils.isNotBlank(wechatUnionid)) {
                String key = "customer_openid_" + wechatUnionid;
                pipelined.del(key);
            }
            if (StringUtils.isNotBlank(qqOpenId)) {
                String key = "customer_openid_" + qqOpenId;
                pipelined.del(key);
            }

            bp.submitAndReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    /**
     * 清除member的用户缓存
     */
    public boolean delCustomerCacheOfMember(Integer customerId, Integer idcard, String mobile, String wechatUnionid, String qqOpenId) {
        try {
            RedisSentinelService redisSentinelService = getSentinel();
            BPipeline bp = redisSentinelService.pipeline();
            Pipeline pipelined = bp.pipeline();

            if (customerId != null && customerId > 0) {
                String key = "member:cstm:info:" + customerId;
                pipelined.del(key);
                String key2 = "member:bindCustomerList:" + customerId;
                pipelined.del(key2);
            }
            if (idcard != null && idcard > 0) {
                String key = "member:cstm:idCard2customerId:" + idcard;
                pipelined.del(key);
            }
            if (StringUtils.isNotBlank(mobile)) {
                String key = "member:cstm:mobile2customerId:" + mobile;
                pipelined.del(key);
            }
            if (StringUtils.isNotBlank(wechatUnionid)) {
                String key = "member:cstm:wechatUnionid2customerId:" + wechatUnionid;
                pipelined.del(key);
            }
            if (StringUtils.isNotBlank(qqOpenId)) {
                String key = "member:cstm:qqOpenId2customerId:" + qqOpenId;
                pipelined.del(key);
            }

            bp.submitAndReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    /**
     * 清除阻碍短信限制缓存
     */
    public boolean delForUnsms() {
        //TODO LTF 如何清除这些缓存

        return true;
    }

    /**
     * 删除member的等级缓存
     */
    public boolean delCustomerLevelPointCacheOfMember(Integer customerId) {
        try {
            RedisSentinelService redisSentinelService = getSentinel();
            BPipeline bp = redisSentinelService.pipeline();
            Pipeline pipelined = bp.pipeline();

            if (customerId != null && customerId > 0) {
                String key = "member:level:point:list:" + customerId;
                pipelined.del(key);
            }

            bp.submitAndReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    private RedisSentinelService getSentinel() throws Exception {
        String environment = MyThreadLocal.get();

        ByConfig byConfig = ByConfigUtils.get(environment);

        MemberRedisConfig memberRedisConfig = byConfig.getMemberRedisConfig();

        int appId = 10044;
        int clusterId = 24;
        String sentinelHost = memberRedisConfig.getSentinelHost();
        String masterName = memberRedisConfig.getMasterName();
        int maxWaitMillis = 1000;
        int maxTotal = 100;
        int minIdle = 50;
        int maxIdle = 100;
        int timeOut = 2000;

        return new RedisSentinelServiceImpl(appId, clusterId, sentinelHost, masterName, maxWaitMillis, maxTotal, minIdle, maxIdle, timeOut);
    }
}
