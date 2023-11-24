package com.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * ClassName: DemoFilter
 * Description:
 *
 * @Author snuonuo
 * @Create 2023/11/23 11:52
 * @Version 1.0
 */

//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    @Override // 初始化方法，只会被调用一次
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Init");
    }

    @Override // 拦截请求，会被调用多次
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Demo 请求拦截... 放行前逻辑");
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("Demo 请求拦截.. 放行后逻辑");
    }

    @Override // 销毁方法，只会被调用一次
    public void destroy() {
        System.out.println("Destroyed");
    }

}
