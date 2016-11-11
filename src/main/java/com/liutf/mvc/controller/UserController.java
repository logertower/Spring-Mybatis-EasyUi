/**
 * Copyright (C) 2014 	北京方正阿帕比技术有限公司	开发一部
 * <p>
 * 后台管理
 * <p>
 * 2014年12月1日
 * <p>
 * liutf
 */
package com.liutf.mvc.controller;

import com.liutf.common.jsonResult.JsonResult;
import com.liutf.mvc.entity.mysql.User;
import com.liutf.mvc.service.UserService;
import com.liutf.mvc.utils.MD5Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author liutf
 */
@RequestMapping("/user")
public class UserController {
    public Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     *
     * @param user    用户对象
     * @param session
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    public JsonResult login(String name, String pwd, HttpSession session, HttpServletRequest request) {
        System.out.println(MD5Util.md5(pwd));

        try {

            User user = userService.login(name, pwd);
//			User user = new User();
//			user.setUsername("username");
//			user.setPassword("password");
//			user.setId(1);

            if (user != null) {
                session.setAttribute(Constant.CURRENT_SYSTEM_USER, user);
                return new JsonResult(1, user);

            } else {
                //json.setRtCode("12");
                //json.setRtMsg("用户名或密码错误！");
                return new JsonResult(12, "用户名或密码错误！");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            //json.setRtCode("99");
            //json.setRtMsg("后台报错！");

            return new JsonResult(99, "后台报错！");
        }
    }

    /**
     * 退出登录
     *
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/logout")
    public JsonResult logout(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
        //json.setRtCode("0");
        //json.setRtMsg("注销成功！");
        return new JsonResult(0, "注销成功！");
        //return json;
    }

}
