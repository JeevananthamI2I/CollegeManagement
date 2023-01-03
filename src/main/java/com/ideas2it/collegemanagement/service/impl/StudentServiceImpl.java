package com.ideas2it.collegemanagement.service.impl;

import java.util.List;

import com.ideas2it.collegemanagement.converter.StudentConverter;
import com.ideas2it.collegemanagement.dao.StudentDao;
import com.ideas2it.collegemanagement.dto.StudentDTO;
import com.ideas2it.collegemanagement.model.Student;
import com.ideas2it.collegemanagement.service.StudentService;
import com.ideas2it.collegemanagement.util.exception.CollegeManagementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * StudentServiceImpl has the methods implementations of StudentService to
 * handle student's operations.
 * </p>
 *
 * @author Jeevanantham K
 * @version 1.0 10-Aug-2022
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentRepository;
	@Autowired
	StudentConverter studentConverter;
	/**
	 * {@inheritDoc}
	 */
	public StudentDTO saveStudent(StudentDTO studentDTO) throws CollegeManagementException {
		studentDTO.setCode(studentCode(studentDTO));
		if (null == studentDTO) {
			throw new CollegeManagementException("Not_Found");
		}
		return studentConverter.convertStudentDTO(
				studentRepository.save(studentConverter.convertStudent(studentDTO)));
	}



	/**
	 * {@inheritDoc}
	 */
	public String studentCode(StudentDTO studentDTO) {
		long value = studentRepository.getStudentCount();
		return studentDTO.getFirstName().substring(0,3) + (++value);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<StudentDTO> getStudents() throws CollegeManagementException{
	    List<Student> students = studentRepository.findAll();
		if (null == students) {
			throw new CollegeManagementException("Not_Found");
		}
	    return studentConverter.convertStudentsDTO(students);
	}

	/**
	 * {@inheritDoc}
	 */
	public StudentDTO getStudent(int id) {
		studentRepository.findById(id).get();
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String deleteStudent(int id) {
		studentRepository.deleteById(id);
		return "Delete Succcessful Your Id " + id;
	}

	@Override
	public StudentDTO updateStudent(StudentDTO studentDTO, int id) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public StudentDTO updateStudent(Student student, int id) {
		Student existingStudent = studentRepository.findById(id).orElse(null);
		if (null != existingStudent) {
			existingStudent.setFirstName(student.getFirstName());
			existingStudent.setLastName(student.getLastName());
			existingStudent.setPlace(student.getPlace());
			existingStudent.setDateOfBirth(student.getDateOfBirth());
			existingStudent.setMobileNumber(student.getMobileNumber());
		}
		studentRepository.save(existingStudent);
		//return existingStudent;
return null;
	}

}
