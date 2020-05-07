package com.ice;

import com.ice.jdbctemplate.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import com.ice.jdbctemplate.service.UserService;

@SpringBootTest
class JdbcTemplateOneDataSource {
    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        User user = new User();
        user.setUserName("spring");
        user.setAddress("boot");
        userService.addUser(user);
    }

    @Test
    void update() {
        User user = new User();
        user.setId(2);
        user.setUserName("spring1");
        userService.updateUserById(user);
    }

    @Test
    void delete() {
        User user = new User();
        user.setId(2);
        userService.deleteUserById(user);
    }

    @Test
    void select() {
        List<User> allUsers = userService.getAllUsers();
        System.out.println(allUsers);
    }

    @Test
    void selectSimple() {
        List<User> allUsers = userService.getAllUsersSimple();
        System.out.println(allUsers);
    }
}
