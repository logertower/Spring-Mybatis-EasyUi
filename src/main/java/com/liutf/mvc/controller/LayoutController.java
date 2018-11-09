package com.liutf.mvc.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author liutf
 */
@Controller
@RequestMapping("/layout")
public class LayoutController {
    public Logger log = Logger.getLogger(LayoutController.class);

    /**
     * 后台管理进入页面
     *
     * @return
     * @author liutf
     */
    @RequestMapping("/index.html")
    public ModelAndView index(HttpSession session) {
        ModelAndView mv = new ModelAndView("/index");
        return mv;
    }

    @RequestMapping("/portal/index.html")
    public ModelAndView indexOfPortal(HttpSession session) {
        ModelAndView mv = new ModelAndView("/portal/index");
        return mv;
    }

    @RequestMapping("/east.html")
    public ModelAndView east(HttpSession session) {
        ModelAndView mv = new ModelAndView("/layout/east");
        return mv;
    }

    @RequestMapping("/north.html")
    public ModelAndView north(HttpSession session) {
        ModelAndView mv = new ModelAndView("/layout/north");
        return mv;
    }

    @RequestMapping("/south.html")
    public ModelAndView south(HttpSession session) {
        ModelAndView mv = new ModelAndView("/layout/south");
        return mv;
    }

    @RequestMapping("/west.html")
    public ModelAndView west(HttpSession session) {
        ModelAndView mv = new ModelAndView("/layout/west");
        return mv;
    }


    @RequestMapping("/customer/customerManager.html")
    public ModelAndView customerManager(HttpSession session) {
        ModelAndView mv = new ModelAndView("/customer/customerManager");
        return mv;
    }

    @RequestMapping("/customer/customerLevelPointManager.html")
    public ModelAndView customercustomerLevelPointManager(HttpSession session) {
        ModelAndView mv = new ModelAndView("/customer/customerLevelPointManager");
        return mv;
    }

    @RequestMapping("/customer/customerBalanceManager.html")
    public ModelAndView customerBalanceManager(HttpSession session) {
        ModelAndView mv = new ModelAndView("/customer/customerBalanceManager");
        return mv;
    }

    @RequestMapping("/customer/customerMessageManager.html")
    public ModelAndView customerMessageManager(HttpSession session) {
        ModelAndView mv = new ModelAndView("/customer/customerMessageManager");
        return mv;
    }

}
