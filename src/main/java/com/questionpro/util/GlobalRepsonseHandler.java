package com.questionpro.util;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GlobalRepsonseHandler {
   public static ResponseEntity<?> generateRespone(Object response, String message, HttpStatus httpStatus) {
      Map<String, Object> map = new HashMap<>();
      map.put("response", response);
      map.put("message", message);
      return new ResponseEntity<>(map, httpStatus);
   }

   public static ResponseEntity<?> generateRespone(String message, HttpStatus httpStatus) {
      Map<String, Object> map = new HashMap<>();
      map.put("message", message);
      return new ResponseEntity<>(map, httpStatus);
   }
}
