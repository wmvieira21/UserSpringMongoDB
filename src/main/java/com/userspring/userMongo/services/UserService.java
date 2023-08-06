package com.userspring.userMongo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userspring.userMongo.DTO.UserDTO;
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

	public UserDTO findById(String id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found"));
		return new UserDTO(user);
	}
}
