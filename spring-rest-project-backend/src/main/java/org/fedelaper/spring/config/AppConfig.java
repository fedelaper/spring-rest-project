package org.fedelaper.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.fedelaper.spring")
public class AppConfig {

	    @Bean
	    public ViewResolver internalResourceViewResolver() {
	        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
	        internalResourceViewResolver.setPrefix("/frontend/");
	        internalResourceViewResolver.setSuffix(".html");
	        return internalResourceViewResolver;
	    }
	
}