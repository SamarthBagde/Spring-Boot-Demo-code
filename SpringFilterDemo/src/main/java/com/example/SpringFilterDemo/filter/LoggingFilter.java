package com.example.SpringFilterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)  request;
        HttpServletResponse httpServletResponse = (HttpServletResponse)  response;

        System.out.println("Incoming Request : " + httpServletRequest.getMethod() + " " + httpServletRequest.getRequestURI());

        try {
            chain.doFilter(request, response);
        }finally {
            System.out.println("Response Status : " + httpServletResponse.getStatus());
        }
    }
}
