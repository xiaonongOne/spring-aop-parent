package com.aop.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.aop.annotation.Action;
/**
 * 
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  LogAspect.java   
 * @Package    
 * @Description:    TODO 切面类
 * @author: Xiao Nong
 * @date:   2019年8月20日 上午9:06:20   
 * @version V1.0 
 * @Copyright: 2019 Inc. All rights reserved.
 */
@Aspect
@Component
public class LogAspect {
	
    @Pointcut("@annotation(com.aop.annotation.Action)")
    public void annotationPointCut() {
        System.out.println("annotationPointCut");
    }
    
    /**
     * 
     * 后置通知:
     * 	      在目标方法完成之后调用通知，此时不会关心方法的输出是什么
     *     (此方法使用自定义注解进行配置)
     */
    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("后置通知 —— 方法名称：" + action.name());
    }
    
    /**
     * 返回通知:
     * 	     在目标方法成功执行之后调用通知,调用此拦截会返回方法所返回的值。
     */
     @AfterReturning(value="execution(* com.aop.service.DemoMethodService.*(..))", returning="result")
     public void afterReturning(Object result){
             System.out.println("返回通知 —— 方法名称："+result);
     }
     /**
      * 异常通知:
      * 	在目标方法抛出异常后调用通知
      */
     @AfterThrowing(value="execution(* com.aop.service.DemoMethodService.*(..))" , throwing="e")
     public void find(Throwable e ){
             System.out.println("异常抛出通知======"+e.getMessage());
     }
     
    /**
     * 前置通知:
     * 	      在目标方法被调用之前调用通知功能
     */
    @Before("execution(* com.aop.service.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("前置通知 —— 方法名称：" + method.getName());
    }
    
    /**
     * 环绕通知
     * 	     在被通知的方法调用之前和调用之后执行自定义的行为
     */
    @Around(value="execution(* com.aop.service.DemoMethodService.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前通知=========start=============");
        Object obj=joinPoint.proceed();//执行目标方法
        System.out.println("环绕后通知==========end============");
        return obj;
    }
    
}
