package com.lanyo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(@RequestParam("name") String username,
                        @RequestParam("pass") String password,
                        HttpSession session,
                        Model model){
        System.out.println("收到了来自login页面的请求");//action没有问题
        if(!StringUtils.isEmpty(username) && password.equals("123456")){
            //在session中添加参数，让拦截器知道是不是登录了
            session.setAttribute("loginUser",username);
            //System.out.println("跳转到board页面");
            //可以成功跳转到DashBoard，想要跳转后域名上不带有账号密码，就要重定向，并且重定向的地址要和config中配置的完全一样
            return "redirect:/main.html";
        }
        else{
            model.addAttribute("msg","账号或密码有误");//由于前端写定，错误信息无法正确显示
            //System.out.println("回到index页面");
            return "index";
        }
    }
}
