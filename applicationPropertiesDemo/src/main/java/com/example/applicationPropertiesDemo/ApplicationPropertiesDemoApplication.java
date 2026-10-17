package com.example.applicationPropertiesDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ApplicationPropertiesDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(ApplicationPropertiesDemoApplication.class, args);

//		UsingValue obj = context.getBean(UsingValue.class);
//
//		System.out.println(obj.getType());
//		System.out.println(obj.getRetryCount());


		UsingConfigurationProperties obj2 = context.getBean(UsingConfigurationProperties.class);

		obj2.printInfo();
	}

}
