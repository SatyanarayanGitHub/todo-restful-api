package org.srysoft.todo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.srysoft.todo.bean.TodoBean;
import org.srysoft.todo.entity.TodoEntity;
import org.srysoft.todo.exception.RecordNotFoundException;
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

	@Override
	public TodoBean deleteByUserNameAndId(String username, long id) throws RecordNotFoundException {

		TodoBean todoBean = null;
		Optional<TodoEntity> todoEntity = todoRepository.findByUserNameAndId(username, id);

		if (todoEntity.isPresent()) {
			todoRepository.deleteById(id);
			todoBean = new TodoBean(todoEntity.get());

		} else {
			throw new RecordNotFoundException("No todo record exist for given id [" + id + "]");
		}

		return todoBean;
	}

	@Override
	public TodoBean findTodoByUserAndId(String username, long id) throws RecordNotFoundException {
		TodoBean todoBean = null;
		Optional<TodoEntity> todoEntity = todoRepository.findByUserNameAndId(username, id);

		if (todoEntity.isPresent()) {
			todoBean = new TodoBean(todoEntity.get());

		} else {
			throw new RecordNotFoundException("No todo record exist for given id [" + id + "]");
		}

		return todoBean;
	}

	@Override
	public TodoBean createOrUpdateEmployee(TodoBean todo) throws RecordNotFoundException {
		TodoBean todoBean = null;

		if (todo.getId() != 0L && todo.getId() == -1) {
			// INSERT
			TodoEntity entity = new TodoEntity();

			entity.setDescription(todo.getDescription());
			entity.setDone(false);
			entity.setTargetDate(todo.getTargetDate());
			entity.setUserName(todo.getUsername());

			todoBean = new TodoBean(todoRepository.save(entity));

		} else {
			// UPDATE
			Optional<TodoEntity> todoEntity = todoRepository.findByUserNameAndId(todo.getUsername(), todo.getId());

			if (todoEntity.isPresent()) {

				todoEntity.get().setDescription(todo.getDescription());
				todoEntity.get().setTargetDate(todo.getTargetDate());

				// todoRepository.save(todoEntity.get());
				todoBean = new TodoBean(todoRepository.save(todoEntity.get()));

			} else {
				throw new RecordNotFoundException("No todo record exist for given id [" + todo.getId() + "]");
			}
			
		}

		return todoBean;
	}

}
