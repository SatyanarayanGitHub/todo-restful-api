package org.srysoft.todo.service;

import java.util.List;

import org.srysoft.todo.entity.EmployeeEntity;
import org.srysoft.todo.exception.RecordNotFoundException;
/**
 * 
 * @author SATYA
 *
 */
public interface EmployeeService {

	public List<EmployeeEntity> getAllEmployees();

	public EmployeeEntity getEmployeeById(Long id) throws RecordNotFoundException;

	public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) throws RecordNotFoundException;

	public void deleteEmployeeById(Long id) throws RecordNotFoundException;

}
