package org.srysoft.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.srysoft.todo.bean.TodoBean;
import org.srysoft.todo.exception.RecordNotFoundException;
import org.srysoft.todo.service.TodoService;

/**
 * 
 * @author SATYA
 *
 */
@RestController
@CrossOrigin("http://localhost:4200")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping("/todo")
	public List<TodoBean> getAllTodos() {
		return todoService.findAllTodos();
	}

	@GetMapping("user/{username}/todo")
	public List<TodoBean> getAllUserTodos(@PathVariable(name = "username") String username) {
		return todoService.findAllTodos(username);
	}

	@DeleteMapping("/user/{username}/todos/{todoId}")
	public ResponseEntity<Void> deleteTodoById(@PathVariable String username, @PathVariable(name = "todoId") long id)
			throws RecordNotFoundException {

		TodoBean todoBean = todoService.deleteByUserNameAndId(username, id);
		if (todoBean != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}
