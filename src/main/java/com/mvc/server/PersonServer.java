package com.mvc.server;

import org.springframework.stereotype.Service;

import com.mvc.entity.Person;

public interface PersonServer {
	
	
	public Person getPerson();
	
	public String getMsg();
}
