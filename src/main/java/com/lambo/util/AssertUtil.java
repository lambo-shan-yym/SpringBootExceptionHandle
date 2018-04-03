package com.lambo.util;


import com.lambo.enums.ResultEnum;
import com.lambo.exception.StudentException;

/**
 * Created by Allen Walker on 2018/3/21.
 */
public class AssertUtil {
    public static void notNull(String str){
        if(str==null||str.length()==0)
            throw new StudentException(ResultEnum.UNKNOWN_ERROR);
    }
    public static void isInteger(String str){
        try {
            Integer.parseInt(str);
        }catch (Exception e){
            throw new StudentException(ResultEnum.PARAMETER_ERROR);
        }
    }
    public static void bigThan(Integer num,Integer start){
        if(num<start){
            throw new StudentException(ResultEnum.PARAMETER_ERROR);
        }
    }
    public static void range(Integer num,Integer start,Integer end){
        if(num<start||num>end){
            throw new StudentException(ResultEnum.PARAMETER_ERROR);
        }
    }
    public static void main(String[] args) {
        notNull("");
    }
}
