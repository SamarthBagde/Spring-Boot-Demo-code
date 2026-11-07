package com.example.InterceptorDemo.config;

import com.example.InterceptorDemo.interceptor.Authenticationinterceptor;
import com.example.InterceptorDemo.interceptor.LoggingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    public LoggingInterceptor loggingInterceptor;
    public Authenticationinterceptor authenticationinterceptor;

    public  WebMVCConfig(LoggingInterceptor loggingInterceptor, Authenticationinterceptor authenticationinterceptor){
        this.loggingInterceptor = loggingInterceptor;
        this.authenticationinterceptor = authenticationinterceptor;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(authenticationinterceptor)
                .addPathPatterns("/api/**")// this interceptor will run only for any request starts with /api/.../...
                .excludePathPatterns("/api/auth/login" , "/api/public/**")// dont run for request start with "/api/auth/login" , "/api/public/**"
                .order(1); // run first


        registry.addInterceptor(loggingInterceptor)
                .order(2); // run second

    }

}
