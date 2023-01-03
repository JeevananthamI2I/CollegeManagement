package com.ideas2it.collegemanagement.controller;

import java.util.List;

import com.ideas2it.collegemanagement.converter.DepartmentConverter;
import com.ideas2it.collegemanagement.dto.DepartmentDTO;
import com.ideas2it.collegemanagement.service.DepartmentService;
import com.ideas2it.collegemanagement.util.exception.CollegeManagementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("department")
public class DepartmentController {

	private final DepartmentService departmentService;
	private final DepartmentConverter departmentConverter;

	@Autowired
	public DepartmentController(DepartmentService departmentService, DepartmentConverter departmentConverter) {
		this.departmentService = departmentService;
		this.departmentConverter = departmentConverter;
	}

	@PostMapping("/")
	public DepartmentDTO addDepartment(@RequestBody DepartmentDTO departmentDTO) throws CollegeManagementException {
		return departmentService.saveDepartment(departmentDTO);
	}
	
	@GetMapping("/")
	public List<DepartmentDTO> viewDepartment() {
		return departmentService.getDepartments();
	}
	
	@GetMapping("/{id}")
	public DepartmentDTO viewDepartment(@PathVariable("id") int id) throws CollegeManagementException {
		return departmentService.getDepartment(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteDepartment(@PathVariable int id) throws CollegeManagementException {
		return departmentService.deleteDepartment(id);
	}
	
	@PutMapping("/{id}")
	public DepartmentDTO updateDepartment(@RequestBody DepartmentDTO departmentDTO, @PathVariable("id") int id) throws CollegeManagementException {
		return departmentService.updateDepartment(departmentDTO, id);
	}
		
}