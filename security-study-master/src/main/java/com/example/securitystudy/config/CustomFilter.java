package com.example.securitystudy.config;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * packageName : com.example.securitystudy.config
 * fileName : CustomFilter
 * author : SHW
 * date : 2023-07-05
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2023-07-05   SHW     최초 생성
 */

@Slf4j
@WebFilter(value = "/login/*")
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info(":::필터 인스턴스 초기화:::");
        System.out.println(":::필터 인스턴스 초기화:::");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String requestURI = req.getRequestURI();
        log.info("requestURI ::: {}", requestURI);

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info(":::필터 인스턴스 종료:::");
        Filter.super.destroy();
    }
}
