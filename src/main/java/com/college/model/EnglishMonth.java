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

@Entity(name="EnglishMonth")
@Table(name="english_months")
public class EnglishMonth {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=20,nullable=true)
	private String name;
	
	@OneToMany(targetEntity=Calendar.class,cascade=CascadeType.ALL,mappedBy="englishMonth1")
	
	private List<Calendar> calendar;
	
	
	@OneToMany(targetEntity=Calendar.class,cascade=CascadeType.ALL,mappedBy="englishMonth2")
	
	private List<Calendar> calendar2;
	
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

	public EnglishMonth(String name) {
		super();
		this.name = name;
	}

	public EnglishMonth() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
