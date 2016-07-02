package com.johnny;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication
public class BasicWebAppApplication {

	@Bean
	EmbeddedServletContainerCustomizer containerCustomizer () {
		return container -> {
			container.addErrorPages(new ErrorPage( HttpStatus.NOT_FOUND, "/notFound.html" ));
		};
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BasicWebAppApplication.class, args);
	}
}
