package com.lambo.enums;

/**
 * Created by Allen Walker on 2017/9/3.
 */
public enum ResultEnum {
    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(1,"成功"),
    PRIMARY_SCHOOL(101,"你可能还在上小学"),
    MIDDLE_SCHOOL(102,"你可能还在上初中"),
    STUDENT_NOT_EXIST(103,"学生不存在"),
    PARAMETER_ERROR(104,"参数错误"),
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    //get 不需要有set方法
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
