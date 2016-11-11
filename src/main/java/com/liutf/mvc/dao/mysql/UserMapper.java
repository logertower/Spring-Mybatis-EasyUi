package com.liutf.mvc.dao.mysql;


import com.liutf.mvc.entity.mysql.User;

public interface UserMapper {

	/**
	 * @description: 通过userId查找一条User信息
	 * @param userId
	 * @return
	 * @author: liutf
	 * @date: 2015年3月13日 下午3:07:06
	 */
	public User selectUserById(int userId);

	/**
	 * @description: 修改用户信息
	 * @param user
	 * @author: liutf
	 * @date: 2015年3月16日 下午1:18:19
	 */
	public void updateUserById(User user);

	/**
	 * @description: 登陆
	 * @param user
	 * @author: liutf
	 * @date: 2015年8月14日 上午9:40:43
	 */
	public User login(User user);

}
