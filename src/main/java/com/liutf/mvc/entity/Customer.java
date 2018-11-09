package com.liutf.mvc.entity;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.customer_id
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private Integer customerId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.idcard
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private Integer idcard;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.mobile
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private String mobile;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.password
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private String password;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.creation_time
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private Date creationTime;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.last_login_time
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private Date lastLoginTime;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.nickname
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private String nickname;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.gender
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private Integer gender;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.birthday
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private Date birthday;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.avatar_url
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private String avatarUrl;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.add_v
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private Integer addV;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.enable
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private Integer enable;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.addreson
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private String addreson;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.addtime
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private Date addtime;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.cancelreson
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private String cancelreson;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.canceltime
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private Date canceltime;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.adduser_id
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private Integer adduserId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.canceluser_id
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private Integer canceluserId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.safemobile
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private Long safemobile;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.virtualpwd
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private String virtualpwd;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.userrole
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private Integer userrole;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.email
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private String email;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.platform
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private String platform;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.channel
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private String channel;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.uuid
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private String uuid;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.openid
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private String openid;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.oauthplat
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private String oauthplat;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.src
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private Integer src;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.corpcode
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private String corpcode;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.join_time
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private Date joinTime;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.wechat_unionid
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private String wechatUnionid;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.qq_openid
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private String qqOpenid;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.wechat_nickname
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private String wechatNickname;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.qq_nickname
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private String qqNickname;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.profession
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private Integer profession;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.education
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private Byte education;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.monthly_income
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private Byte monthlyIncome;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.is_been_observed
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private Byte isBeenObserved;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.is_limited
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private Byte isLimited;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.level_id
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private Integer levelId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.channel_type
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private Byte channelType;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer.channel_code
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	private String channelCode;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.customer_id
	 * @return  the value of customer.customer_id
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public Integer getCustomerId() {
		return customerId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.customer_id
	 * @param customerId  the value for customer.customer_id
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.idcard
	 * @return  the value of customer.idcard
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public Integer getIdcard() {
		return idcard;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.idcard
	 * @param idcard  the value for customer.idcard
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setIdcard(Integer idcard) {
		this.idcard = idcard;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.mobile
	 * @return  the value of customer.mobile
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.mobile
	 * @param mobile  the value for customer.mobile
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.password
	 * @return  the value of customer.password
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.password
	 * @param password  the value for customer.password
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.creation_time
	 * @return  the value of customer.creation_time
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.creation_time
	 * @param creationTime  the value for customer.creation_time
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.last_login_time
	 * @return  the value of customer.last_login_time
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.last_login_time
	 * @param lastLoginTime  the value for customer.last_login_time
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.nickname
	 * @return  the value of customer.nickname
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.nickname
	 * @param nickname  the value for customer.nickname
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.gender
	 * @return  the value of customer.gender
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public Integer getGender() {
		return gender;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.gender
	 * @param gender  the value for customer.gender
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setGender(Integer gender) {
		this.gender = gender;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.birthday
	 * @return  the value of customer.birthday
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.birthday
	 * @param birthday  the value for customer.birthday
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.avatar_url
	 * @return  the value of customer.avatar_url
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public String getAvatarUrl() {
		return avatarUrl;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.avatar_url
	 * @param avatarUrl  the value for customer.avatar_url
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.add_v
	 * @return  the value of customer.add_v
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public Integer getAddV() {
		return addV;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.add_v
	 * @param addV  the value for customer.add_v
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setAddV(Integer addV) {
		this.addV = addV;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.enable
	 * @return  the value of customer.enable
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public Integer getEnable() {
		return enable;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.enable
	 * @param enable  the value for customer.enable
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.addreson
	 * @return  the value of customer.addreson
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public String getAddreson() {
		return addreson;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.addreson
	 * @param addreson  the value for customer.addreson
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setAddreson(String addreson) {
		this.addreson = addreson;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.addtime
	 * @return  the value of customer.addtime
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public Date getAddtime() {
		return addtime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.addtime
	 * @param addtime  the value for customer.addtime
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.cancelreson
	 * @return  the value of customer.cancelreson
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public String getCancelreson() {
		return cancelreson;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.cancelreson
	 * @param cancelreson  the value for customer.cancelreson
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setCancelreson(String cancelreson) {
		this.cancelreson = cancelreson;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.canceltime
	 * @return  the value of customer.canceltime
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public Date getCanceltime() {
		return canceltime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.canceltime
	 * @param canceltime  the value for customer.canceltime
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setCanceltime(Date canceltime) {
		this.canceltime = canceltime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.adduser_id
	 * @return  the value of customer.adduser_id
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public Integer getAdduserId() {
		return adduserId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.adduser_id
	 * @param adduserId  the value for customer.adduser_id
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setAdduserId(Integer adduserId) {
		this.adduserId = adduserId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.canceluser_id
	 * @return  the value of customer.canceluser_id
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public Integer getCanceluserId() {
		return canceluserId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.canceluser_id
	 * @param canceluserId  the value for customer.canceluser_id
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setCanceluserId(Integer canceluserId) {
		this.canceluserId = canceluserId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.safemobile
	 * @return  the value of customer.safemobile
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public Long getSafemobile() {
		return safemobile;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.safemobile
	 * @param safemobile  the value for customer.safemobile
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setSafemobile(Long safemobile) {
		this.safemobile = safemobile;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.virtualpwd
	 * @return  the value of customer.virtualpwd
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public String getVirtualpwd() {
		return virtualpwd;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.virtualpwd
	 * @param virtualpwd  the value for customer.virtualpwd
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setVirtualpwd(String virtualpwd) {
		this.virtualpwd = virtualpwd;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.userrole
	 * @return  the value of customer.userrole
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public Integer getUserrole() {
		return userrole;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.userrole
	 * @param userrole  the value for customer.userrole
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setUserrole(Integer userrole) {
		this.userrole = userrole;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.email
	 * @return  the value of customer.email
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.email
	 * @param email  the value for customer.email
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.platform
	 * @return  the value of customer.platform
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public String getPlatform() {
		return platform;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.platform
	 * @param platform  the value for customer.platform
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.channel
	 * @return  the value of customer.channel
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public String getChannel() {
		return channel;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.channel
	 * @param channel  the value for customer.channel
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.uuid
	 * @return  the value of customer.uuid
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.uuid
	 * @param uuid  the value for customer.uuid
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.openid
	 * @return  the value of customer.openid
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.openid
	 * @param openid  the value for customer.openid
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.oauthplat
	 * @return  the value of customer.oauthplat
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public String getOauthplat() {
		return oauthplat;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.oauthplat
	 * @param oauthplat  the value for customer.oauthplat
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setOauthplat(String oauthplat) {
		this.oauthplat = oauthplat;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.src
	 * @return  the value of customer.src
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public Integer getSrc() {
		return src;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.src
	 * @param src  the value for customer.src
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setSrc(Integer src) {
		this.src = src;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.corpcode
	 * @return  the value of customer.corpcode
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public String getCorpcode() {
		return corpcode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.corpcode
	 * @param corpcode  the value for customer.corpcode
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setCorpcode(String corpcode) {
		this.corpcode = corpcode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.join_time
	 * @return  the value of customer.join_time
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public Date getJoinTime() {
		return joinTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.join_time
	 * @param joinTime  the value for customer.join_time
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.wechat_unionid
	 * @return  the value of customer.wechat_unionid
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public String getWechatUnionid() {
		return wechatUnionid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.wechat_unionid
	 * @param wechatUnionid  the value for customer.wechat_unionid
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setWechatUnionid(String wechatUnionid) {
		this.wechatUnionid = wechatUnionid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.qq_openid
	 * @return  the value of customer.qq_openid
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public String getQqOpenid() {
		return qqOpenid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.qq_openid
	 * @param qqOpenid  the value for customer.qq_openid
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setQqOpenid(String qqOpenid) {
		this.qqOpenid = qqOpenid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.wechat_nickname
	 * @return  the value of customer.wechat_nickname
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public String getWechatNickname() {
		return wechatNickname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.wechat_nickname
	 * @param wechatNickname  the value for customer.wechat_nickname
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setWechatNickname(String wechatNickname) {
		this.wechatNickname = wechatNickname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.qq_nickname
	 * @return  the value of customer.qq_nickname
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public String getQqNickname() {
		return qqNickname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.qq_nickname
	 * @param qqNickname  the value for customer.qq_nickname
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setQqNickname(String qqNickname) {
		this.qqNickname = qqNickname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.profession
	 * @return  the value of customer.profession
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public Integer getProfession() {
		return profession;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.profession
	 * @param profession  the value for customer.profession
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setProfession(Integer profession) {
		this.profession = profession;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.education
	 * @return  the value of customer.education
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public Byte getEducation() {
		return education;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.education
	 * @param education  the value for customer.education
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setEducation(Byte education) {
		this.education = education;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.monthly_income
	 * @return  the value of customer.monthly_income
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public Byte getMonthlyIncome() {
		return monthlyIncome;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.monthly_income
	 * @param monthlyIncome  the value for customer.monthly_income
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setMonthlyIncome(Byte monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.is_been_observed
	 * @return  the value of customer.is_been_observed
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public Byte getIsBeenObserved() {
		return isBeenObserved;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.is_been_observed
	 * @param isBeenObserved  the value for customer.is_been_observed
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setIsBeenObserved(Byte isBeenObserved) {
		this.isBeenObserved = isBeenObserved;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.is_limited
	 * @return  the value of customer.is_limited
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public Byte getIsLimited() {
		return isLimited;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.is_limited
	 * @param isLimited  the value for customer.is_limited
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setIsLimited(Byte isLimited) {
		this.isLimited = isLimited;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.level_id
	 * @return  the value of customer.level_id
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public Integer getLevelId() {
		return levelId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.level_id
	 * @param levelId  the value for customer.level_id
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.channel_type
	 * @return  the value of customer.channel_type
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public Byte getChannelType() {
		return channelType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.channel_type
	 * @param channelType  the value for customer.channel_type
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setChannelType(Byte channelType) {
		this.channelType = channelType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer.channel_code
	 * @return  the value of customer.channel_code
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public String getChannelCode() {
		return channelCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer.channel_code
	 * @param channelCode  the value for customer.channel_code
	 * @mbggenerated  Mon Nov 13 14:41:23 CST 2017
	 */
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

}