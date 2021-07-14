package com.acme.business.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.acme.business.entity.Employee;



@FeignClient(name="acme-api-employee")
public interface EmployeeClientRest {
   
	@GetMapping("/api/employees/{id}")
	public List<Employee> findByDepartment(@PathVariable Integer id);
	
}
