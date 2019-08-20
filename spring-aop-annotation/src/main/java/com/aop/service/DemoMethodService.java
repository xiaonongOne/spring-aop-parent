package com.aop.service;

import org.springframework.stereotype.Service;

@Service
public class DemoMethodService {
	
    public void add() {
        System.out.println("DemoMethodService.add()");
        String[] str = {"1"};
        System.out.println(str[5]);
    }
    
}
