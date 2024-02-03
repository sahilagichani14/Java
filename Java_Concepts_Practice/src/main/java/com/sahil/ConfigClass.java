package com.sahil;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.sahil")
@PropertySource("classpath:prop.properties")
public class ConfigClass {
	
//	@Bean
//  @Lazy //if we want instance to be created when getBean called not when ioc container created
//	@Scope(scopeName = "singleton")
//	public Bike bikeBean() {
//		return new Bike();
//	}
	
}
