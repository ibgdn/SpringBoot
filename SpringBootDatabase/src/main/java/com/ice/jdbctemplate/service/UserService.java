package com.ice.jdbctemplate.service;

import com.ice.jdbctemplate.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 2.Spring Boot 整合 JdbcTemplate
 */
@Service
public class UserService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 新增用户信息
     *
     * @param user 用户信息
     * @return
     */
    public Integer addUser(User user) {
        return jdbcTemplate.update("insert into user (username, address) value (?, ?)", user.getUserName(), user.getAddress());
    }

    /**
     * 修改用户信息
     *
     * @param user 用户信息
     * @return
     */
    public Integer updateUserById(User user) {
        return jdbcTemplate.update("update user set username = ? where id = ?", user.getUserName(), user.getId());
    }

    /**
     * 删除用户信息
     *
     * @param user 用户信息
     * @return
     */
    public Integer deleteUserById(User user) {
        return jdbcTemplate.update("delete from user where id = ?", user.getId());
    }


    /**
     * 查询用户信息（繁琐写法）
     *
     * @return
     */
    public List<User> getAllUsers() {
        return jdbcTemplate.query("select * from user", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                int id = Integer.parseInt(rs.getString("id"));
                String username = rs.getString("username");
                String address = rs.getString("address");
                user.setId(id);
                user.setUserName(username);
                user.setAddress(address);
                return user;
            }
        });
    }

    /**
     * 查询用户信息（简单写法）
     *
     * @return
     */
    public List<User> getAllUsersSimple() {
        return jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<>(User.class));
    }
}
