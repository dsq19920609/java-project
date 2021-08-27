package com.testdubbo.offer.dubbo.service;

import com.testdubbo.offer.dubbo.model.UserDto;

public interface UserService {

    UserDto qryUserById(String userId);
}
