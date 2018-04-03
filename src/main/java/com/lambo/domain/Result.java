package com.lambo.domain;

/**
 * Created by Allen Walker on 2017/9/3.
 */
public class Result<T> {
    //错误码
    private Integer code;
    //错误信息
    private String msg;
    //具体内容
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
