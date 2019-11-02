package com.securityjwtdemo.common;

import java.io.Serializable;

public class JsonResult<T> implements Serializable {

    private static final long serialVersionUID = -6209802555693381640L;

    private Integer code;
    private String message;
    private T data;
    private Integer count;
    private String traceMessage;//日志调用链信息（dubbo的result返回值attachments在调用端取不到，先放这里）

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setSuccess() {
        this.setCode(JsonResponseStatus.SUCCESS.getCode());
        this.setMessage(JsonResponseStatus.SUCCESS.getMessage());
    }

    public void setSuccess(T data) {
        this.setCode(JsonResponseStatus.SUCCESS.getCode());
        this.setMessage(JsonResponseStatus.SUCCESS.getMessage());
        this.setData(data);
    }

    public void setSuccessNoMessage(T data) {
        this.setCode(JsonResponseStatus.SUCCESS.getCode());
        this.setData(data);
    }

    public void setFail(Integer code, String message) {
        this.setCode(code);
        this.setMessage(message);
        this.setData(null);
    }

    public void setFailBusinessError(String messge) {
        this.setCode(JsonResponseStatus.BusinessError.getCode());
        this.setMessage(messge);
        this.setData(null);
    }

    public void setFailLoginError(String messge) {
        this.setCode(JsonResponseStatus.LoginError.getCode());
        this.setMessage(messge);
        this.setData(null);
    }

    public void setFailSystemError(String message) {
        this.setCode(JsonResponseStatus.SystemError.getCode());
        this.setMessage(message);
        this.setData(null);
    }

    public void setFailSystemError() {
        this.setFailSystemError(JsonResponseStatus.SystemError.getMessage());
    }

    public String getTraceMessage() {
        return traceMessage;
    }

    public void setTraceMessage(String traceMessage) {
        this.traceMessage = traceMessage;
    }

    public void setStatus(boolean success, Integer failCode, String failMessage, T data) {
        if (success) {
            this.setCode(JsonResponseStatus.SUCCESS.getCode());
            this.setMessage(JsonResponseStatus.SUCCESS.getMessage());
            this.setData(data);
        } else {
            this.setCode(failCode);
            this.setMessage(failMessage);
            this.setData(data);
        }
    }


}
