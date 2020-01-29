package org.srysoft.todo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.srysoft.todo.entity.TodoEntity;

/**
 * 
 * @author SATYA
 *
 */
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

	List<TodoEntity> findByUserName(String username);

	Optional<TodoEntity> findByUserNameAndId(String username, long id);

}
