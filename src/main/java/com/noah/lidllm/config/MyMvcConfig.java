package com.noah.lidllm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName MyMvcConfig
 * @Description TODO
 * @Author noah
 * @Date 4/26/21 3:05 PM
 * @Version 1.0
 **/
@Configuration
@EnableWebMvc
public class MyMvcConfig implements WebMvcConfigurer {
    /**
     * Add handlers to serve static resources such as images, js, and, css
     * files from specific locations under web application root, the classpath,
     * and others.
     *
     * @param registry
     * @see ResourceHandlerRegistry
     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //用于指定请求的跳转页面
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/main.html").setViewName("main");
        registry.addViewController("/user").setViewName("user");
        registry.addViewController("/dashboard").setViewName("dashboard");
        registry.addViewController("/table").setViewName("table");
        registry.addViewController("/typography").setViewName("typography");
        registry.addViewController("/icons").setViewName("icons");
        registry.addViewController("/maps").setViewName("maps");
        registry.addViewController("/notifications").setViewName("notifications");
    }

    /**
     * Override this method to add resources handlers for serving static resources.
     *
     * @param registry
     * @see ResourceHandlerRegistry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //用于设置静态资源的位置
        registry.addResourceHandler("/**").addResourceLocations("classpath:/resources/");
    }

//    //自定义的国际化组件
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    /**
     * Add Spring MVC lifecycle interceptors for pre- and post-processing of
     * controller method invocations and resource handler requests.
     * Interceptors can be registered to apply to all requests or be limited
     * to a subset of URL patterns.
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","index","/","/user/login","/css/**","/js/**","/fonts/**","/img/**");
    }
}
