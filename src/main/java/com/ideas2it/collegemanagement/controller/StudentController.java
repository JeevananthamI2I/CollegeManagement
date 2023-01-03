package com.ideas2it.collegemanagement.controller;

import java.util.List;

import com.ideas2it.collegemanagement.converter.StudentConverter;
import com.ideas2it.collegemanagement.util.exception.CollegeManagementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.collegemanagement.dto.StudentDTO;
import com.ideas2it.collegemanagement.service.StudentService;

@RestController
public class StudentController {

	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@PostMapping("/addStudent")
	public StudentDTO addStudent(@RequestBody StudentDTO StudentDTO) throws CollegeManagementException {
		return studentService.saveStudent(StudentDTO);
	}

	@GetMapping("/viewStudents")
	public List<StudentDTO> viewStudent() throws CollegeManagementException{
		return studentService.getStudents();
	}

	@GetMapping("/viewStudent/{id}")
	public StudentDTO viewStudent(@PathVariable("id") int id) {
		return studentService.getStudent(id);
	}

	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable int id) {
		return studentService.deleteStudent(id);
	}

	@PutMapping("/updateStudent/{id}")
	public StudentDTO updateStudent(@RequestBody StudentDTO StudentDTO, @PathVariable("id") int id) {
		return studentService.updateStudent(StudentDTO, id);
	}
}
