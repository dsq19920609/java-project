package com.iwhalecloud.offer.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  通过配置的方式 注册filter
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        /** 多个可以配置多个 通过order 配置filter的执行顺序 */
        FilterRegistrationBean filterBean = new FilterRegistrationBean();
        filterBean.setFilter(new MyFilter());
        filterBean.addUrlPatterns("/*");
        filterBean.setName("MyFilter");
        filterBean.setOrder(2);
        return filterBean;
    }

}
