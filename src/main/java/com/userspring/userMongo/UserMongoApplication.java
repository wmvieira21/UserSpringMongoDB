package com.userspring.userMongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("userMongo")
public class UserMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMongoApplication.class, args);
	}

}
