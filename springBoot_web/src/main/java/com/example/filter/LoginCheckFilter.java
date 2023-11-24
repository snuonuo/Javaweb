package com.example.filter;

import com.alibaba.fastjson2.JSONObject;
import com.example.pojo.Result;
import com.example.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;


import java.io.IOException;


/**
 * ClassName: LoginCheckFilter
 * Description:
 *
 * @Author snuonuo
 * @Create 2023/11/23 12:44
 * @Version 1.0
 */
@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req =(HttpServletRequest) servletRequest;
        HttpServletResponse res=(HttpServletResponse) servletResponse;
        // 1. 请求URL
        String url = req.getRequestURI().toString();
        log.info("请求的URL为：{}", url);

        // 2. 判断请求的URL是否包含login，如果包含则直接放行
        if(url.contains("login")){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 3. 获取请求头中的令牌token
        String jwt = req.getHeader("token");

        // 4. 检查令牌是否存在，不存在提示未登录
        if(!StringUtils.hasLength(jwt)){
            log.info("令牌为空，返回请求登录信息");
            Result error = Result.error("NOT_LOGIN");
            // 将对象转化为json格式
            String inf = JSONObject.toJSONString(error);
            res.getWriter().write(inf);
            return;
        }

        // 5. 检查是否合法：不合法 -> 拒绝放行输出提示信息
        try {
            JwtUtils.parseJWT(jwt);
        }catch (Exception e){
            e.printStackTrace();
            log.info("解析令牌失败，返回请求登录信息");
            Result error = Result.error("NOT_LOGIN");
            String inf = JSONObject.toJSONString(error);
            res.getWriter().write(inf);
            return;
        };

        // 6. 合法 -> 放行
        log.info("令牌合法，直接放行");
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
