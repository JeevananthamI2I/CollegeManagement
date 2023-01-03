package com.ideas2it.collegemanagement.service.impl;

import java.util.List;

import com.ideas2it.collegemanagement.converter.DepartmentConverter;
import com.ideas2it.collegemanagement.dao.DepartmentDao;
import com.ideas2it.collegemanagement.dto.DepartmentDTO;
import com.ideas2it.collegemanagement.model.Department;
import com.ideas2it.collegemanagement.service.DepartmentService;
import com.ideas2it.collegemanagement.util.exception.CollegeManagementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentDao departmentRepository;
	@Autowired
    DepartmentConverter departmentConverter;
	/**
	 * <p>
	 * DepartmentServiceImpl has the methods implementations of DepartmentService to
	 * handle department's operations.
	 * </p>
	 *
	 * @author Jeevanantham K
	 * @version 1.0 10-Aug-2022
	 */
	public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) throws CollegeManagementException {
		departmentDTO.setCode(departmentCode(departmentDTO));
		if (null == departmentDTO) {
			throw new CollegeManagementException("NOT_FOUND");
		}
		Department department = departmentRepository.save(departmentConverter.convertDepartment(departmentDTO));
		return departmentConverter.convertDepartmentDTO(department);
	}

	/**
	 * Returns the code of the current language
	 *
	 * @return The code of the department.
	 */
	public String departmentCode(DepartmentDTO departmentDTO) {
		long value = departmentRepository.getDepartmentCount();
		return departmentDTO.getName().substring(0,3) + (++value);
	}

	public List<DepartmentDTO> getDepartments() {
		return departmentConverter.convertDepartmentsDTO(departmentRepository.findAll());

	}

	public DepartmentDTO getDepartment(int id) {
	 return departmentConverter.convertDepartmentDTO(departmentRepository.findById(id).get());
	}

	public String deleteDepartment(int id) {
		departmentRepository.deleteById(id);
		return "Delete Successful " + id;
	}

	public DepartmentDTO updateDepartment(DepartmentDTO departmentDTO, int id) throws CollegeManagementException {
		Department existingDepartment = departmentRepository.findById(id).orElse(null);
		if (null == departmentDTO) {
			throw new CollegeManagementException("NOT_FOUND");
		}
		if(null != existingDepartment) {
			existingDepartment.setName(departmentDTO.getName());
		}
		return departmentConverter.convertDepartmentDTO(departmentRepository.save(existingDepartment));
	}
	
}
