package com.questionpro.controller;

import com.questionpro.beans.GroceryRequestBean;
import com.questionpro.service.AdminServiceImpl;
import com.questionpro.util.GlobalRepsonseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
	@Autowired
	private AdminServiceImpl adminServiceImpl;

	@PostMapping(path = { "v1/admin/grocery/create" }, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody GroceryRequestBean requestBean) {
		return GlobalRepsonseHandler.generateRespone(this.adminServiceImpl.addItem(requestBean),
				"Items added successfully", HttpStatus.CREATED);
	}

	@GetMapping(path = { "v1/admin/grocery/fetch" },  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> index() {
		return GlobalRepsonseHandler.generateRespone(this.adminServiceImpl.index(), "Items fetched successfully",
				HttpStatus.OK);
	}

	@PutMapping(path = { "v1/admin/grocery/update/{itemId}" }, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@PathVariable Integer itemId, @RequestBody GroceryRequestBean requestBean) {
		return GlobalRepsonseHandler.generateRespone(this.adminServiceImpl.updateItem(itemId, requestBean),
				"Items updated successfully", HttpStatus.OK);
	}

	@DeleteMapping(path = { "v1/admin/grocery/delete/{itemId}" })
	public ResponseEntity<?> delete(@PathVariable Integer itemId) {
		return GlobalRepsonseHandler.generateRespone("Item deleted successfully for itemId: " + itemId,
				HttpStatus.NO_CONTENT);
	}
}
