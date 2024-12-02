package com.rapid2food.blog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })

public class Rapid2foodApplication {
	public static void main(String[] args) {
		SpringApplication.run(Rapid2foodApplication.class, args);
		System.out.println("hey i am get connected");
	}
	
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
}







/*
@SpringBootApplication is a class-level annotation in Spring Framework used to mark a class as the starting point of a Spring Boot application. 
It is a combination of three other annotations: @Configuration, @EnableAutoConfiguration, and @ComponentScan.

Here's what each of these annotations does:

@Configuration: Indicates that the class contains one or more bean definitions that should be managed by the Spring container.

@EnableAutoConfiguration: Enables Spring Boot's auto-configuration feature, which automatically configures Spring and third-party libraries based on the dependencies present in the project's classpath.

@ComponentScan: Tells Spring to scan the specified packages for Spring components, such as controllers, services, and repositories.
By combining these three annotations into a single @SpringBootApplication annotation, Spring Boot provides a simplified way to create a new Spring application.
It allows developers to focus on writing business logic and leave the configuration and setup of the application to Spring Boot.
*/