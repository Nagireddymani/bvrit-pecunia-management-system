package com.capg.pbms;

import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PbmsEmployeeManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PbmsEmployeeManagementSystemApplication.class, args);
	}

    @Bean
    public Random getRandom()
    {
    	return new Random();
    }
}
