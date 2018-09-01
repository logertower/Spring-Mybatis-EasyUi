package com.liutf.mvc.redis;

import com.liutf.mvc.config.ApiRedisConfig;
import com.liutf.mvc.config.ByConfig;
import com.liutf.mvc.config.ByConfigUtils;
import com.liutf.mvc.config.MemberRedisConfig;
import com.liutf.mvc.utils.MyThreadLocal;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.io.IOException;

/**
 * 用户缓存服务
 *
 * @author ltf
 * @create 2018-09-01 下午 06:16
 */
@Service
public class CustomerRedisService {

    /**
     * 清除api的用户缓存
     */
    public boolean delCustomerCacheOfApi(Integer customerId, Integer idcard, String mobile, String wechatUnionid, String qqOpenId) {

        String environment = MyThreadLocal.get();

        ByConfig byConfig = ByConfigUtils.get(environment);

        for (ApiRedisConfig apiRedisConfig : byConfig.getApiRedisConfigList()) {
            Jedis jedis = new Jedis(apiRedisConfig.getHost(), apiRedisConfig.getPort());
            Pipeline pipelined = jedis.pipelined();
            try {
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

                pipelined.syncAndReturnAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    pipelined.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return true;
    }

    /**
     * 清除member的用户缓存
     */
    public boolean delCustomerCacheOfMember(Integer customerId, Integer idcard, String mobile, String wechatUnionid, String qqOpenId) {

        String environment = MyThreadLocal.get();

        ByConfig byConfig = ByConfigUtils.get(environment);

        MemberRedisConfig memberRedisConfig = byConfig.getMemberRedisConfig();

        Jedis jedis = new Jedis("", 0);//TODO ltf 等待初始化= new Jedis(memberRedisConfig.getMasterName())
        Pipeline pipelined = jedis.pipelined();

        try {
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

            pipelined.syncAndReturnAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pipelined.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    /**
     * 删除member的等级缓存
     */
    public boolean delCustomerLevelPointCacheOfMember(Integer customerId) {

        String environment = MyThreadLocal.get();

        ByConfig byConfig = ByConfigUtils.get(environment);

        MemberRedisConfig memberRedisConfig = byConfig.getMemberRedisConfig();

        Jedis jedis = new Jedis("", 0);//TODO ltf 等待初始化= new Jedis(memberRedisConfig.getMasterName())
        Pipeline pipelined = jedis.pipelined();

        try {
            if (customerId != null && customerId > 0) {
                String key = "member:level:point:list:" + customerId;
                pipelined.del(key);
            }

            pipelined.syncAndReturnAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pipelined.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return true;
    }

}
