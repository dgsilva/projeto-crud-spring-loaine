package com.loiane.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.loiane.exception.RecordNotFoundException;

@RestControllerAdvice
public class ApplicationControlerAdvice {

	@ExceptionHandler(RecordNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleNotFoundException(RecordNotFoundException ex) {
		return ex.getMessage(); 
	}
}
