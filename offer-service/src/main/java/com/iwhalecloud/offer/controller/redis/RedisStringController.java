package com.iwhalecloud.offer.controller.redis;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Api(value = "redis测试接口")
@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisStringController {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @ApiOperation(value = "redis测试", notes = "redis测试接口")
    @GetMapping("/create")
    public String create() {

        /**
         *  StringRedisTemplate 继承 RedisTemplate
         *  SDR 默认采用的序列化策略有两种， String的序列化策略  JDK的序列化策略
         *  StringRedisTemplate 默认采用String的序列化策略  RedisTemplate 默认采用JDK序列化策略
         */


        /**
         *  字符串操作
         */
        // set (key value)
        redisTemplate.opsForValue().set("test", "dong");

        // set (key value time  unit) key带过期时间
        redisTemplate.opsForValue().set("testExprice", "testExprice", 3600, TimeUnit.SECONDS);

        // set (key, value, offset)  覆盖key的value值，从字符串的offset位置开始，如果没有则新增 offset之前的为空字符串
        redisTemplate.opsForValue().set("testExprice", "test", 3);

        // getandset(key, value) 获取key的键值， 如果没有返回nil并且创建键值， 如果有key则返回值并且覆盖value
        redisTemplate.opsForValue().getAndSet("testExprice", "testExprice");

        //  multiSet(Map) 通过map 一次设置多个key-value
        Map<String, String> keys = new HashMap<>();
        keys.put("test1", "test1");
        keys.put("test2", "test2");
        keys.put("test3", "test3");
        redisTemplate.opsForValue().multiSet(keys);

        // setifAbset(key, value ) 如果key不存在 则设置值返回true， 如果key存在，什么都不做，返回false
        redisTemplate.opsForValue().setIfAbsent("test4", "dong");

        // multiSetIfAbset（Map） 设置多个值，如果不存在，设置返回true，只有要一个键存在就都不设置值，并且返回false
        Map<String, String> testKeys = new HashMap<>();
        testKeys.put("test1", "test1");
        testKeys.put("test22", "test22");
        System.out.println(redisTemplate.opsForValue().multiSetIfAbsent(testKeys));


        // get(key)
        redisTemplate.opsForValue().get("test1");

        // get(key, start, end)
        redisTemplate.opsForValue().get("test1", 0 ,12);

        // multiGet(List<String> list) 返回List
        List<String> multiKeys = new ArrayList<>();
        multiKeys.add("test1");
        multiKeys.add("test2");
        multiKeys.add("test3");
        List<String> values = redisTemplate.opsForValue().multiGet(multiKeys);
        System.out.println(values.toString());


        // increment(key, long data)
        redisTemplate.opsForValue().set("InterNum", "4");
        redisTemplate.opsForValue().increment("InterNum", 3);
        System.out.println(redisTemplate.opsForValue().get("InterNum"));

        // increment(key, double data)
        redisTemplate.opsForValue().set("FloatNum", "12.45");
        redisTemplate.opsForValue().increment("FloatNum", 10.56);
        System.out.println(redisTemplate.opsForValue().get("FloatNum"));

        // size(key)
        System.out.println(redisTemplate.opsForValue().size("test1"));

        // append(key, value) 如果key存在，将value追加，如果不存在则创建
        redisTemplate.opsForValue().append("test1", "append");
        log.info("append: " + redisTemplate.opsForValue().get("test1"));


        // 序列化策略 String序列化策略
        log.info("info: " + redisTemplate.opsForValue().getOperations().getValueSerializer());


        log.info("ttl: = {}", redisTemplate.getExpire("testExprice"));
        return  "test";
    }
}
