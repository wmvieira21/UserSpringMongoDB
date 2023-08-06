package com.userspring.userMongo.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userspring.userMongo.domain.Post;
import com.userspring.userMongo.repository.PostRepository;
import com.userspring.userMongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public List<Post> findAll() {
		return postRepository.findAll();
	}

	public Post findById(String id) {
		Post post = postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Post not found"));
		return post;
	}

	public List<Post> findByTitle(String text) {
		//return postRepository.findByTitleContainingIgnoreCase(text);
		return postRepository.searchTitle(text);
	}
	
	public List<Post> fullSearchTitle(String title, LocalDate minDate, LocalDate maxDate){
		return postRepository.fullSearchTitle(title, minDate, maxDate);
	}
}
