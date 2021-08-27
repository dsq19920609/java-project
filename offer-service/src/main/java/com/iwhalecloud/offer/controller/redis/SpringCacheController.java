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

@Api(value = "redis集群测试接口")
@RestController
@RequestMapping("/spring/cache")
@Slf4j
public class SpringCacheController {

    @Autowired
    private UserManager userManager;

    @GetMapping("/user/detail/{userId}")
    public User qryUser(@PathVariable String userId) {
        return userManager.getUserById(userId);
    }

    @GetMapping("/user/get/{userId}")
    public User getUserFromCache(@PathVariable String userId) {
        return userManager.getUserFromCache(userId);
    }


}
