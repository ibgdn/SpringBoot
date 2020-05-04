package com.ice.aop.service;

import org.springframework.stereotype.Service;

/**
 * 25.Spring Boot 整合 AOP
 */
@Service
public class AopService {

    public String getById(Integer id) {
        String str = "AopService getById: " + id;
        System.out.println(str);
        return str;
    }

    public void deleteById(Integer id) {
        String str = "AopService deleteById: " + id;
        System.out.println(str);
    }
}
