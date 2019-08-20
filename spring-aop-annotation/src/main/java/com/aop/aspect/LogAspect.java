package com.aop.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.aop.annotation.Action;
 
@Aspect
@Component
public class LogAspect {
    @Pointcut("@annotation(com.aop.annotation.Action)")
    public void annotationPointCut() {
        System.out.println("annotationPointCut");
    }
    

    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截" + action.name());
    }
    
    @Before("execution(* com.aop.service.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截，" + method.getName());
    }
    
    
    @Around(value="execution(* com.aop.service.DemoMethodService.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前通知======================");
        Object obj=joinPoint.proceed();//执行目标方法
        System.out.println("环绕后通知======================");
        return obj;
    }
}
