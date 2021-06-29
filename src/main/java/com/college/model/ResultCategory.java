package com.college.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="ResultCategory")
@Table(name="result_categories")
public class ResultCategory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(length=20)
	private String program;
	
	@OneToMany(targetEntity=Result.class,cascade=CascadeType.ALL)
	 @JoinColumn(name="result_category_id", referencedColumnName="id")
	private List<Result> result;
	
	 @ManyToOne(targetEntity=User.class)
	 private User user;

	
	public Integer getId() {
		return id;
	}
	public String getProgram() {
		return program;
	}
	public Integer getSemester() {
		return semester;
	}
	public String getSubject() {
		return subject;
	}
	public Integer getTerm() {
		return term;
	}
	public java.sql.Date getCreatedAt() {
		return createdAt;
	}
	public java.sql.Date getUpdatedAt() {
		return updatedAt;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public void setSemester(Integer semester) {
		this.semester = semester;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setTerm(Integer term) {
		this.term = term;
	}
	public void setCreatedAt(java.sql.Date createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(java.sql.Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	private Integer semester; 
	
	@Column(length=100)
	private String subject;
	
	private Integer term;
	
	@Column(name="created_at",nullable=true)
	private java.sql.Date createdAt;
	 @Column(name="updated_at",nullable=true)
	 private java.sql.Date updatedAt;
}
