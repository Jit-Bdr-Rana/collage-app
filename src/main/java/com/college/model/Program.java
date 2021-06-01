package com.college.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity(name="Program")
@Table(name="programs")
public class Program {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(length=30,nullable=false,unique=true)
	
	
	@NotEmpty(message = "Field can't be empty!")
	private String name;
	
	@OneToMany(targetEntity=Student.class,cascade=CascadeType.ALL)
	 @JoinColumn(name="program_id", referencedColumnName="id")
	private List<Student> student;
	
	@Override
	public String toString() {
		return "Program [id=" + id + ", name=" + name + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
