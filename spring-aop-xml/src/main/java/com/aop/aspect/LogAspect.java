package com.aop.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;


public class LogAspect {
    
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("before方法规则式拦截，" + method.getName());
    }
    
    public void after(JoinPoint joinPoint) {
    	MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("after方法规则式拦截，" + method.getName());
    }
    
    public void around(JoinPoint joinPoint) {
    	MethodSignature signature = (MethodSignature)joinPoint.getSignature();
    	Method method = signature.getMethod();
    	System.out.println("方法规则式拦截，" + method.getName());
    }
  
}
