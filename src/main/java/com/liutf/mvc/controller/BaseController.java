package com.liutf.mvc.controller;

import com.liutf.common.exception.ErrorInfos;
import com.liutf.common.exception.LocalException;
import com.liutf.common.jsonResult.JsonResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * controller层基类，用于处理异常等
 *
 * @author ltf
 * @create 2016-11-04 上午 10:52
 **/
@Controller
public class BaseController {

    private Log logger = LogFactory.getLog(getClass());

    @Autowired
    private ErrorInfos errorInfos;

    /**
     * 统一处理异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler
    @ResponseBody
    public JsonResult expHandler(Exception ex) {

        if (ex instanceof LocalException) {
            return new JsonResult(((LocalException) ex).getErrorCode(), errorInfos.getMsg(((LocalException) ex).getErrorCode()));
        } else {
            logger.error("系统未知异常", ex);
            return new JsonResult("000001", errorInfos.getMsg("000001"));
        }
    }
}
