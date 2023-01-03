package com.ideas2it.collegemanagement.converter;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.collegemanagement.dto.StudentDTO;
import com.ideas2it.collegemanagement.model.Student;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
@Component
public class StudentConverter {

	public StudentDTO convertStudentDTO(Student student) {
		ModelMapper mapper = new ModelMapper();

        return mapper.map(student, StudentDTO.class);
	}

	public List<StudentDTO> convertStudentsDTO(List<Student> students) {
		List<StudentDTO> StudentDTOs = new ArrayList<>();
		for (Student student : students) {
			StudentDTOs.add(convertStudentDTO(student));
		}
		return StudentDTOs;
	}

	public Student convertStudent(StudentDTO StudentDTO) {
		ModelMapper mapper = new ModelMapper();
        return mapper.map(StudentDTO, Student.class);
	}
	
}