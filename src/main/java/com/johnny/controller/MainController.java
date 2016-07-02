package com.johnny.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.johnny.service.MessageService;

@Controller
@RequestMapping("/main")
public class MainController {
	
	private MessageService messageService;

	@Autowired
	public MainController(MessageService service) {
		this.messageService = service;
	}

	@RequestMapping({"/", ""})
	public String home(Model model) {
		model.addAttribute("message", messageService.getMessage());
		return "home";
	}
	
	@RequestMapping({"/message/{message}"})
	public String message(@PathVariable("message") String message,  Model model) throws Exception {
		if (message.equals("error")) {
			throw new IllegalArgumentException("Message is required");
		}
		model.addAttribute("message", "Hello " + message + "!");
		return "home";
	}

	/*
	 * Local method, or use ControllerAdvice. 
	 * 
	 * Adding one here allows for fine-grained control of the error handling. 
	 */
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String handleException(Exception exception, Model model){
		model.addAttribute("errorMessage", "from controller: " + exception.getMessage() );
		return "customError";
	}

}
