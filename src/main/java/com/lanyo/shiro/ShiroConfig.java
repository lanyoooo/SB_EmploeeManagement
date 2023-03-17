package com.lanyo.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import java.util.LinkedHashMap;

public class ShiroConfig {
    //自定义过滤器
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(securityManager);

        //添加shiro的过滤器，实现拦截功能
        /*
         * anon：无需认证就可以访问的
         * authc:必须认证了的才能访问
         * user:必须拥有 记住我 功能才能用
         * perms:拥有对某个资源的权限才能访问
         * role：拥有某个角色权限才能访问
         * */
        LinkedHashMap<String, String> filterMap = new LinkedHashMap<>();

        filterMap.put("/emps","authc");
        filterMap.put("/emp","authc");
        filterMap.put("/emp/*","authc");
        filterMap.put("/updateEmp","authc");
        filterMap.put("/delete/*","authc");
        filterMap.put("/user/logout","authc");
        filterMap.put("/user/login","anon");

        bean.setFilterChainDefinitionMap(filterMap);
        return bean;
    }

    //自定义安全管理器，要用到自定义的Realm类
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //自定义Realm类
    @Bean(name="userRealm")
    public UserRealm userReaml(){
        return new UserRealm();
    }
}
