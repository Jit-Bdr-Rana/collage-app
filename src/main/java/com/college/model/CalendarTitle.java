package com.college.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="calendar_title")
public class CalendarTitle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(targetEntity=Month.class)
    private Month month;

	private Integer day;
	

    private Integer year;
    
    @Column(length=255)
	private String title;

}
