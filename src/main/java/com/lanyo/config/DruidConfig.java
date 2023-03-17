package com.lanyo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DruidConfig {

    //配置Druid的数据源、配置
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //配置后台监控(和资源过滤器)
    //后台监控  相当于一个web.xml 可以配置东西
    //因为SpringBoot内置了servlet容器，所以没有web.xml，替代方法：配置一个
    @Bean
    public ServletRegistrationBean statViewServelt(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");//配置Druid的视图解析器

        //后台需要有人登录，配置的登录的账号密码
        HashMap<String, String> initParameters = new HashMap<>();
        initParameters.put("loginUsername","admin");
        initParameters.put("loginPassword","123456");

        //允许谁可以访问  v为空表示谁都可以
        initParameters.put("allow","");

        //将配置信息以及初始化参数交给bean
        bean.setInitParameters(initParameters);
        return bean;
    }

    //配置一个资源过滤器
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();

        //设置web状态过滤器
        bean.setFilter(new WebStatFilter());

        //通过map记录配置参数
        HashMap<String, String> initParameters =  new HashMap<>();
        //放行静态资源、进入Druid的请求
        initParameters.put("exclusions","*.js,*.css,/Druid/*");

        bean.setInitParameters(initParameters);
        return bean;

    }
}
