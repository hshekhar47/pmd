package org.hshekhar.pmd.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CORSConfig extends WebMvcConfigurerAdapter
{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .exposedHeaders("Access-Control-Allow-Origin",
                                "Access-Control-Allow-Methods",
                                "Access-Control-Allow-Headers",
                                "Access-Control-Max-Age",
                                "Access-Control-Request-Headers",
                                "Access-Control-Request-Method");
    }
}
