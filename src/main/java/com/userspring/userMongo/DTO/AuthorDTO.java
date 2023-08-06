package com.userspring.userMongo.DTO;

import com.userspring.userMongo.domain.User;

public class AuthorDTO {
	private String id;
	private String name;

	public AuthorDTO() {
	}

	public AuthorDTO(User user) {
		super();
		this.id = user.getId();
		this.name = user.getName();
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
}
