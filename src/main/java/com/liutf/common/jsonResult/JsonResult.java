package com.liutf.common.jsonResult;

import java.io.Serializable;

/**
 * controller统返回格式
 *
 * @author ltf
 * @create 2016-11-04 上午 10:54
 **/
public class JsonResult implements Serializable {

    private static final long serialVersionUID = -1L;

    private int success;
    private Object data;
    private ErrorMsg error;


    public JsonResult(int success, Object data) {
        this.success = success;
        this.data = data;
        this.error = null;
    }

    public JsonResult(String code, String message) {
        this.success = 0;
        this.data = null;

        ErrorMsg errorMsg = new ErrorMsg(code, message);
        this.error = errorMsg;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ErrorMsg getError() {
        return error;
    }

    public void setError(ErrorMsg error) {
        this.error = error;
    }
}


class ErrorMsg implements Serializable {

    private static final long serialVersionUID = -1L;

    private String code;
    private String message;

    public ErrorMsg(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
