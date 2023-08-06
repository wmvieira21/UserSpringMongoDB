package com.userspring.userMongo.config;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.userspring.userMongo.DTO.AuthorDTO;
import com.userspring.userMongo.DTO.CommentDTO;
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
		Post post1 = new Post(null, "Viagem para SP", "compras", LocalDate.now(), new AuthorDTO(maria));
		Post post2 = new Post(null, "Viagem para SC", "praia", LocalDate.now().plus(Period.ofDays(30)),
				new AuthorDTO(maria));

		postRepository.deleteAll();
		postRepository.saveAll(List.of(post1, post2));

		// saving post on Maria
		maria.getPost().addAll(List.of(post1, post2));
		userRepository.save(maria);

		// comments of the posts
		CommentDTO comment1 = new CommentDTO("Have a nice trip", Instant.now(), new AuthorDTO(bob));
		CommentDTO comment2 = new CommentDTO("Have a good one", Instant.now().plus(Period.ofDays(10)),
				new AuthorDTO(alex));

		post1.getComments().addAll(List.of(comment1, comment2));
		postRepository.save(post1);

	}
}
