package com.ice;

import com.ice.bean.User;
import com.ice.redis.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 2.Spring Cache 整合 Redis
 */
@SpringBootTest
public class CacheRedisTests {
    @Autowired
    UserService userService;

    @Test
    public void getUserByIdTest() {
        User userById = userService.getUserById(1, "name1");
        User userById1 = userService.getUserById(1, "name2");
        System.out.println(userById);
        System.out.println(userById1);
    }

    @Test
    public void deleteUserById() {
        User userById = userService.getUserById(1, "name1");
        userService.deleteUserById(1);
        User userById1 = userService.getUserById(1, "name2");
        System.out.println(userById);
        System.out.println(userById1);
    }

    @Test
    public void updateUserById() {
        User userById = userService.getUserById(1, "name1");
        System.out.println("userById: " + userById);
        User user = new User();
        user.setId(1);
        user.setUserName("周志明");
        user.setAddress("未知");
        User userUpdate = userService.updateUserById(user);
        System.out.println("userUpdate: " + userUpdate);

        User userById1 = userService.getUserById(1, "name2");
        System.out.println("userById1: " + userById1);
    }
}
