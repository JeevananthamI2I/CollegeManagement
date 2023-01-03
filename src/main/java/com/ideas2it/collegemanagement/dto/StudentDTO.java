package com.ideas2it.collegemanagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StudentDTO {
    
	private int id;
	private String firstName;
	private String lastName;
	private long mobileNumber;
	private Date dateOfBirth;
	private String place;
	private String code;

}
