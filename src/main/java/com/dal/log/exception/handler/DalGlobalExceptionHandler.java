package com.dal.log.exception.handler;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class DalGlobalExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(DalGlobalExceptionHandler.class);
	
	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, String> handleExceptions(final Exception exception, final WebRequest request) {
		logger.error("Uknown error occured while downloading the log file");
		
		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("status", "500");
		errorResponse.put("timeStamp", LocalDate.now().toString());
		errorResponse.put("message", "Uknown error occured while downloading the log file");
		errorResponse.put("statusDesc", request.getDescription(false));
		return errorResponse;

	}
}
