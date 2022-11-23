package com.kirby.lookthis.main.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${jwt.response.header}")
    private String jwtHeader;


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .exposedHeaders(jwtHeader)
                .allowedHeaders("")
                .allowedMethods("PUT", "DELETE", "GET", "POST");
    }
}
