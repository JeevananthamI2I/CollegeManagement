package com.ideas2it.collegemanagement.converter;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.collegemanagement.dto.DepartmentDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ideas2it.collegemanagement.model.Department;

@Component
public class DepartmentConverter {

		public DepartmentDTO convertDepartmentDTO(Department department) {
			ModelMapper mapper = new ModelMapper();

			return mapper.map(department, DepartmentDTO.class);
		}

		public List<DepartmentDTO> convertDepartmentsDTO(List<Department> Departments) {
			List<DepartmentDTO> departmentDTOs = new ArrayList<DepartmentDTO>();
			for (Department department : Departments) {
				departmentDTOs.add(convertDepartmentDTO(department));
			}
			return departmentDTOs;
		}

		public Department convertDepartment(DepartmentDTO departmentDTO) {
			ModelMapper mapper = new ModelMapper();
			return mapper.map(departmentDTO, Department.class);
		}
		
	}