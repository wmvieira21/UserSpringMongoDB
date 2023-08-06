package com.userspring.userMongo.DTO;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;
import com.userspring.userMongo.domain.User;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String email;

	public UserDTO() {

	}

	public UserDTO(User user) {
		BeanUtils.copyProperties(user, this);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
