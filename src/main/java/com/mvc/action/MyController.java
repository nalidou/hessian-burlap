package com.mvc.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.server.PersonServer;


@Controller
public class MyController {
	
	@Autowired
	private PersonServer p;
	public MyController(){
		
		System.out.println("MyController...");
	}

	@RequestMapping("test")
	public String test(Map map){
		
		map.put("p", p.getPerson());
		
		System.out.println("test...");
		
		return "home";
	}
}
