package com.iwhalecloud.offer.controller.redis;

import com.iwhalecloud.offer.entity.User;
import com.iwhalecloud.offer.manager.UserManager;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Api(value = "redis集群测试接口")
@RestController
@RequestMapping("/spring/session")
@Slf4j
public class SpringSessionController {

    @Autowired
    private UserManager userManager;


    @GetMapping("/user/{userId}")
    public User qryUser(@PathVariable String userId, HttpSession session) {
        User user = userManager.getUserById(userId);
        session.setAttribute("userInfo", user);
        return (User) session.getAttribute("userInfo");
    }
}
