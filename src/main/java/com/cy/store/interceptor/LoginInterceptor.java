package com.cy.store.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 访问前需要先登录
 */


public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 检测全局session对象中是否有uid，如果有则放行，没有重定向到登录页面
     * @param request 请求对象
     * @param response 响应对象
     * @param handler
     * @return 返回true放行请求，false拦截请求
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        Object obj =request.getSession().getAttribute("uid");
        if(obj == null){//如果没登录系统
            response.sendRedirect("/web/login.html");

            return false;
        }
        return true;
    }
}
