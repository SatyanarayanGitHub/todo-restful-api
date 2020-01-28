package org.srysoft.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.srysoft.todo.entity.EmployeeEntity;
/**
 * 
 * @author SATYA
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}
