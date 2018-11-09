package com.liutf.mvc.controller;

import com.liutf.common.exception.LocalException;
import com.liutf.common.jsonResult.JsonResult;
import com.liutf.mvc.entity.Test;
import com.liutf.mvc.service.TestService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author liutf
 */
@Controller
@RequestMapping("/test")
public class TestController extends BaseController {
    public Logger log = Logger.getLogger(TestController.class);

    @Autowired
    private TestService testService;

    @RequestMapping("/doTest.do")
    @ResponseBody
    public JsonResult doTest() throws LocalException {

        //String[] arr = {"111"};
        //String s = arr[2];
        //
        //if(false){
        //    throw new LocalException("200002");
        //}

        List<Test> testList = testService.doTest();


        return new JsonResult(1, testList);
    }


}
