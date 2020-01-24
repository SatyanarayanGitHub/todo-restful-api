package org.srysoft.todo.controller;

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
public class WelcomeController {

	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public WelcomeBean welcomeMessage() {
		return new WelcomeBean("Welcome to a TODO Application.");
	}

	@GetMapping("/{name}")
	public WelcomeBean welcomeMessageWithPathVariable(@PathVariable String name) {
		return new WelcomeBean(String.format("Welcome %s, This is a Todo Application.", name));
	}

}
