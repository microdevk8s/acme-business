package com.acme.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import com.acme.business.entity.Department;
import com.acme.business.entity.Employee;
import com.acme.business.service.DepartmentService;

@RestController
@RequestMapping("/business")
public class DepartmentRestController {
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/departments")
	public List<Department> listar(){
		return departmentService.findAll();
	}
	// Este Metodo utiliza la interface cliente Rest a ACME-API-EMPLOYEE
	@GetMapping("/department/employees/{id}")
	public List<Employee> employees(@PathVariable Integer id){
		return departmentService.findByidDepartment(id);
	}
	
	@GetMapping("/department/{id}")
	public Department buscar(@PathVariable Integer id) {
		return departmentService.findById(id);
	}
	
	@PostMapping("/department")
	@ResponseStatus(HttpStatus.CREATED)
	public Department guardar(@RequestBody Department dept) {
		return departmentService.save(dept);
	}
	
	@DeleteMapping("/department/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Integer id) {
		departmentService.delete(id);
	}
	
	@PutMapping("/department/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Department actualizar(@RequestBody Department dept,@PathVariable Integer id) {
		return departmentService.update(dept, id);
	}
	
	
}
