package com.groupone.displayservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.groupone.displayservice.model.ErrorMessage;

import feign.FeignException;

@RestControllerAdvice
public class DisplayErrorHandler {
	@ExceptionHandler(FeignException.NotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage notFoundException(FeignException.NotFound feignException)
	{
		return new ErrorMessage(HttpStatus.NOT_FOUND,LocalDateTime.now(),"Product not found");
	}
	
	@ExceptionHandler(feign.RetryableException.class)
	@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
	public ErrorMessage serviceUnavailableException() 
	{
		return new ErrorMessage(HttpStatus.SERVICE_UNAVAILABLE, LocalDateTime.now(), "Temporarily service unavailable");
	}
	
	@ExceptionHandler(NumberFormatException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<?> methodArgumentMismatchException(NumberFormatException numberFormatException)
	{
		return ResponseEntity.badRequest().body(new ErrorMessage(HttpStatus.BAD_REQUEST, LocalDateTime.now()
				, "Product id must be number"));
	}
}