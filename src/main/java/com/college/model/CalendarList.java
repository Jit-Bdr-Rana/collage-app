package com.college.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CalendarList {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private List<Calendar> calenders=new ArrayList<>();
	private Integer yearId;
	
	public Integer getYearId() {
		return yearId;
	}


	public void setYearId(Integer yearId) {
		this.yearId = yearId;
	}


	public Integer getId() {
		return id;
	}


	


	public void setId(Integer id) {
		this.id = id;
	}


	public void setCalenders(List<Calendar> calenders) {
		this.calenders = calenders;
	}


	

	public  void addCalendar(Calendar calendar)	{ 	
		this.calenders.add(calendar);
	}
	
	
	public List<Calendar> getCalenders(){
		return calenders;
	}


	@Override
	public String toString() {
		return "CalendarList [id=" + id + ", calenders=" + calenders + "]";
	}

}
