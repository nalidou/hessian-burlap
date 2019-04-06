package com.mvc.wzy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.BurlapProxyFactoryBean;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

import com.mvc.server.PersonServer;

@Configuration
public class HessianContext {

	@Bean
	public HessianProxyFactoryBean hessianProxyFactory(){
	  HessianProxyFactoryBean proxyFactory = new HessianProxyFactoryBean();;  
	  proxyFactory.setServiceUrl("http://localhost:8080/Springmvc/hessian.ser");
	  proxyFactory.setServiceInterface(PersonServer.class);
	
	 return proxyFactory;
	}
	

}
