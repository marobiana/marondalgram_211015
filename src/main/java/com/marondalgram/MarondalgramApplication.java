package com.marondalgram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class MarondalgramApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarondalgramApplication.class, args);
	}

}
