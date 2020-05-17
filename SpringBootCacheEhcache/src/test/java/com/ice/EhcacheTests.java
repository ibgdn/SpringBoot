package com.ice;

import com.ice.bean.User;
import com.ice.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 3.Spring Cache 整合 Ehcache
 */
@SpringBootTest
public class EhcacheTests {
    @Autowired
    UserService userService;

    @Test
    public void getUserById(){
        User userById = userService.getUserById(1);
        User userById2 = userService.getUserById(1);
        System.out.println(userById);
        System.out.println(userById2);
    }
}
