package com.liutf.mvc.service;

import com.liutf.mvc.entity.mysql.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ltf
 * @create 2016-11-10 下午 6:58
 **/
@Service
public class TestService {

    @Autowired
    //private TestMapper testMapper;

    public List<Test> doTest() {
        //TestExample testExample = new TestExample();
        //testExample.or().andT1EqualTo("111");
        //testExample.setOrderByClause("t1");
        //List<Test> tests = testMapper.selectByExample(testExample);
        //return tests;
        return null;
    }

}
