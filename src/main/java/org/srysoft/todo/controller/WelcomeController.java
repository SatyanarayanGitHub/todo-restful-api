package org.srysoft.todo.controller;

import javax.management.RuntimeErrorException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.srysoft.todo.bean.WelcomeBean;

/**
 * 
 * @author SATYA
 *
 */
@RestController
@RequestMapping("/welcome")
@CrossOrigin("http://localhost:4200")
public class WelcomeController {

	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public WelcomeBean welcomeMessage() {
		return new WelcomeBean("Welcome to TODO Restful API.");
	}

	@GetMapping("/{name}")
	public WelcomeBean welcomeMessageWithPathVariable(@PathVariable String name) {
		return new WelcomeBean(String.format("Welcome %s, This is a Todo Restful API.", name));
	}
	
	@GetMapping("/runtimeexception")
	public WelcomeBean welcomeException() {
		throw new RuntimeException("An error occurred. Contact support team for assistance. Good Bye!!");		
	}

}
