package com.ideas2it.collegemanagement.dto;

import java.util.Date;
import java.util.List;

import com.ideas2it.collegemanagement.util.enumeration.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CollegeDTO {

	private int id;
	private String name;	
	private String university;
	private String rank;
	private String place;
	private Date inaugurationDate;
	private Type type;
	private String code;
	private List<DepartmentDTO> departments;

	public List<DepartmentDTO> getDepartments() {
		return departments;
	}
	public void setDepartments(List<DepartmentDTO> departments) {
		this.departments = departments;
	}

}
