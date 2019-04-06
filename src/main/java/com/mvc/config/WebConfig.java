package com.mvc.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.BurlapServiceExporter;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mvc.server.PersonServer;
import com.mvc.server.PersonServerImpl;

@Configuration
@EnableWebMvc
//@ComponentScan("com.mvc.action")
public class WebConfig  
//extends WebMvcConfigurerAdapter
{
	/*
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
		
	}
	
	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer){
		configurer.enable();
		
	}
	*/
	
	/*
	@Bean
	public HandlerMapping hessianMapping(){
		SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
		Properties mappings = new Properties();
		mappings.setProperty("/hessian.ser", "hessianService");
		mapping.setMappings(mappings);
		return mapping;
		
	}
	*/
	
	@Bean
	public HandlerMapping mapping(){
		System.out.println("-->Mapping");
		SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
		Properties mappings = new Properties();
		
		mappings.setProperty("/burlap.ser", "burlapService");
		//给bean绑定url，bean的名字（burlapService）必须对应
		mappings.setProperty("/hessian.ser", "hessianService");
		
		mapping.setMappings(mappings);
		return mapping;
		
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public BurlapServiceExporter burlapService(PersonServer personServer){
		System.out.println("-->burlapService");
		BurlapServiceExporter exporter = new BurlapServiceExporter();
		exporter.setService(personServer);
		exporter.setServiceInterface(PersonServer.class);
		return exporter;
	}
	
	
	
	@Bean
	public HessianServiceExporter hessianService(PersonServer personServer){
		System.out.println("-->hessianService");
		HessianServiceExporter exporter = new HessianServiceExporter();
		exporter.setService(personServer);
		exporter.setServiceInterface(PersonServer.class);
		return exporter;
	}
	

	@Bean
	public PersonServer personServer(){
		
		return new PersonServerImpl();
	}
}
