package com.acme.business.service;

import java.util.List;

import com.acme.business.entity.Employee;
import com.acme.business.entity.Department;

public interface DepartmentService {

    public List<Department> findAll();
	
	public Department save(Department dept);
	
	public void delete(Integer id);
	
	public Department update(Department dept,Integer key);
	
	public Department findById(Integer key);
	
	public List<Employee> findByidDepartment(Integer idDepartment);
}
