package org.srysoft.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.srysoft.todo.entity.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity, Long>{

}
