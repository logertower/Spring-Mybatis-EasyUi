package com.liutf.mvc.dao.mysql;

import com.liutf.mvc.entity.mysql.Test;
import com.liutf.mvc.entity.mysql.TestExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestMapper {
    int countByExample(TestExample example);

    int deleteByExample(TestExample example);

    int insert(Test record);

    int insertSelective(Test record);

    List<Test> selectByExample(TestExample example);

    int updateByExampleSelective(@Param("record") Test record, @Param("example") TestExample example);

    int updateByExample(@Param("record") Test record, @Param("example") TestExample example);
}