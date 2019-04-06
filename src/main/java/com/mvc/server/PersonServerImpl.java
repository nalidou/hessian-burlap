package com.mvc.server;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import com.mvc.entity.Person;

@Service
public class PersonServerImpl implements PersonServer {

	public PersonServerImpl(){
		System.out.println("PersonServer..");
		
	}
	@Override
	public Person getPerson(){
		//如果返回的是一个自己创建的对象，需要把这个对象序列化了，不然不行
		return new Person("aaa",34);
	}

	@Override
	public String getMsg() {
		//String已经实现了序列化，所以说返回的对象必须实现序列化
		return "hello wzy";
	}
}
