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
import java.util.List;
import java.util.concurrent.TimeUnit;

@Api(value = "redis测试接口")
@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisListController {

    public static final String key = "listKey1";

    public static final String key2 = "listKey2";

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @ApiOperation(value = "redis list测试", notes = "redis list 测试")
    @GetMapping("/list")
    public String listTest() {

        // leftPush(key , value)
        redisTemplate.opsForList().leftPush(key, "test1");
        redisTemplate.opsForList().leftPush(key, "test2");

        // leftPush(key, pivot, value) 将value放在pivot前面，如果pivot存在的话， 如果有多个pivot，则匹配第一个
        redisTemplate.opsForList().leftPush(key, "test1", "dong");

        // leftPop(key)
        String pop1 = redisTemplate.opsForList().leftPop(key);
        log.info("leftPop: " + pop1);

        // leftPop(key, timeout, timeUnit) 从列表移除并返回第一个元素，如果列表中没有元素，会阻塞知道等待超时或者有第一个元素
        String pop2 = redisTemplate.opsForList().leftPop(key, 2000, TimeUnit.SECONDS);
        log.info("leftPop: " + pop2);

        // leftPushAll(key, [])
        String[] stringarrays = new String[]{"1","2","3"};
        redisTemplate.opsForList().leftPushAll(key2, stringarrays);

        // leftPushAll(key, List<?>)
        List<String> list = new ArrayList<>();
        list.add("value1");
        list.add("value2");
        redisTemplate.opsForList().leftPushAll(key2, list);

        // leftPushIfPresent(key, value) 只有当key存在时，才会将value存入列表
        redisTemplate.opsForList().leftPushIfPresent(key2, "exist");

        // rightPop(key)
        String rightElem = redisTemplate.opsForList().rightPop(key2);
        log.info("rightPop : " + rightElem);

        // rightPop(key, timeout, timeUnit) 从右边移除并返回元素，直到超时或者有第一个元素
        String rightPopBold = redisTemplate.opsForList().rightPop(key2, 3000, TimeUnit.SECONDS);

        // rightPush(key, value)
        redisTemplate.opsForList().rightPush(key2, "value1");

        // rightPush(key, pivot, value) 将value放在pivot后面，如果pivot存在的话，多个则匹配第一个
        redisTemplate.opsForList().rightPush(key2, "value1", "dong");

        // rightPushAll(key, [])
        String[] arr = new String[] {"1", "2", "3"};
        redisTemplate.opsForList().rightPushAll(key2, arr);

        // rightPushAll(key, List<?>)
        List<String> list1 = new ArrayList<>();
        list1.add("value1");
        redisTemplate.opsForList().rightPushAll(key2, list1);

        // rightPushIfPresent(key, value) 如果key 存在，则右边push
        redisTemplate.opsForList().rightPushIfPresent(key2, "exist");

        // rightPopAndLeftPush(source key, dest key) 移除列表的最后一个元素，添加到目标列表的左边
        redisTemplate.opsForList().rightPopAndLeftPush(key2, key);

        // rightPopAndLeftPush(source key, dest key, timeout, timeUnit) 阻塞到超时或者有元素
        redisTemplate.opsForList().rightPopAndLeftPush(key2, key, 3000, TimeUnit.SECONDS);

        // index(key, index) 获取指定index的元素
        String elem = redisTemplate.opsForList().index(key2, 2);
        log.info("index 2 : " + elem);

        // size(key) 获取列表长度
        Long len = redisTemplate.opsForList().size(key2);
        log.info("lenght : " + len);

        // range(ley, start, end) 获取start - end之间的值   range(key, 0, -1) 获取所有的元素
        List<String> rangeValues = redisTemplate.opsForList().range(key2, 0, 20);
        log.info("renageValues = [{}]" , rangeValues.toString());

        // set(key, index, value) key中的index位置设置值value
        redisTemplate.opsForList().set(key2, 1, "dong");

        // remove(key, count, object) 从列表中删除等于值的元素的第一个计数事件
        // count > 0  从头-尾     count < 0 从尾-头   count = 0 删除所有等于object的元素
        redisTemplate.opsForList().remove(key2, 1, "dong");

        // 裁剪list trim(key, start, end) 修剪现有列表，使其只包含指定的指定范围的元素，起始和停止都是基于0的索引
        redisTemplate.opsForList().trim(key2, 0 , 12);

        return "success";
    }

}
