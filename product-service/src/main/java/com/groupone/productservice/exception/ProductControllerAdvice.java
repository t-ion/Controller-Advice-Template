package com.groupone.productservice.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.groupone.productservice.model.ConstraintErrorResponse;
import com.groupone.productservice.model.ErrorMessage;

@RestControllerAdvice
public class ProductControllerAdvice 
{
	@ExceptionHandler(ProductNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorMessage productNotException(ProductNotFoundException productNotFoundException)
	{
		return new ErrorMessage(HttpStatus.NOT_FOUND, LocalDateTime.now(), productNotFoundException.getMessage());
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<?> typeMismatchexception(HttpMessageNotReadableException httpMessageNotReadableException)
	{
		return ResponseEntity.badRequest().body(new ErrorMessage(HttpStatus.BAD_REQUEST, LocalDateTime.now(), 
												"Expected numbers"));
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<?> constraintValidationException(ConstraintViolationException constraintViolationException)
	{
		List<String> errorMessages = new ArrayList<String>();
		for(ConstraintViolation<?> constraintViolation:constraintViolationException.getConstraintViolations()) 
		{
			errorMessages.add(constraintViolation.getPropertyPath()+":"+constraintViolation.getMessage()+
					",Value given by you is "+constraintViolation.getInvalidValue());
		}
		return ResponseEntity.badRequest().body(new ConstraintErrorResponse(HttpStatus.BAD_REQUEST,LocalDateTime.now()
																			,errorMessages));
		
	}
	
	@ExceptionHandler(NumberFormatException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<?> methodArgumentMismatchException(NumberFormatException numberFormatException)
	{
		return ResponseEntity.badRequest().body(new ErrorMessage(HttpStatus.BAD_REQUEST, LocalDateTime.now()
				, "Product id must be number"));
	}
}