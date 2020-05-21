package com.ice.securitydb.mapper;

import com.ice.securitydb.bean.Role;
import com.ice.securitydb.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 10.基于数据库的认证
 */
@Mapper
public interface UserMapper {

    User loadUserByUsername(String username);

    List<Role> getUserRoleListById(Integer id);
}
