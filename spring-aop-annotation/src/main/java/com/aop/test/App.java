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
        DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);
        DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);
        demoAnnotationService.add();//基于注解的拦截
        demoMethodService.add();//给予方法规则的拦截
        context.close();
    }
}
