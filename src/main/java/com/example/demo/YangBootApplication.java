package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class YangBootApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(YangBootApplication.class, args);
	    String[] beanNames = ctx.getBeanDefinitionNames();
	    Arrays.sort(beanNames);
	    for (String beanName : beanNames) {
	    	log.info("beans : "+beanName);
	    }
	}

}

