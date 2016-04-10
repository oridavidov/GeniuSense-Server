package com.ori.apps.web.spring.smartsence.dao;

import java.sql.Date;

import javax.validation.constraints.Size;

import com.ori.apps.web.spring.smartsence.validation.ValidEmail;

public class User {
	// using javax.validator.constrains
	private int    user_id;
	
	@Size(min=10, max=20)
	private String unit_id;
	
	@Size(min=6, max=20, message="user name must be 6 to 20")
	private String username;
	
	@ValidEmail(min=6, message="This is not a valid email(custom)")
	//@Pattern(regexp=".*\\@.*\\..*", message="not valid email")
	private String email;
	
	//@NotNull
	private String password;
	
	//@NotNull
	private int enabled;
	
	//@NotNull
	private Date created;
		
	//@NotNull
	private Date lastlogin;
	
	//@Size(min=20, max=255, message="text must be 20 to 255")
	private String authority;
	
	public User() {		
	}	

	

	public User(int user_id, String unit_id, String username, String email,
			String password, int enabled, Date created, Date lastlogin,
			String authority) {
		super();
		this.user_id = user_id;
		this.unit_id = unit_id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.created = created;
		this.lastlogin = lastlogin;
		this.authority = authority;
	}


	public int getUser_id() {
		return user_id;
	}



	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}



	public String getUnit_id() {
		return unit_id;
	}



	public void setUnit_id(String unit_id) {
		this.unit_id = unit_id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
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



	public Date getCreated() {
		return created;
	}



	public void setCreated(Date created) {
		this.created = created;
	}



	public Date getLastlogin() {
		return lastlogin;
	}



	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}



	public String getAuthority() {
		return authority;
	}



	public void setAuthority(String authority) {
		this.authority = authority;
	}



	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", unit_id=" + unit_id
				+ ", username=" + username + ", email=" + email + ", password="
				+ password + ", enabled=" + enabled + ", created=" + created
				+ ", lastlogin=" + lastlogin + ", authority=" + authority + "]";
	}
	
	
}
