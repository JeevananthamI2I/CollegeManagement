// This is the interface for the StudentService.
package com.ideas2it.collegemanagement.service;

import java.util.List;

import com.ideas2it.collegemanagement.dto.StudentDTO;
import com.ideas2it.collegemanagement.util.exception.CollegeManagementException;

public interface StudentService {

	StudentDTO saveStudent(StudentDTO studentDTO) throws CollegeManagementException;


	List<StudentDTO> getStudents() throws CollegeManagementException;
	
	public StudentDTO getStudent(int id);
	
	public String deleteStudent(int id);

	public StudentDTO updateStudent(StudentDTO studentDTO, int id);

}