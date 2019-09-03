package com.example.web.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MySpringBootConfig implements WebMvcConfigurer {
    private final
    config config;

    public MySpringBootConfig(config config) {
        this.config = config;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(config).addPathPatterns("/html/**");
    }
}
