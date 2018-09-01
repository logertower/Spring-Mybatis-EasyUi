package com.liutf.mvc.service;

import com.liutf.common.exception.LocalException;
import com.liutf.mvc.dao.mysql.CustomerDao;
import com.liutf.mvc.entity.mysql.Customer;
import com.liutf.mvc.redis.CustomerRedisService;
import com.liutf.mvc.utils.MyThreadLocal;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

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
         * delAndClear、clear、makeOldThrid、clearLevelPointCache
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

        } else if ("makeOldThrid".equals(operationType)) {
            int i = customerDao.updateMobileToNullByCustomerId(customer.getCustomerId());
            if (i > 0) {
                customerRedisService.delCustomerCacheOfApi(customer.getCustomerId(), customer.getIdcard(), customer.getMobile() == null ? null : customer.getMobile().replace("_test", ""), customer.getWechatUnionid() == null ? null : customer.getWechatUnionid().replace("_test", ""), customer.getQqOpenid() == null ? null : customer.getQqOpenid().replace("_test", ""));
                customerRedisService.delCustomerCacheOfMember(customer.getCustomerId(), customer.getIdcard(), customer.getMobile() == null ? null : customer.getMobile().replace("_test", ""), customer.getWechatUnionid() == null ? null : customer.getWechatUnionid().replace("_test", ""), customer.getQqOpenid() == null ? null : customer.getQqOpenid().replace("_test", ""));
            }

        } else if ("clearLevelPointCache".equals(operationType)) {
            customerRedisService.delCustomerLevelPointCacheOfMember(customer.getCustomerId());
        }

        return true;
    }
}
