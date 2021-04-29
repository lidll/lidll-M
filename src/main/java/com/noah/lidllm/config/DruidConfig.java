package com.noah.lidllm.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @ClassName DruidConfig
 * @Description TODO
 * @Author noah
 * @Date 4/29/21 11:28 AM
 * @Version 1.0
 **/
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDateSrouce(){
        return new DruidDataSource();
    }

    //后台监控 : web.xml ServletRegistrationBean
    //因为SpringBoot 内置了 servlet容器,所以没有web.xml ,替代方法: ServletRegistrationBean
    @Bean
    public ServletRegistrationBean a(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //后台需要有人登录 账号密码配置

        HashMap<String, String> initParams = new HashMap<>();
        initParams.put("loginUsername","admin");//登录key 是固定的 loginUsername loginPassword
        initParams.put("loginPassword","123123");

        //允许谁可以访问
        initParams.put("allow","127.0.0.1");

        //禁止谁能访问
//        initParams.put("xxx","192.168.0.1");

        bean.setInitParameters(initParams);//设置初始化参数
        return bean;
    }

    //filter
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        //过滤请求
        HashMap<String, String> initParams = new HashMap<>();
        //这些东西不计入统计
        initParams.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);
        return bean;
    }

}
