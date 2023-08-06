package com.userspring.userMongo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userspring.userMongo.DTO.UserDTO;
import com.userspring.userMongo.domain.User;
import com.userspring.userMongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<UserDTO> findAll() {
		return userRepository.findAll().stream()
				.map(UserDTO::new)
				.collect(Collectors.toList());
	}
}
