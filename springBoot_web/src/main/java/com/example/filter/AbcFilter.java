package com.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * ClassName: AbcFilter
 * Description:
 *
 * @Author snuonuo
 * @Create 2023/11/23 12:35
 * @Version 1.0
 */

//@WebFilter(urlPatterns = "/*")
public class AbcFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Abc 请求拦截... 放行前逻辑");
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("Abc 请求拦截.. 放行后逻辑");
    }
}
