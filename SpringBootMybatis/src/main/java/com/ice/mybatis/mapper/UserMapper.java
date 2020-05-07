package com.ice.mybatis.mapper;

import com.ice.mybatis.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> getAllUser();
}
