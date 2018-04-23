package com.simple.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.simple.app.controller"})
public class MVCConfig {


    @Value("${spring.mvc.view.jsp.prefix:/WEB-INF/jsp}")
    String jspViewPrefix;
    @Value("${spring.mvc.view.jsp.suffix:.jsp}")
    String jspViewPostfix;

    //sets up resolver for jsp
    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix(jspViewPrefix);
        resolver.setSuffix(jspViewPostfix);
        resolver.setViewClass(JstlView.class);
        return resolver;
    }
}
