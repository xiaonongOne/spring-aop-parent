package com.aop.service;

import org.springframework.stereotype.Service;

import com.aop.annotation.Action;

/**
 * 
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  DemoAnnotationService.java   
 * @Package com.aop.service   
 * @Description:    TODO 这个类使用自定义注解
 * @author: Xiao Nong
 * @date:   2019年8月20日 上午9:38:19   
 * @version V1.0 
 * @Copyright: 2019 Inc. All rights reserved.
 */
@Service
public class DemoAnnotationService {
	
    @Action(name = "注解式拦截的add操作")
    public void add() {
        System.out.println("执行到DemoAnnotationService的add方法");
        System.out.println("DemoAnnotationService.add方法结束");
    }
}
