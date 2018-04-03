package com.lambo.util;


import com.lambo.domain.Result;

/**
 * Created by Allen Walker on 2017/9/3.
 */
public class ResultUtil {

    public static Result success(Object o){
        Result result=new Result();
        result.setCode(1);
        result.setMsg("成功");
        result.setData(o);
        return  result;
    }
    public static  Result success(){
        return success(null);
    }
    public static Result error(Integer code,String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        return  result;
    }
}
