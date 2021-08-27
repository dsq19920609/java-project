package com.iwhalecloud.offer.controller.redis;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "redis测试接口")
@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisZsetController {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @ApiOperation(value = "set测试", notes = "set测试")
    @GetMapping("/zset")
    public String zsetTest() {
        return "success";
    }
}
