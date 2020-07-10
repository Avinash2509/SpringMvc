package com.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mvc.entity.User;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"com.mvc"})
public class AppConfig {

	@Autowired
 ApplicationContext  context;

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		System.out.println(1111111);
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
		factoryBean.setAnnotatedClasses(User.class);
		return factoryBean;

}
}