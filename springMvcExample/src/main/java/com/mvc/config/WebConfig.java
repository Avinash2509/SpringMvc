package com.mvc.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"com.mvc"})
public class WebConfig implements WebMvcConfigurer {
	
	public WebConfig() {
		System.out.println("Inside WebMVCConfig .............................");
	}

	@Bean 
	public InternalResourceViewResolver myresolver() {
		System.out.println("hello in Springinit..in..in.");		

		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/admin/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	 @Override
	   public void addResourceHandlers(ResourceHandlerRegistry registry) {

	      // Register resource handler for CSS  
		
	      registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/")
	            .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	      
	      // Register resource handler for images
	      registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/")
        .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());

}}
