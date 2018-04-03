package com.lambo.handle;


import com.lambo.domain.Result;
import com.lambo.exception.StudentException;
import com.lambo.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Allen Walker on 2017/9/3.
 */
@ControllerAdvice
public class ExceptionHandle {
    private Logger logger= LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof StudentException){
            StudentException studentException=(StudentException) e;
            logger.error("error:{}",studentException.getMessage());
            return ResultUtil.error(studentException.getCode(),studentException.getMessage());
        }else{
            logger.error("error:{}",e.getMessage());
            return ResultUtil.error(100,e.getMessage());
        }

    }
}
