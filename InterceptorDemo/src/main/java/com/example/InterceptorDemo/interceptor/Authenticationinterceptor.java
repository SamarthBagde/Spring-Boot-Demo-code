package com.example.InterceptorDemo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class Authenticationinterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler)
    {
        String apiKey = request.getHeader("x-api-key");

        if(apiKey != null && !apiKey.equals("1234")){
            System.out.println("Request rejected, No api key found");
            return false; // return request if api key is not correct
        }

        return true;
    }
}
