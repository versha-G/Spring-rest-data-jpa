package com.deloitte.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.spring.dao.EmployeeRepository;
import com.deloitte.spring.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repository;
	
	public Employee addEmployee(Employee employee) {
		return repository.save(employee);
		
	}
	
	public List<Employee> getEmployees() {
		return repository.findAll();
	}
	
	public Employee getEmployee(int id) {
		Optional<Employee> op = repository.findById(id);
		Employee employee = null;
		if(op.isEmpty()) {
			employee = null;
		} else {
			employee = op.get();
		}
		return employee;
		
	}
	
	public Employee updateEmployee(Employee employee) {
		Employee employee2 = repository.findById(employee.getId()).get();
		employee2.setName(employee.getName());
		employee2.setDesignation(employee.getDesignation());
		return repository.save(employee2);
	}
	
	public List<Employee> deleteEmployee(int id) {
		List<Employee> list = null;
		Optional<Employee> op = repository.findById(id);
		if(op.isPresent()) {
			repository.deleteById(id);
			list = repository.findAll();
		} else {
			list=null;
		}
		
		return list;
		//or return getEmployees();
	}
	
	public List<Employee> getEmployeeOnDesignation(String designation) {
		return repository.findByDesignation(designation);
	}

}
