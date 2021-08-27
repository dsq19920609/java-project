package com.iwhalecloud.offer.util;

import com.iwhalecloud.offer.dto.TestDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:test.properties")
public class PropertyConf {

    /**
     * 下面属性赋值 在Bean初始化时会赋值
     */

    /** 类静态属性通过配置文件注入属性值 */
    private static String properties1;

    private static String properties2;

    @Value("${static.properties1}")
    public void setProperties1(String properties1) {
        PropertyConf.properties1 = properties1;
    }

    @Value("${static.properties2}")
    public void setProperties2(String properties2) {
        PropertyConf.properties2 = properties2;
    }

    @Value("${ftf.name}")
    private String name;

    @Value("${ftf.age}")
    private Long age;

    /** 创建bean，其他地方可以通过@Autowired 注入 */
    @Bean
    public TestDto testDto () {
        TestDto testDto = new TestDto();
        testDto.setName(name);
        testDto.setAge(age);
        return testDto;
    }
}
