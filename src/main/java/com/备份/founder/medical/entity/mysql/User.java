package com.founder.medical.entity.mysql;

import com.founder.medical.utils.Page;

/**
 * @ClassName: User
 * @Description: TODO
 * @author: liutf
 * @date:2015年1月20日 上午11:10:12
 */
public class User extends Page {

	private Integer id;
	private String username;
	private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
