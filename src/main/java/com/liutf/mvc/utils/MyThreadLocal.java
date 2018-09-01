package com.liutf.mvc.utils;

/**
 * @author ltf
 * @create 2018-09-02 上午 01:55
 */
public class MyThreadLocal {

    public static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static void set(String value) {
        threadLocal.set(value);
    }

    public static String get() {
        return (String) threadLocal.get();
    }

}
