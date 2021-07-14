package com.acme.business.dao;

import org.springframework.data.repository.CrudRepository;

import com.acme.business.entity.Department;

public interface DepartmentDao extends CrudRepository<Department, Integer> {

}
