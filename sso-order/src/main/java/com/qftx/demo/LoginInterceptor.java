package com.qftx.demo;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getRequestURI());
        System.out.println(request.getRequestURL());
        HttpSession session = request.getSession(false);
        if(session == null||session.getAttribute("login")==null || StringUtils.isEmpty(session.getAttribute("login"))){
            String token = request.getParameter("token");
            if(StringUtils.isEmpty(token)){
                response.sendRedirect("http://www.login.com/login?from=www.order.com");
                System.out.println("Interceptor false");
                return false;
            }else{
                session = request.getSession(true);
                session.setAttribute("login",token);
                System.out.println("Interceptor true");
                return true;
            }
        }else{
            System.out.println("Interceptor true");
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
