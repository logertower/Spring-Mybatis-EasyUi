package com.liutf.mvc.controller;

import com.liutf.common.exception.LocalException;
import com.liutf.common.jsonResult.JsonResult;
import com.liutf.mvc.service.CustomerService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liutf
 */
@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseController {
    public Logger log = Logger.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    /**
     * 后台管理进入页面
     *
     * @return
     * @author liutf
     */
    @RequestMapping("/customerManager.html")
    @ResponseBody
    public JsonResult customerManager(String environment, String operationType, String conditionType, String condition) throws LocalException {
        /**
         * 参数校验
         */
        if (StringUtils.isBlank(environment)) {
            throw new LocalException("200002", "环境不能为空");
        }
        if (StringUtils.isBlank(operationType)) {
            throw new LocalException("200002", "操作类型不能为空");
        }
        if (StringUtils.isBlank(conditionType)) {
            throw new LocalException("200002", "条件类型不能为空");
        }
        if (StringUtils.isBlank(condition)) {
            throw new LocalException("200002", "条件不能为空");
        }

        /**
         * 进行操作
         */
        boolean result = customerService.customerManager(environment, operationType, conditionType, condition);

        /**
         * 返回结果
         */
        return new JsonResult(1, result);
    }

}
