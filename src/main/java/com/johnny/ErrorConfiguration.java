package com.johnny;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * This can work on its own, without an implementation of ErrorHandler.
 * 
 * See BasicWebAppApplication instead
 *  
 * @author johnny
 *
 */
//@Configuration
public class ErrorConfiguration implements EmbeddedServletContainerCustomizer {

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		//container.addErrorPages(new ErrorPage( HttpStatus.NOT_FOUND, "/notFound.html" ));		
	}

}
