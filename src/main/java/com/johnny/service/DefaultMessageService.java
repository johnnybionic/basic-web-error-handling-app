package com.johnny.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DefaultMessageService implements MessageService {

	@Value("${default.message}")
	private String message;
	
	@Override
	public String getMessage() {
		return message;
	}

}
