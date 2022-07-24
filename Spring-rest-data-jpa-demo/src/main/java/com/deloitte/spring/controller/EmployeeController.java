package com.deloitte.spring.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.deloitte.spring.exceptions.ErrorDetails;
import com.deloitte.spring.exceptions.IdNotFoundException;
import com.deloitte.spring.model.Employee;
import com.deloitte.spring.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee employeedata= service.addEmployee(employee);
		return new ResponseEntity<Employee>(employeedata, HttpStatus.OK);
		
	}
	
	//when url is coming with some property, path variable, param and property name should be same
	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {
		Employee employee = service.getEmployee(id);
		if(employee == null) {
			throw new IdNotFoundException("No record with id " + id);
		}
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	
	@GetMapping("/getEmployee")
	public ResponseEntity<List<Employee>> getEmployees(){
		List<Employee> employee = service.getEmployees();
		return new ResponseEntity<List<Employee>>(employee,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public List<Employee> deleteEmployee(@PathVariable int id){
		List<Employee> list = service.deleteEmployee(id);
		if(list== null) {
			throw new IdNotFoundException("No employee with id " + id + "to delete.");
		}
		return list;
		
	}
	
	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee employee) {		
		return service.updateEmployee(employee);
		
		
	}
	
	//go to postman, select params, key as designation(both name should be same), and required value, hit the request
	@PostMapping("/getEmployeesOnDesignation")
	public ResponseEntity<List<Employee>> getEmployeesBasedOnCity(@RequestParam String designation){
		List<Employee> list = service.getEmployeeOnDesignation(designation);
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
		
	}
	
	/*
	 * @ExceptionHandler(value = IdNotFoundException.class) public
	 * ResponseEntity<Object> handleException(IdNotFoundException exception) {
	 * return new ResponseEntity<Object>(exception.getMessage(),
	 * HttpStatus.NOT_FOUND);
	 * 
	 * }
	 */

}
