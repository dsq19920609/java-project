package com.iwhalecloud.offer.controller.redis;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Api(value = "redis测试接口")
@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisHashController {


    public static final String hashKey1 = "hashKey1";

    public static final String hashKey2 = "hashKey2";

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @ApiOperation(value = "hash测试", notes = "hash测试")
    @GetMapping("/hash")
    public String hashTest() {

        // put(key,hk, vk) 如果hk重复则覆盖值
        redisTemplate.opsForHash().put(hashKey1, "key1", "value5");
        redisTemplate.opsForHash().put(hashKey1, "key2", "value6");

        // putAll(key, Map<?, ?>) 如果hk之前存在，则覆盖
        Map<String, String> map = new HashMap<>();
        map.put("key3", "value3");
        map.put("key4", "value4");
        redisTemplate.opsForHash().putAll(hashKey1, map);

        // putIfAbsent(key, hk, vk) 当hk不存在时，才设置值，避免了覆盖hk值
        redisTemplate.opsForHash().putIfAbsent(hashKey1, "key1", "value1");

        // get(key, hk)
        String key1 = (String) redisTemplate.opsForHash().get(hashKey1, "key1");
        log.info("key1 = " + key1);

        //mutiGet(key, list<?> keys) 获取多个hk的值
        List<Object> keyList = new ArrayList<>();
        keyList.add("key1");
        keyList.add("key2");
        List<Object> values = redisTemplate.opsForHash().multiGet(hashKey1, keyList);
        log.info("values = {}", values);

        // keys(key) 获取所有的hk
        Set<Object> hkList = redisTemplate.opsForHash().keys(hashKey1);
        log.info("keys = {}", hkList);

        // values(key) 获取所有hv
        List<Object> hvList = redisTemplate.opsForHash().values(hashKey1);
        log.info("values = {}", hvList);

        // size() 获取key长度
        Long size = redisTemplate.opsForHash().size(hashKey1);
        log.info("size = " + size);

        // hasKey(key, hk) 存在检查
        boolean exist = redisTemplate.opsForHash().hasKey(hashKey1, "key1");
        log.info("hasKey : " + exist);

        // delete(key, hk) 删除
        redisTemplate.opsForHash().delete(hashKey1, "key1");

        // entries(key) 获取key中所有的键值对
        Map<Object, Object> hkMap = redisTemplate.opsForHash().entries(hashKey1);
        log.info("hkMap all = {}", hkMap);

        // increment(key, hk, value) hk的值增加value
        redisTemplate.opsForHash().put(hashKey1, "age", "12");
        redisTemplate.opsForHash().increment(hashKey1, "age", 1);
        log.info("age = " + redisTemplate.opsForHash().get(hashKey1, "age"));

        // increment(key, hk, value) value 浮点数
        redisTemplate.opsForHash().put(hashKey1, "price", "12.5");
        redisTemplate.opsForHash().increment(hashKey1, "price", 2.6);
        log.info("price = " + redisTemplate.opsForHash().get(hashKey1, "price"));

        // scan(key, ScanOptions options)
        Cursor<Map.Entry<Object, Object>> curosr = redisTemplate.opsForHash().scan(hashKey1, ScanOptions.NONE);
        while (curosr.hasNext()) {
            Map.Entry<Object, Object> entry = curosr.next();
            log.info("key-value: " + entry.getKey() + "-" + entry.getValue());
        }

        return "success";
    }
}
