package com.testdubbo.cc.controler;

import com.testdubbo.cc.consumer.UserServiceImpl;
import com.testdubbo.cc.consumer.dto.UserObj;
import com.testdubbo.cc.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/{userId}")
    public UserObj getUserById(@PathVariable String userId) {
        return userService.qryUserById(userId);
    }
}
