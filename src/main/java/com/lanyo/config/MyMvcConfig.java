package com.lanyo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //自定义视图解析器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //什么时候用url，什么时候用视图名字呢
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
        //registry.addViewController("emps").setViewName("emp/list");//本来员工列表无法显示员工信息，但是注册了list这个视图之后就行了
    }

    //将自定义的地区解析器注册为Bean，就可以使用了
    @Bean
    public LocaleResolver localeResolver(){  //方法名需要是小写开头，否则Spring无法接管这个配置
        return new MyLocaleResolver();
    }

    //添加自定义登录拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/user/login","/css/**","/js/**","/img/**");
    }
}
