package com.securityjwtdemo.common;

public enum  JsonResponseStatus {

    SUCCESS(1000,"操作成功")

	,TokenFail(2001,"Token 过期")

	,FAILURE(2000,"操作失败")

	,LoginError(2021,"验证登录失败")

	,NoRight(2013,"没有权限")


	,BusinessError(2100,"业务异常")

	,BlankParamsError(2101,"空参数")

	,ParamsFormatError(2102,"参数格式错误")

	,SystemError(2200,"系统错误");

    private int code;

    private String Message;

    private JsonResponseStatus(int code, String message) {
        this.code=code;
        this.Message=message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
