/**
 * Copyright (C) 2014 	北京方正阿帕比技术有限公司	开发一部
 * 
 *	时间日期工具
 * 
 * 2014年7月9日
 * 
 * Li xiaolei (xl.li@founder.com) 
 */
package com.liutf.mvc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: DateTimeUtils
 * @Description: TODO
 * @author: xg.zhang
 * @date:2015年1月22日 下午1:49:37
 */
/** 
 * @description: TODO
 * @author: liutf
 * @date: 2015年3月3日 下午5:42:23 
 * @version: V1.0.0
 */

/**
 * @description: TODO
 * @author: liutf
 * @date: 2015年3月3日 下午5:42:26
 * @version: V1.0.0
 */
public class DateTimeUtils {
	/** 完整年月日时间格式 **/
	public static final String DATE_TIME_FULL_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/** 短年月日格式，无中间符号 **/
	public static final String DATE_TIME_SHORT_FORMAT = "yyyyMMdd";

	/** 短年月日格式，有中间符号 **/
	public static final String DATE_TIME_SHORT_RORMAT2 = "yyyy-MM-dd";

	/**
	 * @Title: getDateTime2DigitLibrarySignFormat
	 * @Description: 系统日期工具 格式 yyyyMMdd
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String getDateTime2DigitLibrarySignFormat() {
		return getDateTime(DATE_TIME_SHORT_FORMAT);
	}

	/**
	 * 格式化日期
	 * 
	 * @param format
	 * @return
	 */
	public static String getDateTime() {
		// 当前时间与1970-1-1号时间差，单位毫秒
		long time = System.currentTimeMillis();
		// 格式化为yyyy-MM-dd HH:mm:ss格式
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FULL_FORMAT);
		Date date = new Date(time);
		return sdf.format(date);
	}

	/**
	 * 格式化日期
	 * 
	 * @param format
	 * @return
	 */
	public static String getDateTime(String format) {
		// 当前时间与1970-1-1号时间差，单位毫秒
		long time = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = new Date(time);
		return sdf.format(date);
	}

	/**
	 * @Title: getDateTime
	 * @Description: 获取系统时间
	 * @param @param format
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static Date getDate(String format) {
		// 当前时间与1970-1-1号时间差，单位毫秒
		long time = System.currentTimeMillis();
		// SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = new Date(time);
		return date;
	}

	/**
	 * @description: 字符串转换为日期格式（支持长日期格式，短日期格式，Long日期格式）
	 * @param strDate
	 * @return
	 * @throws ParseException
	 * @author: liutf
	 * @date: 2015年3月3日 下午5:42:29
	 */
	public static Date string2Date(String strDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FULL_FORMAT);
		SimpleDateFormat sdf2 = new SimpleDateFormat(DATE_TIME_SHORT_RORMAT2);
		Date rtDate = null;
		if (strDate != null && strDate.length() > 0) {
			if (strDate.length() == 10) {
				rtDate = sdf2.parse(strDate);
			} else if (strDate.length() == 19) {
				rtDate = sdf.parse(strDate);
			} else if (strDate.length() == 13) {
				rtDate = new Date(Long.parseLong(strDate));
			}
		}
		return rtDate;
	}

	public static void main(String[] args) throws ParseException {
		String strDate = "1426212040000";
		try {
			Date d = DateTimeUtils.string2Date(strDate);
			System.out.println(d.toString());
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FULL_FORMAT);
			String s = sdf.format(d);
			System.out.println(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}