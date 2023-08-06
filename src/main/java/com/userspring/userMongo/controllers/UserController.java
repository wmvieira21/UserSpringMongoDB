package com.userspring.userMongo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userspring.userMongo.DTO.UserDTO;
import com.userspring.userMongo.domain.User;
import com.userspring.userMongo.services.UserService;

@RestController
@RequestMapping(value = "users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		return ResponseEntity.ok().body(userService.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		return ResponseEntity.ok().body(userService.findById(id));
	}
}
