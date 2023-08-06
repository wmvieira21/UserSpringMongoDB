package com.userspring.userMongo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.userspring.userMongo.DTO.UserDTO;
import com.userspring.userMongo.domain.Post;
import com.userspring.userMongo.domain.User;
import com.userspring.userMongo.repository.UserRepository;
import com.userspring.userMongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<UserDTO> findAll() {
		return userRepository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
	}

	public User findById(String id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found"));
		return user;
	}

	public User insertUser(User user) {
		return userRepository.insert(user);
	}

	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}

	public User update(User param) {
		User user = findById(param.getId());

		user.setName(param.getName());
		user.setEmail(param.getEmail());

		return userRepository.save(user);

	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
}
