package com.classbook.filter;

import com.alibaba.fastjson.JSONObject;
import com.classbook.bean.Result;
import com.classbook.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = "/*") //拦截所有请求
public class ClassBookFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("DemoFilter init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截方法执行，拦截到了请求。。。");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURL().toString();
        System.out.println("拦截方法执行，url:" + url);
        if (url.contains("login") || url.contains("register") || url.contains("reset")) {
            //登录、注册请求放行
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        } else {
            //其他请求，校验是否有登录后的令牌
            String jwt = request.getHeader("token");
            if (!StringUtils.hasLength(jwt)) {
                //无令牌
                System.out.println("拦截方法执行，token为空,未登录。");
                responseNotLogin(response);
                return;
            }
            //有令牌
            try {
                JwtUtils.parseJwt(jwt);
            } catch (Exception e) {
                //e.printStackTrace();
                //令牌有问题
                responseNotLogin(response);
                return;
            }
            System.out.println("拦截方法执行，令牌正常,放行请求。");
            //令牌正常,放行请求
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    private void responseNotLogin(HttpServletResponse response) throws IOException {
        Result error = Result.error("NOT_LOGIN");
        String notLogin = JSONObject.toJSONString(error);
        PrintWriter writer = response.getWriter();
        writer.write(notLogin);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        System.out.println("DemoFilter destroy()");
    }
}
