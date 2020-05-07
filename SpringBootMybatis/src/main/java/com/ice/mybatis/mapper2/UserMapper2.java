package com.ice.mybatis.mapper2;


import com.ice.mybatis.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 5.Spring Boot 整合 MyBatis 多数据源
 */
@Mapper
public interface UserMapper2 {
    List<User> getAllUser();
}
