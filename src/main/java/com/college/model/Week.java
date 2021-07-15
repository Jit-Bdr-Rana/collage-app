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

@Entity(name="Week")
@Table(name="weeks")
public class Week {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=20,nullable=true)
	private String name;
	
	@OneToMany(targetEntity=Calendar.class,cascade=CascadeType.ALL)
	 @JoinColumn(name="week_id", referencedColumnName="id")
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
		return "Week [id=" + id + ", name=" + name + "]";
	}

	public Week(String name) {
		super();
		this.name = name;
	}

	public Week() {
		super();
		// TODO Auto-generated constructor stub
	}

}
