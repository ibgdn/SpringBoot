package com.ice.service;

import com.ice.bean.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 2.Spring Cache 整合 Redis
 */
@Service
public class UserService {
    // 指定缓存名
    @Cacheable(cacheNames = "cache1")
    public User getUserById(Integer id) {
        System.out.println("getUserById: " + id);
        User user = new User();
        user.setId(id);
        return user;
    }

    @CacheEvict(cacheNames = "cache1")
    public void deleteUserById(Integer id) {
        System.out.println("deleteUserById: " + id);
    }

    @CachePut(cacheNames = "cache1", key = "#user.id")
    public User updateUserById(User user) {
        return user;
    }
}
