package com.iwhalecloud.offer.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 *  过滤器 通过注解的方式实现  需要启动类上添加注解 扫描过滤器
 *  @ServletComponentScan(basePackages = "com.iwhalecloud.offer.filter")
 */
@WebFilter(filterName = "filter1", urlPatterns = "/user", initParams = {@WebInitParam(name ="url", value = "user/detail")})
@Slf4j
public class Filter1 implements Filter {

    private String url;

    /**
     * init 方法 filter初始化的时候调用 filter对象只会创建一次，init方法也只会执行一次。
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.url = filterConfig.getInitParameter("url");
        log.info("filter1 init url: {}", url);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletResponse res = (HttpServletResponse) response
        // 先调用filter 然后调用interceptor 记得一定要调用filterChain.doFilter() 程序才可以继续运行
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("filter1 destroy");
    }
}
