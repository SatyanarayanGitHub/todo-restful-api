package org.srysoft.todo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.srysoft.todo.bean.TodoBean;
import org.srysoft.todo.repository.TodoRepository;
/**
 * 
 * @author SATYA
 *
 */
@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepository todoRepository;

	@Override
	public List<TodoBean> findAllTodos(String username) {

		/*
		 * List<TodoBean> todoBeanList = todoRepository.findAll().stream().filter(t ->
		 * t.getUserName().equals(username))
		 * .map(TodoBean::new).collect(Collectors.toList()); return todoBeanList;
		 */

		// OR

		List<TodoBean> todoBeanList = todoRepository.findByUserName(username).stream().map(TodoBean::new)
				.collect(Collectors.toList());

		return todoBeanList;
	}

	@Override
	public List<TodoBean> findAllTodos() {
		return todoRepository.findAll().stream().map(TodoBean::new).collect(Collectors.toList());
	}

}
