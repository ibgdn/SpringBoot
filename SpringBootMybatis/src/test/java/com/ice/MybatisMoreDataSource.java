package com.ice;

import com.ice.mybatis.bean.User;
import com.ice.mybatis.mapper1.UserMapper1;
import com.ice.mybatis.mapper2.UserMapper2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 5.Spring Boot 整合 MyBatis 多数据源
 */
@SpringBootTest
public class MybatisMoreDataSource {
    @Autowired(required = false)
    UserMapper1 userMapper1;

    @Autowired(required = false)
    UserMapper2 userMapper2;

    @Test
    void contextLoads() {
        List<User> allUser1 = userMapper1.getAllUser();
        System.out.println("UserMapper1: " + allUser1);

        List<User> allUser2 = userMapper2.getAllUser();
        System.out.println("UserMapper2: " + allUser2);
    }

}
