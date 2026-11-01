package com.example.SpringFilterDemo.filter;

import jakarta.servlet.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@Order(2)
public class DemoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("This is demo filter");


        try {
            chain.doFilter(request, response);
        }finally {
            System.out.println("Returning from DemoFilter");
        }
    }
}
