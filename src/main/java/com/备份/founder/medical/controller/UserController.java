/**
 * Copyright (C) 2014 	北京方正阿帕比技术有限公司	开发一部
 * 
 * 后台管理
 * 
 * 2014年12月1日
 * 
 * liutf 
 */
package com.founder.medical.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.medical.entity.mysql.User;
import com.founder.medical.service.UserService;
import com.founder.medical.utils.MD5Util;
import com.founder.medical.utils.ToJson;

/**
 * @author liutf
 * 
 */
@RequestMapping("/user")
public class UserController {
	public Logger log = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/**
	 * 用户登录
	 * 
	 * @param user
	 *            用户对象
	 * @param session
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/login")
	public ToJson login(String name, String pwd, HttpSession session,
			HttpServletRequest request) {
		ToJson json = new ToJson();
		System.out.println(MD5Util.md5(pwd));

		try {

			User user = userService.login(name, pwd);
//			User user = new User();
//			user.setUsername("username");
//			user.setPassword("password");
//			user.setId(1);

			if (user != null) {
				session.setAttribute(Constant.CURRENT_SYSTEM_USER, user);
				json.setRtCode("0");
				json.setRtMsg("登陆成功!");
				json.setRtData(user);

			} else {
				json.setRtCode("12");
				json.setRtMsg("用户名或密码错误！");
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			json.setRtCode("99");
			json.setRtMsg("后台报错！");
		}

		return json;
	}

	/**
	 * 退出登录
	 * 
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/logout")
	public ToJson logout(HttpSession session) {
		ToJson json = new ToJson();
		if (session != null) {
			session.invalidate();
		}
		json.setRtCode("0");
		json.setRtMsg("注销成功！");
		return json;
	}

}
