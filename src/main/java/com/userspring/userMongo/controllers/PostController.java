package com.userspring.userMongo.controllers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.userspring.userMongo.controllers.utils.URL;
import com.userspring.userMongo.domain.Post;
import com.userspring.userMongo.services.PostService;

@RestController
@RequestMapping(value = "posts")
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping
	public ResponseEntity<List<Post>> findAll() {
		return ResponseEntity.ok().body(postService.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		return ResponseEntity.ok().body(postService.findById(id));
	}

	@GetMapping(value = "/titleSearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decodeParam(text);
		return ResponseEntity.ok().body(postService.findByTitle(text));
	}

	@GetMapping(value = "/titleSearchFull")
	public ResponseEntity<List<Post>> findByTitleFull(@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate) {

		text = URL.decodeParam(text);
		LocalDate min = URL.corvertDate(minDate);
		LocalDate max = URL.corvertDate(maxDate).plus(Period.ofDays(1));

		return ResponseEntity.ok().body(postService.fullSearchTitle(text, min, max));
	}
}
