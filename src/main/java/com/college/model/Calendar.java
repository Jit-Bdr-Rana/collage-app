package com.college.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="Calendar")
@Table(name="calenders")
public class Calendar {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="no_of_days")
	private Integer noOfDays=0;
	
    @ManyToOne(targetEntity=Month.class)
    @JoinColumn(name="month_id", referencedColumnName="id")
	 private Month month;
	 
	 @ManyToOne(targetEntity=Week.class)
	 private Week week;
	 
	 
	 @ManyToOne(targetEntity=EnglishMonth.class)
	 @JoinColumn(name="english_month_id", referencedColumnName="id")
	 private EnglishMonth  englishMonth1;
	 
	 @Column(name="starting_day_english_month_one")
	 private Integer startingDayEnglishMonthOne=0;
	 @Column(name="ending_day_english_month_one")
	 private Integer endingDayEnglishMonthOne=0;

	 
	 @ManyToOne(targetEntity=EnglishMonth.class)
	 @JoinColumn(name="english_month_id2", referencedColumnName="id")
	 private EnglishMonth  englishMonth2;
	 
	 @Column(name="starting_day_english_month_two")
	 private Integer startingDayEnglishMonthTwo=0;
	 @Column(name="ending_day_english_month_two")
	 private Integer endingDayEnglishMonthTwo=0;
	 
	 @Override
	public String toString() {
		return "Calendar [id=" + id + ", noOfDays=" + noOfDays + ", month=" + month + ", week=" + week
				+ ", englishMonth1=" + englishMonth1 + ", startingDayEnglishMonthOne=" + startingDayEnglishMonthOne
				+ ", endingDayEnglishMonthOne=" + endingDayEnglishMonthOne + ", englishMonth2=" + englishMonth2
				+ ", startingDayEnglishMonthTwo=" + startingDayEnglishMonthTwo + ", endingDayEnglishMonthTwo="
				+ endingDayEnglishMonthTwo + ", year=" + year + "]";
	}

	public Integer getId() {
		return id;
	}

	public Integer getNoOfDays() {
		return noOfDays;
	}

	public Month getMonth() {
		return month;
	}

	public Week getWeek() {
		return week;
	}

	public EnglishMonth getEnglishMonth1() {
		return englishMonth1;
	}

	public Integer getStartingDayEnglishMonthOne() {
		return startingDayEnglishMonthOne;
	}

	public Integer getEndingDayEnglishMonthOne() {
		return endingDayEnglishMonthOne;
	}

	public EnglishMonth getEnglishMonth2() {
		return englishMonth2;
	}

	public Integer getStartingDayEnglishMonthTwo() {
		return startingDayEnglishMonthTwo;
	}

	public Integer getEndingDayEnglishMonthTwo() {
		return endingDayEnglishMonthTwo;
	}

	public Year getYear() {
		return year;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNoOfDays(Integer noOfDays) {
		this.noOfDays = noOfDays;
	}

	public void setMonth(Month month) {
		this.month = month;
	}

	public void setWeek(Week week) {
		this.week = week;
	}

	public void setEnglishMonth1(EnglishMonth englishMonth1) {
		this.englishMonth1 = englishMonth1;
	}

	public void setStartingDayEnglishMonthOne(Integer startingDayEnglishMonthOne) {
		this.startingDayEnglishMonthOne = startingDayEnglishMonthOne;
	}

	public void setEndingDayEnglishMonthOne(Integer endingDayEnglishMonthOne) {
		this.endingDayEnglishMonthOne = endingDayEnglishMonthOne;
	}

	public void setEnglishMonth2(EnglishMonth englishMonth2) {
		this.englishMonth2 = englishMonth2;
	}

	public void setStartingDayEnglishMonthTwo(Integer startingDayEnglishMonthTwo) {
		this.startingDayEnglishMonthTwo = startingDayEnglishMonthTwo;
	}

	public void setEndingDayEnglishMonthTwo(Integer endingDayEnglishMonthTwo) {
		this.endingDayEnglishMonthTwo = endingDayEnglishMonthTwo;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	@ManyToOne(targetEntity=Year.class)
	 private Year year;
	
}
