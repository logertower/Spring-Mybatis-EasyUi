package com.founder.medical.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.founder.medical.dao.mysql.UserMapper;
import com.founder.medical.entity.mysql.User;

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
	 * @description: 通过userId查找一条User信息
	 * @param userId
	 * @return
	 * @author: liutf
	 * @date: 2015年3月13日 下午3:07:06
	 */
	public User selectUserById(int userId) {
		return userMapper.selectUserById(userId);
	}

	/**
	 * @description: 修改用户信息
	 * @param user
	 * @author: liutf
	 * @date: 2015年3月16日 下午1:18:19
	 */
	public void updateUserById(User user) {
		userMapper.updateUserById(user);
	}

	/**
	 * @description: 登陆
	 * @param user
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
