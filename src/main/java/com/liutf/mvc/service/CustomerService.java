package com.liutf.mvc.service;

import org.apache.log4j.Logger;

/**
 * @description: UserService
 * @author: liutf
 * @date: 2015年1月22日 下午4:12:19
 * @version: V1.0.0
 */
public class CustomerService {

    public Logger log = Logger.getLogger(CustomerService.class);

    //@Autowired
    //private customerma userMapper;

    /**
     * 账号管理
     *
     * @param environment
     * @param operationType
     * @param conditionType
     * @param condition
     * @return
     */
    public boolean customerManager(String environment, String operationType, String conditionType, String condition) {
        /**
         * 选择环境
         * mojie、shuangzi、shuangyu、baiyang
         */

        /**
         * 选择操作类型
         * delAndClear、clear、makeOldThrid
         */


        /**
         * 条件类型
         * customerId、mobile、idCard、weichatUnionid、qqOpenId
         */

        return false;
    }

    private

}
