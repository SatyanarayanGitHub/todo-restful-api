package org.srysoft.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.srysoft.todo.bean.TodoBean;
import org.srysoft.todo.service.TodoService;

@RestController
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping("/todo")
	public List<TodoBean> getAllTodos() {
		return todoService.findAllTodos();
	}
	
	@GetMapping("user/{username}/todo")
	public List<TodoBean> getAllUserTodos(
			@PathVariable(name = "username") String username) {
		return todoService.findAllTodos(username);
	}

}
