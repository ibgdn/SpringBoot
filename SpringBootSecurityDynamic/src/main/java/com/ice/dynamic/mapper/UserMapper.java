package com.ice.dynamic.mapper;

import com.ice.dynamic.bean.Role;
import com.ice.dynamic.bean.User;

import java.util.List;

/**
 * 12.动态配置权限
 */
public interface UserMapper {
    User loadUserByUserName(String username);

    List<Role> getRolesByUserId(Integer id);
}
