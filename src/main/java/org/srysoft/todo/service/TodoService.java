package org.srysoft.todo.service;

import java.util.List;

import org.srysoft.todo.bean.TodoBean;
/**
 * 
 * @author SATYA
 *
 */
public interface TodoService {

	public List<TodoBean> findAllTodos(String username);

	public List<TodoBean> findAllTodos();
}
