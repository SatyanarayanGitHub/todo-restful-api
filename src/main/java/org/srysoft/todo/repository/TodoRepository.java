package org.srysoft.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.srysoft.todo.entity.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity, Long>{

	List<TodoEntity> findByUserName(String username);

}
