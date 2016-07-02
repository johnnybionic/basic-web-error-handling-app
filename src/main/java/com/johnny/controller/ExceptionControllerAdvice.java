package com.johnny.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception exception, Model model) {
		
		String message = exception.getMessage();
		model.addAttribute("errorMessage", message);
		return "exceptionError";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String illegalArgumentExceptionHandler(IllegalArgumentException exception, Model model) {
		
		String message = exception.getMessage();
		model.addAttribute("errorMessage", message);
		return "exceptionError";
	}

}
