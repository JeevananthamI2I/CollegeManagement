package com.ideas2it.collegemanagement.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ideas2it.collegemanagement.dto.CollegeDTO;
import com.ideas2it.collegemanagement.model.College;

@Component
/**
 * It converts a college to a string.
 */
public class CollegeConverter {

	public CollegeDTO convertCollegeDTO(College college) {
		ModelMapper mapper = new ModelMapper();

		return mapper.map(college, CollegeDTO.class);
	}

	public List<CollegeDTO> convertCollegesDto(List<College> colleges) {
		List<CollegeDTO> CollegeDTOs = new ArrayList<>();
		for (College college : colleges) {
			CollegeDTOs.add(convertCollegeDTO(college));
		}
		return CollegeDTOs;
	}

	public College convertCollege(CollegeDTO collegeDTO) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(collegeDTO, College.class);
	}
}
