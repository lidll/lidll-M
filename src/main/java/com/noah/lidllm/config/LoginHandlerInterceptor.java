package com.noah.lidllm.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginHandlerInterceptor
 * @Description TODO
 * @Author noah
 * @Date 4/27/21 2:32 PM
 * @Version 1.0
 **/
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录成功之后,应该有用户session
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser == null) {
            request.setAttribute("msg","没有权限,不能登录");
            request.getRequestDispatcher("/index.html").forward(request,response);
//            response.sendRedirect("/index.html");
            return false;
        }else{
            return true;
        }
    }
}
