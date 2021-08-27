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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Api(value = "redis测试接口")
@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisSetController {

    public static final String hashKey1 = "setKey1";

    public static final String hashKey2 = "setKey2";

    public static final String interKeys = "interKeys";

    public static final String unionKeys = "unionKeys";

    public static final String diffKeys = "diffKeys";

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @ApiOperation(value = "set测试", notes = "set测试")
    @GetMapping("/set")
    public String setTest() {
        // add(key, value) 向集合中添加一个或者多个元素
        redisTemplate.opsForSet().add(hashKey1, "key1");
        redisTemplate.opsForSet().add(hashKey1, "key2", "key3");
        String[] strarrays = new String[]{"key4","key5"};
        redisTemplate.opsForSet().add(hashKey1, strarrays);

        redisTemplate.opsForSet().add(hashKey2, "key11");
        redisTemplate.opsForSet().add(hashKey2, "key12", "key13");

        // pop(key) 随机返回集合中的一个元素 并删除
//        String elem =  redisTemplate.opsForSet().pop(hashKey1);
//        log.info("element : " + elem);

        // remove(key, ...vas) 移除一个或者多个元素
        // redisTemplate.opsForSet().remove(hashKey1, "key1", "key2");

        // isMember(key, value)
        redisTemplate.opsForSet().isMember(hashKey1, "key1");

        // members(key) 获取set所有元素
        Set<String> members = redisTemplate.opsForSet().members(hashKey1);
        log.info("members = {}", members);

        // move(sKey, value, destKey) 移动set中的值到目标set
        redisTemplate.opsForSet().move(hashKey1, "key1", hashKey2);

        redisTemplate.opsForSet().add(hashKey1, "key1");

        // size(key) 获取set的长度
        Long len = redisTemplate.opsForSet().size(hashKey1);
        log.info("length = " + len);

        // 交集 intersect(key1, key2) 两个集合的交集
        Set<String> sinter = redisTemplate.opsForSet().intersect(hashKey1, hashKey2);
        log.info("交集 ： sinter = " + sinter );

        // 交集 intersect(key, Collection<?> otherKey)
        List<String> vals = new ArrayList<>();
        vals.add(hashKey2);
        Set<String> sinterList = redisTemplate.opsForSet().intersect(hashKey1, vals);
        log.info("交集 : 集合sinterList = " + sinterList);

        // 交集 -> 存储到另一个集合 intersectAndStore(key1, key2, destKey)
        redisTemplate.opsForSet().intersectAndStore(hashKey1, hashKey2, interKeys);
        log.info("inter store = {}", redisTemplate.opsForSet().members(interKeys));

        // 交集 -> intersectAndStore(key1, Collect<?> otherKeys, destKey)
        redisTemplate.opsForSet().intersectAndStore(hashKey1, vals, interKeys);
        log.info(" inter store collection = {}", redisTemplate.opsForSet().members(interKeys));

        // 并集 union(key1, key2)
        Set<String> sunion = redisTemplate.opsForSet().union(hashKey1, hashKey2);
        log.info("并集： sunion = {}", sunion);

        // 并集 union(key1, Collect<?> otherKeys)
        List<String> unionList = new ArrayList<>();
        unionList.add(hashKey2);
        Set<String> sunionList = redisTemplate.opsForSet().union(hashKey1, unionList);
        log.info("并集： sunionList = {}", sunionList);

        // unionAndStore(key1, key2, destKey)
        redisTemplate.opsForSet().unionAndStore(hashKey1, hashKey2, unionKeys);
        log.info("unionKey = {}", redisTemplate.opsForSet().members(unionKeys));

        // unionAndStore(key1, vals, destKey)
        redisTemplate.opsForSet().unionAndStore(hashKey1, unionList, unionKeys);
        log.info("unionKey = {}", redisTemplate.opsForSet().members(unionKeys));

        // 差集 同上面的交集和并集类似
        // 差集命令：difference(key1, key2)  difference(key1, Collection<?> othersKeys)
        // differenceAndStore(key1, key2, destKey)  differenceAndStore(key, Collection<?> otherKeys, destKey)

        // randomMember(key) 随机获取一个key 和pop不同， 只是获取
        String randomKey = redisTemplate.opsForSet().randomMember(hashKey1);

        // randomMembers(key, count) 随机获取count个key  多个值可能相同
        List<String> randomCounts = redisTemplate.opsForSet().randomMembers(hashKey1, 2);

        // distinctRandomMembers(key, count) 随机获取count个 并将值去重
        Set<String> distinctRandom = redisTemplate.opsForSet().distinctRandomMembers(hashKey1, 3);

        Cursor<String > cursor = redisTemplate.opsForSet().scan(hashKey1, ScanOptions.NONE);

        while (cursor.hasNext()) {
            log.info(cursor.next());
        }
        return  "success";
    }

}
