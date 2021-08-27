package com.iwhalecloud.offer.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class OrderListJob {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     *  spring 定时任务job
     *  @Scheduled(fixedRate = 5000)  上次开始执行时间点之后5秒中再执行
     *  @Scheduled(fixedDelay = 5000) 上一次执行完毕时间点之后5秒再执行(执行任务完成任务需要花费时间)
     *  @Scheduled(initialDelay=1000, fixedRate=5000) 第一次延迟1秒后执行，然后按fixedRate的规则每5秒执行一次
     *  @Scheduled(cron=" /5 ") ：通过cron表达式定义规则，什么是cro表达式，自行搜索引擎。
     */
    @Scheduled(fixedDelay = 5000000)
    public void reportCurrentTime() {
        log.info("current time is {}", dateFormat.format(new Date()));
    }

}
