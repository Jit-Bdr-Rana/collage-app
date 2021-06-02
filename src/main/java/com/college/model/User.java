package com.college.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity(name="User")
@Table(name="users")
public class User {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;

@Column(unique=true,nullable=false,length=50)
private String email;
@Column(nullable=false,length=60)
private String password;

@OneToOne(mappedBy = "user")
private Student student;
private String role;


@Override
public String toString() {
	return "User [id=" + id + ", email=" + email + ", password=" + password + ", student=" + student + ", role=" + role
			+ "]";
}

public Integer getId() {
	return id;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public void setId(Integer id) {
	this.id = id;
}

public User() {
	super();
	// TODO Auto-generated constructor stub
}

public String getEmail() {
	return email;
}

public User(Integer id, String email, String password, Student student) {
	super();
	this.id = id;
	this.email = email;
	this.password = password;
	this.student = student;
}

public User( String email, String password, Student student) {
	super();
	this.email = email;
	this.password = password;
	this.student = student;
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

public Student getStudent() {
	return student;
}

public void setStudent(Student student) {
	this.student = student;
}

}