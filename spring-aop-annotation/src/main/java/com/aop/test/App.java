package com.aop.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.config.AopConfig;
import com.aop.service.DemoAnnotationService;
import com.aop.service.DemoMethodService;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        // 获取自定义注解类
        DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);
        // 获取普通方法类
        DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);
        //基于注解的拦截
        demoAnnotationService.add();
        //给予方法规则的拦截
        demoMethodService.add();
        context.close();
    }
}
