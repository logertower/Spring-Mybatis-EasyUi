/**     
 * @FileName: SynonymsUtil.java   
 * @Package:com.founder.medical.web.utils   
 * @Description: TODO  
 * @author: xg.zhang    
 * @date:2014年9月10日 下午2:01:18   
 * @version V1.0     
 */
package com.liutf.mvc.utils;

import org.apache.log4j.Logger;

/**
 * @ClassName: SynonymsUtil
 * @Description: TODO
 * @author: xg.zhang
 * @date:2014年9月10日 下午2:01:18
 */
public class SynonymsUtil {
	@SuppressWarnings("unused")
	private Logger log = Logger.getLogger(SynonymsUtil.class);

	// 测试初始化参数
	public static String testValue;

	public static void setTestValue(String testValue) {
		SynonymsUtil.testValue = testValue;
	}

	public void startInitData() {
		// System.out.println("----"+this.testValue+"----");
	}

}
