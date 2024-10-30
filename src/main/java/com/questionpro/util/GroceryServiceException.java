package com.questionpro.util;

import org.springframework.http.HttpStatus;

public class GroceryServiceException extends RuntimeException {
   private static final long serialVersionUID = -5061178156395691194L;
   private String message;
   private HttpStatus httpStatus;

   public GroceryServiceException(String message) {
      super(message);
   }

   public GroceryServiceException(String message, HttpStatus httpStatus) {
      this.message = message;
      this.httpStatus = httpStatus;
   }

   public String getMessage() {
      return this.message;
   }

   public void setMessage(String message) {
      this.message = message;
   }

   public HttpStatus getHttpStatus() {
      return this.httpStatus;
   }

   public void setHttpStatus(HttpStatus httpStatus) {
      this.httpStatus = httpStatus;
   }
}
