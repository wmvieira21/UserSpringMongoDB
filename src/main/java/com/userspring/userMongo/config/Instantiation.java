package com.userspring.userMongo.config;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.userspring.userMongo.domain.Post;
import com.userspring.userMongo.domain.User;
import com.userspring.userMongo.repository.PostRepository;
import com.userspring.userMongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.deleteAll();
		userRepository.saveAll(List.of(maria, alex, bob));

		// posts
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss").withZone(ZoneId.systemDefault());
		Post post1 = new Post(null, "Viagem para SP", "compras", Instant.now(), maria);
		Post post2 = new Post(null, "Viagem para SC", "praia", Instant.now(), maria);
		
		postRepository.deleteAll();
		postRepository.saveAll(List.of(post1, post2));

	}
}
