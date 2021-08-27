package com.testdubbo.offer.controler;

import com.testdubbo.offer.dto.entity.UserDto;
import com.testdubbo.offer.mapper.UserMapper;
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

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable String userId) {
        return userMapper.qryUserById(userId);
    }
}
