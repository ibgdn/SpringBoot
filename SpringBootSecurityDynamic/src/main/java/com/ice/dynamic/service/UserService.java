package com.ice.dynamic.service;

import com.ice.dynamic.bean.User;
import com.ice.dynamic.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 12.动态配置权限
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        user.setRoleList(userMapper.getRolesByUserId(user.getId()));
        return user;
    }
}
