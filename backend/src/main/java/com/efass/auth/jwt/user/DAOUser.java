package com.efass.auth.jwt.user;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "efass_users")
public class DAOUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private long id;
	
	@Column(name="username")
	
	private String username;
	@Column(name="password")
	@JsonIgnore
	private String password;

	@Column(name="role")
	@JsonIgnore
	private String role; //Added role for user authentication

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {return password;}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole(String role) { return role;}

	public void setRole(String role) {
		this.role = role;
	}
}
