package com.ice.redis.service;

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
// 将 cacheNames 提取出来，各个方法的 cacheNames 就不需要配置了
@CacheConfig(cacheNames = "cache1")
public class UserService {
    // 指定缓存名，及缓存起作用的字段
    @Cacheable(cacheNames = "cache1", key = "#id")
    // 指定缓存名，及缓存起作用的字段通过配置类指定（类名首字母小写）
//    @Cacheable(cacheNames = "cache1", keyGenerator = "redisKeyGenerator")
    public User getUserById(Integer id, String name) {
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
