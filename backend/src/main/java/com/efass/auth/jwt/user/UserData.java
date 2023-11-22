package com.efass.auth.jwt.user;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@FieldMatch.List({ @FieldMatch(first = "password", second = "confirmPassword", message = "{password.mustmatch}"),

})
public class UserData {

	private String roles;

	@NotBlank(message = "{username.notempty}")
	@Size(min = 3, max = 50)
	private String username;

	@NotEmpty(message = "{password.notempty}")
	private String password;

	@NotEmpty(message = "{confirm.password.notempty}")
	private String confirmPassword;
	
	private int enabled;

	
	private int user_id;
	
	public UserData(String roles, String username, String password, int enabled, int user_id) {
		super();
		this.roles = roles;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.user_id = user_id;
		
	}

	public UserData() {
		// TODO Auto-generated constructor stub
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

}

