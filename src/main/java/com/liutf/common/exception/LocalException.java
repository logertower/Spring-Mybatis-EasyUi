package com.liutf.common.exception;


/**
 * 系统自定义异常类
 *
 * @author ltf
 * @create 2016-11-04 上午 11:08
 **/
public class LocalException extends Exception {

    private static final long serialVersionUID = -1L;

    private String errorCode;

    /**
     * 含参数构造器
     *
     * @param errorMsg 错误信息
     */
    public LocalException(String errorMsg) {
        super(errorMsg);
    }

    /**
     * 含参数构造器
     *
     * @param errorCode 业务错误码
     */
    public LocalException(String errorCode, String errorMsg) {
        super(errorMsg);
        this.setErrorCode(errorCode);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
