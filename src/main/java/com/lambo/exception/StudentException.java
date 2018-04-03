package com.lambo.exception;


import com.lambo.enums.ResultEnum;

/**
 * Created by Allen Walker on 2017/9/3.
 */
public class StudentException extends RuntimeException{
    private  Integer code;

    public StudentException(Integer code, String msg) {
        super(msg);
        this.code = code;

    }
    public StudentException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();
    }

    public StudentException() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
