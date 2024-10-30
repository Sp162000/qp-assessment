package com.questionpro.controller;

import com.questionpro.beans.BookingRequest;
import com.questionpro.beans.UserRequest;
import com.questionpro.service.UserServiceImpl;
import com.questionpro.util.GlobalRepsonseHandler;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
	@Autowired
	private UserServiceImpl userServiceImpl;

	@GetMapping(path = { "v1/user/grocery/fetch" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> index() {
		return GlobalRepsonseHandler.generateRespone(this.userServiceImpl.index(), "Items fetched successfully",
				HttpStatus.OK);
	}

	@PostMapping(path = {
			"v1/user/grocery/create" }, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody List<BookingRequest> requestBean) {
		return GlobalRepsonseHandler.generateRespone(this.userServiceImpl.bookItems(requestBean),
				"bookings added successfully", HttpStatus.CREATED);
	}

	@PostMapping(path = "v1/create/user" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createUser(@RequestBody UserRequest requestBean) {
		return GlobalRepsonseHandler.generateRespone(this.userServiceImpl.createUser(requestBean),
				"user added successfully", HttpStatus.CREATED);
	}
}
