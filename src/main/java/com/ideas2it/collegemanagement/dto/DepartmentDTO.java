package com.ideas2it.collegemanagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DepartmentDTO {
	private int id;
	private String name;
	private String code;
	private List<CollegeDTO> colleges;
}
