package com.deloitte.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="emp_table")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
	@Id
	private int id;
	private String name;
	private String designation;
	private double salary;
	private String address;
	
	
	
	

}
