package com.liutf.mvc.service;

import com.liutf.mvc.dao.mysql.UserMapper;
import com.liutf.mvc.entity.mysql.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description: UserService
 * @author: liutf
 * @date: 2015年1月22日 下午4:12:19
 * @version: V1.0.0
 */
public class UserService {

    public Logger log = Logger.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    /**
     * @param userId
     * @return
     * @description: 通过userId查找一条User信息
     * @author: liutf
     * @date: 2015年3月13日 下午3:07:06
     */
    public User selectUserById(int userId) {
        return userMapper.selectUserById(userId);
    }

    /**
     * @param user
     * @description: 修改用户信息
     * @author: liutf
     * @date: 2015年3月16日 下午1:18:19
     */
    public void updateUserById(User user) {
        userMapper.updateUserById(user);
    }


    /**
     * @param username
     * @param password
     * @return
     * @description: 登陆
     * @author: liutf
     * @date: 2015年8月14日 上午9:40:43
     */
    public User login(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userMapper.login(user);
    }

}
