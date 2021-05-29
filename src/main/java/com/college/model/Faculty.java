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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="faculties")
public class Faculty {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;

@Column(length=30,nullable=false,unique=true)
private String name;



@Override
public String toString() {
	return "Faculty [id=" + id + ", name=" + name ;
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
