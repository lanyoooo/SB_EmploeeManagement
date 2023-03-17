package com.lanyo.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //对于除了首页的任何页面，都要先检查是不是登录了
        //登陆成功以后，应该有用户的session
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser==null){//没有登录
            request.setAttribute("msg","没有权限，请先登录");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }
        else{
            return true;
        }
        //return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
