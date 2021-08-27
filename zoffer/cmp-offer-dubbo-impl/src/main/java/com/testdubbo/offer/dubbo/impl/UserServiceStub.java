package com.testdubbo.offer.dubbo.impl;

import com.testdubbo.offer.dubbo.model.UserDto;
import com.testdubbo.offer.dubbo.service.UserService;

public class UserServiceStub implements UserService {

    // 真正的代理对象
    private final UserService userService;

    // 构造函数 传入真正的远程代理对象
    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDto qryUserById(String userId) {
        // 可以在客户端做ThreadLocal 本地缓存，校验参数是否合法，调用失败后伪造容错数据
        try {
            userService.qryUserById(userId);
        }  catch (Exception e) {
            // 做容错
            return  new UserDto();
        }
        return null;
    }
}
