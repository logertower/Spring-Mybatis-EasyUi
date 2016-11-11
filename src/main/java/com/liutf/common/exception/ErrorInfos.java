package com.liutf.common.exception;

import java.util.Map;

/**
 * 错误信息
 *
 * @author ltf
 * @create 2016-11-04 下午 2:55
 **/
public class ErrorInfos {

    private Map<String, String> errMsgs;

    public String getMsg(String code) {
        return errMsgs.get(code);
    }

    public Map<String, String> getErrMsgs() {
        return errMsgs;
    }

    public void setErrMsgs(Map<String, String> errMsgs) {
        this.errMsgs = errMsgs;
    }
}
