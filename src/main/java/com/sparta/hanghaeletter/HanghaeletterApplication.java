package com.sparta.hanghaeletter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HanghaeletterApplication {

	public static void main(String[] args) {
		SpringApplication.run(HanghaeletterApplication.class, args);
	}

}
