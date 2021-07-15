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

@Entity(name="Month")
@Table(name="months")
public class Month {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=20,nullable=true)
	private String name;
	
	@OneToMany(targetEntity=Calendar.class,cascade=CascadeType.ALL,mappedBy="month")
	
	private List<Calendar> calendar;


	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Month [id=" + id + ", name=" + name + "]";
	}

	public Month(String name) {
		super();
		this.name = name;
	}

	public Month() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
