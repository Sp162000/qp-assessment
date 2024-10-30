package com.questionpro.controller;

import com.questionpro.util.GroceryServiceException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationControllerAdvice extends ResponseEntityExceptionHandler {
   @ExceptionHandler({GroceryServiceException.class, Exception.class})
   public ResponseEntity<?> handleConflict(RuntimeException exception, WebRequest request) {
      if (exception instanceof GroceryServiceException) {
         GroceryServiceException groceryServiceException = (GroceryServiceException)exception;
         return this.handleExceptionInternal(exception, groceryServiceException.getMessage(), new HttpHeaders(), groceryServiceException.getHttpStatus(), request);
      } else {
         return this.handleExceptionInternal(exception, exception.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
      }
   }
}
