package com.bridgelabz.onboarding.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.onboarding.dto.ResponseDTO;

import lombok.extern.slf4j.Slf4j;
@ControllerAdvice
@Slf4j
public class LmsOnboardingExceptionHandler {
	

	private static final String message = "Exception while processing REST Request";
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseDTO> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception)
	{
		log.error("Invaild Date Format",exception);
		ResponseDTO responseDTO = new ResponseDTO(message,"Should have date in the Format dd MMM yyyy");
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception)
	{
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errMessage = errorList.stream().map(objErr -> objErr.getDefaultMessage())
												.collect(Collectors.toList());
		ResponseDTO responseDTO = new ResponseDTO("Exception while Processing REST Request", errMessage);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(LmsOnboardingException.class)
	public ResponseEntity<ResponseDTO> handleMethodException(LmsOnboardingException exception)
	{
		ResponseDTO responseDTO = new ResponseDTO("Exception while Processing REST Request", exception.getMessage());
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
	}

}
