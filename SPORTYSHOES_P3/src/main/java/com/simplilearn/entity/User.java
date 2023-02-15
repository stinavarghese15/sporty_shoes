package com.simplilearn.entity;


import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true)
	private int id;
	
	 @Column(nullable = false, unique = true, length = 45)
	private String email;
	 
	 @Column(nullable = false, unique = true, length = 45)
	private String password;
	 
	 @Column(name = "first_name" ,nullable = false, unique = true, length = 45)
	private String firstname;
	
	 @Column(name = "last_name",nullable = false, unique = true, length = 45)
	 private String lastname;
	
	 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
