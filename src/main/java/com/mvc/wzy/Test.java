package com.mvc.wzy;

import java.net.MalformedURLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.remoting.caucho.BurlapProxyFactoryBean;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

import com.caucho.burlap.client.BurlapProxyFactory;
import com.caucho.hessian.client.HessianProxyFactory;
import com.mvc.server.PersonServer;

public class Test {
	
	public static void main(String[] args) throws MalformedURLException {
		
		//Spring 加载
		 ApplicationContext app = 
				// new AnnotationConfigApplicationContext(com.mvc.wzy.HessianContext.class);
		         new AnnotationConfigApplicationContext(com.mvc.wzy.BurlapContext.class);
		 PersonServer p = app.getBean(PersonServer.class);
		 System.out.println( p.getMsg());
		 System.out.println(p.getPerson());
		
		
		
		/*
		 * java代码实现Hessian客户端
		 */
//		 HessianProxyFactory hfactory = new HessianProxyFactory();
//		 PersonServer service = 
//		 (PersonServer) hfactory.create(PersonServer.class, "http://localhost:8080/Springmvc/hessian.ser");
//		 System.out.println(service.getMsg());//返回的对象一定要实现序列化
//		 System.out.println(service.getPerson().toString());
		
		/*
		 * java代码实现Burlap客户端
		 */
//		 BurlapProxyFactory bfactory = new BurlapProxyFactory();
//		  service = 
//				 (PersonServer) bfactory.create(PersonServer.class, "http://localhost:8080/Springmvc/burlap.ser");
//
//		 System.out.println(service.getMsg());//返回的对象一定要实现序列化
//		 System.out.println(service.getPerson().toString());
		 
		 
	}

}
