package com.liutf.mvc.service;

import com.liutf.common.exception.LocalException;
import com.liutf.mvc.dao.mysql.CustomerDao;
import com.liutf.mvc.entity.mysql.Customer;
import com.liutf.mvc.redis.CustomerRedisService;
import com.liutf.mvc.utils.MyThreadLocal;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @description: UserService
 * @author: liutf
 * @date: 2015年1月22日 下午4:12:19
 * @version: V1.0.0
 */
@Service
public class CustomerService {

    public Logger log = Logger.getLogger(CustomerService.class);

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private CustomerRedisService customerRedisService;

    /**
     * 账号管理
     *
     * @param environment   环境
     * @param operationType 操作类型
     * @param conditionType 条件类型
     * @param condition     条件
     * @return
     */
    public boolean customerManager(String environment, String operationType, String conditionType, String condition) throws LocalException {
        /**
         * 选择环境
         * mojie、shuangzi、shuangyu、baiyang
         */
        MyThreadLocal.set(environment);

        /**
         * 条件类型
         * customerId、idCard、mobile、weichatUnionid、qqOpenId
         */
        Customer customer = null;
        if ("customerId".equals(conditionType)) {
            customer = customerDao.getCustomerByCustomerId(Integer.parseInt(condition));
        } else if ("idCard".equals(conditionType)) {
            customer = customerDao.getCustomerByIdCard(Integer.parseInt(condition));
        } else if ("mobile".equals(conditionType)) {
            customer = customerDao.getCustomerByMobile(condition);
        } else if ("weichatUnionid".equals(conditionType)) {
            customer = customerDao.getCustomerByWechatUnionid(condition);
        } else if ("qqOpenId".equals(conditionType)) {
            customer = customerDao.getCustomerByQqOpenId(condition);
        }

        if (customer == null) {
            //<entry key="300000" value="账号不存在"/>
            throw new LocalException("300000");
        }

        /**
         * 选择操作类型
         * <option value="delAndClear" id="delAndClear">删除账号并清除缓存</option>
         * <option value="clear">清除账号缓存</option>
         * <option value="makeWxOldThrid">制造微信老三方</option>
         * <option value="makeQqOldThrid">制造qq老三方</option>
         */
        if ("delAndClear".equals(operationType)) {
            int i = customerDao.delCustomerByCustomerId(customer.getCustomerId());
            if (i > 0) {
                customerRedisService.delCustomerCacheOfApi(customer.getCustomerId(), customer.getIdcard(), customer.getMobile() == null ? null : customer.getMobile().replace("_test", ""), customer.getWechatUnionid() == null ? null : customer.getWechatUnionid().replace("_test", ""), customer.getQqOpenid() == null ? null : customer.getQqOpenid().replace("_test", ""));
                customerRedisService.delCustomerCacheOfMember(customer.getCustomerId(), customer.getIdcard(), customer.getMobile() == null ? null : customer.getMobile().replace("_test", ""), customer.getWechatUnionid() == null ? null : customer.getWechatUnionid().replace("_test", ""), customer.getQqOpenid() == null ? null : customer.getQqOpenid().replace("_test", ""));
            }

        } else if ("clear".equals(operationType)) {
            customerRedisService.delCustomerCacheOfApi(customer.getCustomerId(), customer.getIdcard(), customer.getMobile() == null ? null : customer.getMobile().replace("_test", ""), customer.getWechatUnionid() == null ? null : customer.getWechatUnionid().replace("_test", ""), customer.getQqOpenid() == null ? null : customer.getQqOpenid().replace("_test", ""));
            customerRedisService.delCustomerCacheOfMember(customer.getCustomerId(), customer.getIdcard(), customer.getMobile() == null ? null : customer.getMobile().replace("_test", ""), customer.getWechatUnionid() == null ? null : customer.getWechatUnionid().replace("_test", ""), customer.getQqOpenid() == null ? null : customer.getQqOpenid().replace("_test", ""));

        } else if ("makeWxOldThrid".equals(operationType)) {
            if (StringUtils.isBlank(customer.getMobile()) || StringUtils.isBlank(customer.getWechatUnionid())) {
                // <entry key="300001" value="账号不能成为微信老三方"/>
                throw new LocalException("300001");
            }

            int i = customerDao.updateMobileAndQqOpenIdToNullByCustomerId(customer.getCustomerId());
            if (i > 0) {
                customerRedisService.delCustomerCacheOfApi(customer.getCustomerId(), customer.getIdcard(), customer.getMobile() == null ? null : customer.getMobile().replace("_test", ""), customer.getWechatUnionid() == null ? null : customer.getWechatUnionid().replace("_test", ""), customer.getQqOpenid() == null ? null : customer.getQqOpenid().replace("_test", ""));
                customerRedisService.delCustomerCacheOfMember(customer.getCustomerId(), customer.getIdcard(), customer.getMobile() == null ? null : customer.getMobile().replace("_test", ""), customer.getWechatUnionid() == null ? null : customer.getWechatUnionid().replace("_test", ""), customer.getQqOpenid() == null ? null : customer.getQqOpenid().replace("_test", ""));
            }

        } else if ("makeQqOldThrid".equals(operationType)) {
            if (StringUtils.isBlank(customer.getMobile()) || StringUtils.isBlank(customer.getQqOpenid())) {
                //<entry key="300002" value="账号不能成为QQ老三方"/>
                throw new LocalException("300002");
            }

            int i = customerDao.updateMobileAndWechatUnionidToNullByCustomerId(customer.getCustomerId());
            if (i > 0) {
                customerRedisService.delCustomerCacheOfApi(customer.getCustomerId(), customer.getIdcard(), customer.getMobile() == null ? null : customer.getMobile().replace("_test", ""), customer.getWechatUnionid() == null ? null : customer.getWechatUnionid().replace("_test", ""), customer.getQqOpenid() == null ? null : customer.getQqOpenid().replace("_test", ""));
                customerRedisService.delCustomerCacheOfMember(customer.getCustomerId(), customer.getIdcard(), customer.getMobile() == null ? null : customer.getMobile().replace("_test", ""), customer.getWechatUnionid() == null ? null : customer.getWechatUnionid().replace("_test", ""), customer.getQqOpenid() == null ? null : customer.getQqOpenid().replace("_test", ""));
            }

        }

        return true;
    }

    /**
     * 用户等级管理
     *
     * @param environment
     * @param operationType
     * @param customerId
     * @param levelId
     * @return
     */
    public boolean customerLevelPointManager(String environment, String operationType, String customerId, String levelId) {

        /**
         * 选择环境
         * mojie、shuangzi、shuangyu、baiyang
         */
        MyThreadLocal.set(environment);

        /**
         * 选择操作类型
         * <option value="clearLevelPointCache">清除用户等级缓存</option>
         * <option value="updateLevelPoint">修改用户等级</option>
         */
        int customerIdI = Integer.parseInt(customerId);
        if ("clearLevelPointCache".equals(operationType)) {
            customerRedisService.delCustomerLevelPointCacheOfMember(customerIdI);

        } else if ("updateLevelPoint".equals(operationType)) {
            int levelIdI = Integer.parseInt(levelId);

            int i = customerDao.updateCustomerLevelPointByCustomerId(customerIdI, levelIdI);

            if (i > 0) {
                customerRedisService.delCustomerLevelPointCacheOfMember(customerIdI);
            }
        }

        return true;
    }

    /**
     * 用户余额管理
     *
     * @param environment
     * @param operationType
     * @param customerId
     * @param balance
     * @return
     */
    public boolean customerBalanceManager(String environment, String operationType, String customerId, String balance) {

        /**
         * 选择环境
         * mojie、shuangzi、shuangyu、baiyang
         */
        MyThreadLocal.set(environment);

        /**
         * 选择操作类型
         * <option value="addBalance" id="addBalance">余额充值</option>
         */
        int customerIdI = Integer.parseInt(customerId);
        BigDecimal balanceB = new BigDecimal(balance);
        if ("addBalance".equals(operationType)) {
            int i = customerDao.updateCustomerBalanceByCustomerId(customerIdI, balanceB);
            if (i > 0) {
                //TODO LTF 清除缓存
            }
        }

        return true;
    }

    /**
     * 短信管理
     *
     * @param environment
     * @param operationType
     * @return
     */
    public boolean customerMessageManager(String environment, String operationType) {

        /**
         * 选择环境
         * mojie、shuangzi、shuangyu、baiyang
         */
        MyThreadLocal.set(environment);

        /**
         * 选择操作类型
         * <option value="unsms" id="unsms">解除全部手机无法发送短信限制</option>
         */
        if ("unsms".equals(operationType)) {
            customerRedisService.delForUnsms();
        }

        return true;
    }
}
