package com.college.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;



@Entity(name="Student")
@Table(name="students")
public class Student {
 

@Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 @Column(length=100)
 private Integer id;
 @Column(name="first_name",length=20,nullable=false)
 private String firstName;
 @Column(name="middle_name",length=20,nullable=false)
 private String middleName;
 @Column(name="last_name",length=20,nullable=false)
 private String lastName;
 @Column(name="contact",length=12,nullable=false)
 private String contact;

 @Column(length=100,nullable=true,unique=false)
 private String image;

 @Column(name="registration_year" ,length=20,nullable=false,unique=false)
 private String registrationYear;
// @DateTimeFormat(pattern = "mm/dd/yyyy")
 private Date dob;
 
 @Column(length=8,nullable=false,unique=false)
 private String gender;
 
 @ManyToOne(targetEntity=Program.class)

 private Program program;
 
 
 @OneToOne(cascade = CascadeType.ALL)
 @JoinColumn(name = "user_id", referencedColumnName = "id")
 private User user;

 
 

@Override
public String toString() {
	return "Student [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
			+ ", contact=" + contact + ", image=" + image + ", registrationYear=" + registrationYear + ", dob=" + dob
			+ ", gender=" + gender + ", program=" + program + ",]";
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public Program getProgram() {
	return program;
}

public void setProgram(Program program) {
	this.program = program;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}



public String getRegistrationYear() {
	return registrationYear;
}

public void setRegistrationYear(String registrationYear) {
	this.registrationYear = registrationYear;
}




public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}




public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getMiddleName() {
	return middleName;
}

public void setMiddleName(String middleName) {
	this.middleName = middleName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getContact() {
	return contact;
}

public void setContact(String contact) {
	this.contact = contact;
}



public Date getDob() {
	return dob;
}

public void setDob(Date dob) {
	this.dob = dob;
}


 
 
}