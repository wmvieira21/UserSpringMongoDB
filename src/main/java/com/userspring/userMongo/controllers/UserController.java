package com.userspring.userMongo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userspring.userMongo.domain.User;

@RestController
@RequestMapping(value = "users")
public class UserController {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.ok().body(List.of(new User(1L, "William", "a@a.com")));
	}
}
