package com.acme.business.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acme.business.client.EmployeeClientRest;
import com.acme.business.dao.DepartmentDao;
import com.acme.business.entity.Department;
import com.acme.business.entity.Employee;

@Service
public class DepartmentServiceImp implements DepartmentService {
    
	@Autowired
	private EmployeeClientRest employeeClienteRest;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Employee> findByidDepartment(Integer idDepartment) {
		return employeeClienteRest.findByDepartment(idDepartment);
	}

	
	@Override
	@Transactional(readOnly = true)
	public List<Department> findAll() {
		return (List<Department>) departmentDao.findAll();
	}

	@Override
	@Transactional
	public Department save(Department dept) {
		return departmentDao.save(dept);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		departmentDao.deleteById(id);

	}

	@Override
	@Transactional
	public Department update(Department dept, Integer key) {
		Department current = this.findById(key);
		current.setName(dept.getName());
		return this.save(current);
	}

	@Override
	@Transactional(readOnly = true)
	public Department findById(Integer key) {
		return departmentDao.findById(key).orElse(null);
	}

	
}
