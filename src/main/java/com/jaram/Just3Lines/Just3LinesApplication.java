package com.jaram.Just3Lines;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Just3LinesApplication {

	public static void main(String[] args) {

//		Dotenv dotenv = Dotenv.load();
//
//		dotenv.entries().forEach(entry ->
//				System.setProperty(entry.getKey(), entry.getValue())
//		);


		SpringApplication.run(Just3LinesApplication.class, args);
	}

}
