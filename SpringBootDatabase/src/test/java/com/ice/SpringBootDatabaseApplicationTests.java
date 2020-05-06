package com.ice;

import com.ice.jdbctemplate.bean.User;
//import com.ice.jdbctemplate.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringBootDatabaseApplicationTests {
//    @Autowired
//    UserService userService;

    @Autowired
    @Qualifier("jdbcTemplateOne")
    JdbcTemplate jdbcTemplateOne;

    @Autowired
    @Resource(name = "jdbcTemplateTwo")
    JdbcTemplate jdbcTemplateTwo;

    @Test
    void contextLoads() {
        User user = new User();
        user.setUserName("spring");
        user.setAddress("boot");
//        userService.addUser(user);
    }

    @Test
    void update() {
        User user = new User();
        user.setId(1);
        user.setUserName("spring1");
//        userService.updateUserById(user);
    }

    @Test
    void delete() {
        User user = new User();
        user.setId(1);
//        userService.deleteUserById(user);
    }

    @Test
    void select() {
//        List<User> allUsers = userService.getAllUsers();
//        System.out.println(allUsers);
    }

    @Test
    void selectSimple() {
//        List<User> allUsers = userService.getAllUsersSimple();
//        System.out.println(allUsers);
    }

    // 多数据源查找
    @Test
    void moreDataSources() {
        List<User> userListOne = jdbcTemplateOne.query("select * from user", new BeanPropertyRowMapper<>(User.class));
        System.out.println(userListOne);

        List<User> userListTwo = jdbcTemplateTwo.query("select * from user", new BeanPropertyRowMapper<>(User.class));
        System.out.println(userListTwo);
    }
}
