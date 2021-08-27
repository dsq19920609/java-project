//package com.iwhalecloud.offer.config;
//
//import com.iwhalecloud.offer.interceptor.AuthInterceptor;
//import com.iwhalecloud.offer.interceptor.CommonInterceptor;
//import com.iwhalecloud.offer.interceptor.LoginInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
//public class MvcInterceptorConfig extends WebMvcConfigurerAdapter {
//
//    @Autowired
//    private LoginInterceptor loginInterceptor;
//
//    @Autowired
//    private CommonInterceptor commonInterceptor;
//
//    @Autowired
//    private AuthInterceptor authInterceptor;
//
//    /**
//     * 资源请求拦截
//     * @param registry
//     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/imgs/");
//        super.addResourceHandlers(registry);
//    }
//
//    /**
//     * 视图拦截
//     * @param registry
//     */
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("forward:/index");
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        super.addViewControllers(registry);
//    }
//
//    /**
//     * 接口拦截
//     * @param registry
//     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/offer/name");
//        registry.addInterceptor(authInterceptor).addPathPatterns("/**").excludePathPatterns("/offer/name");
//        registry.addInterceptor(commonInterceptor).addPathPatterns("/**").excludePathPatterns("/offer/name");
//        super.addInterceptors(registry);
//    }
//
//}
