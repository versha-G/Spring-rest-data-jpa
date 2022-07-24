package com.deloitte.spring.exceptions;

import java.time.LocalDate;

public class ErrorDetails {
	
	 private String message;
	 private String request;
	 private LocalDate date;
	 
	public ErrorDetails(String message, String request, LocalDate date) {
		super();
		this.message = message;
		this.request = request;
		this.date = date;
	}
	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "ErrorDetails [message=" + message + ", request=" + request + ", date=" + date + "]";
	}
	 
	 

}
