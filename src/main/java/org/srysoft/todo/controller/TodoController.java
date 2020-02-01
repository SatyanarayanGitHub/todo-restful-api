package org.srysoft.todo.controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
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
	private static final Logger logger = LoggerFactory.getLogger(TodoController.class);

	@Autowired
	private TodoService todoService;

	public TodoController() {
		logger.info("->> TodoController created!!");
	}

	@GetMapping("/todo")
	public List<TodoBean> getAllTodos() {
		return todoService.findAllTodos();
	}

	@GetMapping("user/{username}/todo")
	public List<TodoBean> getAllTodosByUser(@PathVariable(name = "username") String username) {
		return todoService.findAllTodos(username);
	}

	@GetMapping("user/{username}/todo/{id}")
	public TodoBean getUserTodoByUserAndId(@PathVariable(name = "username") String username, @PathVariable long id)
			throws RecordNotFoundException {
		return todoService.findTodoByUserAndId(username, id);
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

	@PutMapping("/user/{username}/todo")
	public ResponseEntity<TodoBean> updateTodo(@PathVariable String username, @RequestBody TodoBean todo)
			throws RecordNotFoundException {

		TodoBean todoBean = todoService.createOrUpdateEmployee(todo);

		return new ResponseEntity<TodoBean>(todoBean, HttpStatus.OK);
	}

	@PostMapping("/user/{username}/todo")
	public ResponseEntity<Void> saveTodo(@PathVariable String username, @RequestBody TodoBean todo)
			throws RecordNotFoundException {

		todo.setUsername(username);
		TodoBean todoBean = todoService.createOrUpdateEmployee(todo);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todoBean.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

}
