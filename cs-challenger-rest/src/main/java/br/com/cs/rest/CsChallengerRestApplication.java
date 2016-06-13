package br.com.cs.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class CsChallengerRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsChallengerRestApplication.class, args);
	}
}
