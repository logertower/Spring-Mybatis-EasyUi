package com.liutf.mvc.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONTokener;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: json转换工具类
 * @author: xg.zhang
 * @date: 2015-2-12 上午10:40:37
 * @version: V1.0.0
 */
public class JSONUtil {
	private static Gson gson = null;
	static {
		if (gson == null) {
			gson = new Gson();
		}
	}

	/**
	 * @description: 将json字符串转换成对象
	 * @param json
	 * @return
	 * @author: xg.zhang
	 * @date: 2015-2-12 上午10:40:19
	 */
	public static JSONObject testJson(String json) {
		try {
			JSONTokener jsonParser = new JSONTokener(json);
			JSONObject object = (JSONObject) jsonParser.nextValue();
			return object;
		} catch (JSONException ex) {
			//Log.i("json", "json转换成对象异常");
		}
		return null;
	}

	/**
	 * @description: json集合对象转换list集合
	 * @param str
	 * @param type
	 * @return
	 * @author: xg.zhang
	 * @date: 2015-3-3 上午10:15:36
	 */
	public static <T> List<T> getListFromJSON(String str, Class<T> type) {
		Type listType = new TypeToken<ArrayList<T>>() {
		}.getType();
		List<T> list = new Gson().fromJson(str, listType);
		return list;
	}

	/**
	 * 将json转换成bean对象
	 * 
	 * @param jsonStr
	 * @return
	 */
	public static Object jsonToBean(String jsonStr, Class<?> cl) {
		Object obj = null;
		if (gson != null) {
			obj = gson.fromJson(jsonStr, cl);
		}
		return obj;
	}

	/**
	 * @description: 将集合转成json
	 * @param list
	 * @return
	 * @author: xg.zhang
	 * @date: 2015-3-6 下午1:52:02
	 */
	public static String listToJson(List<?> list) {
		String json = gson.toJson(list);
		return json;
	}

	/**
	 * @description: 将bean转成json
	 * @param obj
	 * @return
	 * @author: xg.zhang
	 * @date: 2015-3-6 下午1:53:02
	 */
	public static String beanToJson(Object obj) {
		String json = gson.toJson(obj);
		return json;
	}

}
