package com.example.foodordersystem.interceptor;

import com.example.foodordersystem.pojo.Users;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    /***
     * 在请求处理之前进行调用(Controller方法调用之前)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("执行了拦截器的preHandle方法");
        try {
            HttpSession session = request.getSession();
            //统一拦截（查询当前session是否存在user）(这里user会在每次登录成功后，写入session)
            Users user = (Users) session.getAttribute("user");
            System.out.println(user);
            if (user != null) {
                return true;
            }
//            response.sendRedirect(request.getContextPath() + "login");
            System.out.println(request.getContextPath());
            System.out.println(request.getSession());
            System.out.println(request.getContextPath());
            response.sendRedirect("/static/pages/demo.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
        //如果设置为false时，被请求时，拦截器执行到此处将不会继续操作
        //如果设置为true时，请求将会继续执行后面的操作
    }

}