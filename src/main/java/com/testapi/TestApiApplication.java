package com.testapi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApiApplication.class, args);
		System.out.println("Hello JDK 19");
	}
	@Bean
    public ModelMapper modelMapper() {
    	return new ModelMapper();
    }
}
