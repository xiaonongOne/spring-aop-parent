 package com.aop.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.service.DemoMethodService;

public class App 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);
        demoMethodService.add();  
        context.close();
    }
}
