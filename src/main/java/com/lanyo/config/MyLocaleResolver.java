package com.lanyo.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {
    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取传过来的语言参数
        String lang = request.getParameter("lang");

        //System.out.println("Debug===>"+lang);

        //如果没有，就用一个默认的语言参数
        Locale aDefault = Locale.getDefault();
        //如果传过来的语言参数不为空
        if (!StringUtils.isEmpty(lang)){
            String[] langSplit = lang.split("_");
            aDefault =  new Locale(langSplit[0],langSplit[1]);
            //System.out.println(aDefault);
        }
        return aDefault;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
