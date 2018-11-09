package com.liutf.mvc.controller;

import com.liutf.common.exception.LocalException;
import com.liutf.common.jsonResult.JsonResult;
import com.liutf.mvc.service.ToolsService;
import com.liutf.mvc.utils.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liutf
 */
@Controller
@RequestMapping("/tools")
public class ToolsController extends BaseController {
    public Logger log = Logger.getLogger(ToolsController.class);

    @Autowired
    private ToolsService toolsService;

    /**
     * 用户信息管理
     *
     * @return
     * @author liutf
     */
    @RequestMapping("/customerManager.do")
    @ResponseBody
    public JsonResult customerManager(String environment, String operationType, String conditionType, String condition) throws LocalException {

        try {
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

            if ("customerId".equals(conditionType) && (!StringUtils.isNumeric(condition) || Integer.parseInt(condition) <= 0)) {
                throw new LocalException("200002", "用户id需为正整数");
            } else if ("idCard".equals(conditionType) && (!StringUtils.isNumeric(condition) || Integer.parseInt(condition) <= 0)) {
                throw new LocalException("200002", "idcard需为正整数");
            } else if ("mobile".equals(conditionType) && !StringUtil.isValidMobile(condition)) {
                throw new LocalException("200002", "手机号格式错误");
            }

            /**
             * 进行操作
             */
            boolean result = toolsService.customerManager(environment, operationType, conditionType, condition);

            if (result) {
                log.info("[账号管理，操作成功]environment=" + environment + ",operationType=" + operationType + ",conditionType=" + conditionType + ",condition=" + condition);
            }

            /**
             * 返回结果
             */
            return new JsonResult(1, result);
        } catch (Exception e) {
            log.error("[账号管理，操作失败]environment=" + environment + ",operationType=" + operationType + ",conditionType=" + conditionType + ",condition=" + condition, e);
            throw e;
        }
    }


    /**
     * 用户等级信息管理
     *
     * @return
     * @author liutf
     */
    @RequestMapping("/customerLevelPointManager.do")
    @ResponseBody
    public JsonResult customerLevelPointManager(String environment, String operationType, String customerId, String levelId) throws LocalException {

        try {
            /**
             * 参数校验
             */
            if (StringUtils.isBlank(environment)) {
                throw new LocalException("200002", "环境不能为空");
            }
            if (StringUtils.isBlank(operationType)) {
                throw new LocalException("200002", "操作类型不能为空");
            }
            if (StringUtils.isBlank(customerId) || !NumberUtils.isDigits(customerId)) {
                throw new LocalException("200002", "用户Id不能为空或不是数字");
            }
            if (StringUtils.isBlank(levelId)) {
                throw new LocalException("200002", "用户等级不能为空");
            }

            /**
             * 进行操作
             */
            boolean result = toolsService.customerLevelPointManager(environment, operationType, customerId, levelId);

            if (result) {
                log.info("[用户等级信息管理，操作成功]environment=" + environment + ",operationType=" + operationType + ",customerId=" + customerId + ",levelId=" + levelId);
            }

            /**
             * 返回结果
             */
            return new JsonResult(1, result);
        } catch (Exception e) {
            log.error("[等级管理，操作失败]environment=" + environment + ",operationType=" + operationType + ",customerId=" + customerId + ",levelId=" + levelId, e);
            throw e;
        }
    }


    /**
     * 用户余额信息管理
     *
     * @return
     * @author liutf
     */
    @RequestMapping("/customerBalanceManager.do")
    @ResponseBody
    public JsonResult customerBalanceManager(String environment, String operationType, String customerId, String balance) throws LocalException {

        try {
            /**
             * 参数校验
             */
            if (StringUtils.isBlank(environment)) {
                throw new LocalException("200002", "环境不能为空");
            }
            if (StringUtils.isBlank(operationType)) {
                throw new LocalException("200002", "操作类型不能为空");
            }
            if (StringUtils.isBlank(customerId) || !NumberUtils.isDigits(customerId)) {
                throw new LocalException("200002", "用户Id不能为空或不是数字");
            }
            if (StringUtils.isBlank(balance)) {
                throw new LocalException("200002", "用户余额不能为空");
            }

            /**
             * 进行操作
             */
            boolean result = toolsService.customerBalanceManager(environment, operationType, customerId, balance);

            if (result) {
                log.info("[用户余额信息管理，操作成功]environment=" + environment + ",operationType=" + operationType + ",customerId=" + customerId + ",balance=" + balance);
            }

            /**
             * 返回结果
             */
            return new JsonResult(1, result);
        } catch (Exception e) {
            log.error("[余额管理，操作失败]environment=" + environment + ",operationType=" + operationType + ",customerId=" + customerId + ",balance=" + balance, e);
            throw e;
        }
    }

    /**
     * 短信管理
     *
     * @return
     * @author liutf
     */
    @RequestMapping("/customerMessageManager.do")
    @ResponseBody
    public JsonResult customerMessageManager(String environment, String operationType) throws LocalException {

        try {
            /**
             * 参数校验
             */
            if (StringUtils.isBlank(environment)) {
                throw new LocalException("200002", "环境不能为空");
            }
            if (StringUtils.isBlank(operationType)) {
                throw new LocalException("200002", "操作类型不能为空");
            }

            /**
             * 进行操作
             */
            boolean result = toolsService.customerMessageManager(environment, operationType);

            if (result) {
                log.info("[短信管理，操作成功]environment=" + environment + ",operationType=" + operationType);
            }

            /**
             * 返回结果
             */
            return new JsonResult(1, result);
        } catch (Exception e) {
            log.error("[短信管理，操作失败]environment=" + environment + ",operationType=" + operationType, e);
            throw e;
        }
    }
}
