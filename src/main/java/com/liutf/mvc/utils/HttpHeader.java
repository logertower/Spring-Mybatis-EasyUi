/**
 * 
 */
package com.liutf.mvc.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


/**  
 * @ClassName: HttpHeader   
 * @Description: 远程调用时，要添加到http header的信息  
 * @author: xg.zhang  
 * @date:2015年1月22日 下午1:54:25     
 */ 
public class HttpHeader {
	private Map<String, String> headers = new HashMap<String, String>();

	public void add(String name, String value) {
		this.headers.put(name, value);
	}

	public Collection<String> getHeaderNames() {
		return this.headers.keySet();
	}

	public String getValue(String name) {
		return this.headers.get(name);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String hn : this.headers.keySet()) {
			sb.append(hn + ":" + this.headers.get(hn)).append("\n");
		}

		return sb.toString();
	}
}
