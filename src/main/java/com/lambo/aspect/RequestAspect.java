package com.lambo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Allen Walker on 2017/9/3.
 */
@Aspect
@Component
public class RequestAspect {
    private Logger logger= LoggerFactory.getLogger(RequestAspect.class);
    @Pointcut("execution(public * com.yym.controller.*.*(..))")
    public void log(){}
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes sra=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=sra.getRequest();
        logger.info("url:{}",request.getRequestURL());//url
        logger.info("ip:{}",request.getRemoteHost());//ip

        logger.info("http请求方式method:{}",request.getMethod());//http请求方式
        logger.info("class_method:{}",joinPoint.getSignature()
                .getDeclaringTypeName()+"."+joinPoint.getSignature().getName());//类方法
        logger.info("args:{}",joinPoint.getArgs());//参数
    }
    @After("log()")
    public void doAfter(JoinPoint joinPoint){

    }
    @AfterReturning(pointcut = "log()",returning = "result")
    public void doAfterReturning(Object result){
        logger.info("返回值："+result);
    }
}
