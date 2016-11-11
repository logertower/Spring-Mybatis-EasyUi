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

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.founder.medical.entity.mysql.User;

/**
 * @author liutf
 * 
 */
@RequestMapping("/layout")
public class LayoutController {
	public Logger log = Logger.getLogger(LayoutController.class);

	/**
	 * 后台管理进入页面
	 * 
	 * @author liutf
	 * @return
	 */
	@RequestMapping("/index.html")
	public ModelAndView index(HttpSession session) {
		ModelAndView mv = new ModelAndView("/index");
		User systemUser = (User) session
				.getAttribute(Constant.CURRENT_SYSTEM_USER);

		if (systemUser != null) {
			mv.addObject("user", systemUser);
			mv.addObject("flag", "sys");
		}
		return mv;
	}

	@RequestMapping("/portal/index.html")
	public ModelAndView indexOfPortal(HttpSession session) {
		ModelAndView mv = new ModelAndView("/portal/index");
		User user = (User) session.getAttribute(Constant.CURRENT_SYSTEM_USER);

		if (user != null) {
			mv.addObject("user", user);
			mv.addObject("flag", "sys");
		}
		return mv;
	}

	@RequestMapping("/east.html")
	public ModelAndView east(HttpSession session) {
		ModelAndView mv = new ModelAndView("/layout/east");
		User user = (User) session.getAttribute(Constant.CURRENT_SYSTEM_USER);

		if (user != null) {
			mv.addObject("user", user);
			mv.addObject("flag", "sys");
		}
		return mv;
	}

	@RequestMapping("/north.html")
	public ModelAndView north(HttpSession session) {
		ModelAndView mv = new ModelAndView("/layout/north");
		User user = (User) session.getAttribute(Constant.CURRENT_SYSTEM_USER);

		if (user != null) {
			mv.addObject("user", user);
			mv.addObject("flag", "sys");
		}
		return mv;
	}

	@RequestMapping("/south.html")
	public ModelAndView south(HttpSession session) {
		ModelAndView mv = new ModelAndView("/layout/south");
		User user = (User) session.getAttribute(Constant.CURRENT_SYSTEM_USER);

		if (user != null) {
			mv.addObject("user", user);
			mv.addObject("flag", "sys");
		}
		return mv;
	}

	@RequestMapping("/west.html")
	public ModelAndView west(HttpSession session) {
		ModelAndView mv = new ModelAndView("/layout/west");
		User user = (User) session.getAttribute(Constant.CURRENT_SYSTEM_USER);

		if (user != null) {
			mv.addObject("user", user);
			mv.addObject("flag", "sys");
		}
		return mv;
	}

}
