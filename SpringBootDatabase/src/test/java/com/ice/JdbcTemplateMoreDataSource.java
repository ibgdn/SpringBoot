package com.ice;

import com.ice.jdbctemplate.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class JdbcTemplateMoreDataSource {
    @Autowired
    @Qualifier("jdbcTemplateOne")
    JdbcTemplate jdbcTemplateOne;

    @Autowired
    @Resource(name = "jdbcTemplateTwo")
    JdbcTemplate jdbcTemplateTwo;

    // 多数据源查找
    @Test
    void moreDataSources() {
        List<User> userListOne = jdbcTemplateOne.query("select * from user", new BeanPropertyRowMapper<>(User.class));
        System.out.println(userListOne);

        List<User> userListTwo = jdbcTemplateTwo.query("select * from user", new BeanPropertyRowMapper<>(User.class));
        System.out.println(userListTwo);
    }
}
