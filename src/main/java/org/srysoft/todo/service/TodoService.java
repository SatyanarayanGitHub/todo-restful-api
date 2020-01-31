package org.srysoft.todo.service;

import java.util.List;

import org.srysoft.todo.bean.TodoBean;
import org.srysoft.todo.exception.RecordNotFoundException;
/**
 * 
 * @author SATYA
 *
 */
public interface TodoService {

	public List<TodoBean> findAllTodos();
	
	public List<TodoBean> findAllTodos(String username);
	
	public TodoBean findTodoByUserAndId(String username, long id) throws RecordNotFoundException;

	public TodoBean deleteByUserNameAndId(String username, long id)  throws RecordNotFoundException;
}
