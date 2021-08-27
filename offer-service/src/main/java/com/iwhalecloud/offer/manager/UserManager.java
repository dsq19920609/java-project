package com.iwhalecloud.offer.manager;

import com.alibaba.druid.support.json.JSONUtils;
import com.iwhalecloud.offer.consts.CommonCacheDef;
import com.iwhalecloud.offer.entity.User;
import com.iwhalecloud.offer.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class UserManager {


    @Value("${ftf.filePath}")
    private String path;

    @Autowired
    private UserMapper userMapper;


    public User getUserById(String userId) {
        System.out.println("请求接口调用");
        User user = userMapper.getUserById(userId);
        // 查询hashmap
        HashMap<String, Object> result = userMapper.getHashMap(userId);
        return user;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public User addUser(User user) {
        log.info("UserManager addUser start user = [{}]", user);
        userMapper.insertUser(user);
        insertUser(user);
        log.info("UserManager addUser end");
        return  user;
    }

    public User insertUser(User user) {
        log.info("UserManager addUser start user = [{}]", user);
        user.setUserId(user.getUserId() + 1);
        userMapper.insertUser(user);
        if ( 1 == 1) {
            throw new RuntimeException("异常");
        }
        log.info("UserManager addUser end");
        return  user;
    }

    public User getUserFromCache(String userId) {
        log.info("getUserFromCache---------------");

        return null;
    }
}
