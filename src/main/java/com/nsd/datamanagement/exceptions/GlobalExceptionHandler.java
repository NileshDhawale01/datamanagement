package com.nsd.datamanagement.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nsd.datamanagement.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DataManagementException.class)
	public ResponseEntity<Map<Object, Object>> dataManagementException(DataManagementException exception) {

		ApiResponse apiResponse = new ApiResponse(exception.getMessage(), false);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("response", apiResponse);
		return new ResponseEntity<Map<Object, Object>>(map, HttpStatusCode.valueOf(500));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<Object, Object>> exception(Exception exp) {

		String message = exp.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false);
		Map<Object, Object> map = new HashMap<>();
		map.put("response", apiResponse);
		return new ResponseEntity<>(map, HttpStatusCode.valueOf(500));
	}
}
