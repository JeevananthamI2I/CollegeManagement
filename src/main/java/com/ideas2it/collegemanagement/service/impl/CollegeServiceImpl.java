package com.ideas2it.collegemanagement.service.impl;

import java.util.Date;
import java.util.List;

import com.ideas2it.collegemanagement.converter.CollegeConverter;
import com.ideas2it.collegemanagement.dto.CollegeDTO;
import com.ideas2it.collegemanagement.model.College;
import com.ideas2it.collegemanagement.service.CollegeService;
import com.ideas2it.collegemanagement.util.exception.CollegeManagementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.collegemanagement.dao.CollegeDao;

/**
 * <p>
 * CollegeServiceImpl has the methods implementations of CollegeService to
 * handle college's operations.
 * </p>
 *
 * @author Jeevanantham K
 * @version 1.0 10-Aug-2022
 */
@Service
public class CollegeServiceImpl implements CollegeService {

	private final CollegeDao collegeRepository;
	private final CollegeConverter collegeConverter;

	@Autowired
		public CollegeServiceImpl(CollegeDao collegeRepository, CollegeConverter collegeConverter) {
		this.collegeRepository = collegeRepository;
		this.collegeConverter = collegeConverter;
	}

	/**
	 * {@inheritDoc}
	 */
	public CollegeDTO saveCollege(CollegeDTO collegeDTO) throws CollegeManagementException {
		collegeDTO.setCode(generateCode(collegeDTO));
		if(null == collegeDTO) {
			throw new CollegeManagementException("collegeException");
		}
		return  collegeConverter.convertCollegeDTO(collegeRepository.save(collegeConverter.convertCollege(collegeDTO)));
	}

	/**
	 * {@inheritDoc}
	 */
	public String generateCode(CollegeDTO collegeDTO) {
		long value = collegeRepository.getCollegesCount();
		return collegeDTO.getName().substring(0,3) + (++value);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<CollegeDTO> getColleges() throws CollegeManagementException {
		List<College> colleges = collegeRepository.findAll();
		if(null == colleges) {
			throw new CollegeManagementException("no details found");
		}
		return collegeConverter.convertCollegesDto(colleges);
	}

	/**
	 * {@inheritDoc}
	 */
	public CollegeDTO getCollege(int id) throws CollegeManagementException {
		if (!collegeRepository.existsById(id)){
			throw new CollegeManagementException("");
		}
	   return collegeConverter.convertCollegeDTO(collegeRepository.findById(id).get());
	}

	/**
	 * {@inheritDoc}
	 */
	public CollegeDTO deleteCollege(int id) throws CollegeManagementException {
		if (!collegeRepository.existsById(id)){
			throw new CollegeManagementException("");
		}
		collegeRepository.deleteById(id);
		College college = collegeRepository.findById(id).get();
		return collegeConverter.convertCollegeDTO(college);
	}

	/**
	 * {@inheritDoc}
	 */
	public CollegeDTO updateCollege(CollegeDTO collegeDto, int id) throws CollegeManagementException {
		CollegeDTO existingCollege = null;
		
		if (collegeRepository.existsById(id)) {
			// existingCollege = collegeConverter.entityToDto(getCollege(id));
			if (null != existingCollege) {
				existingCollege.setName(collegeDto.getName());
				existingCollege.setPlace(collegeDto.getPlace());		
				existingCollege.setInaugurationDate(collegeDto.getInaugurationDate());
				existingCollege.setRank(collegeDto.getRank());
				existingCollege.setType(collegeDto.getType());
				existingCollege.setUniversity(collegeDto.getUniversity());
				/*if (null != collegeDto.getDepartments()) {
					List<Department> input = existingCollege.getDepartments();
					input.addAll(collegeDto.getDepartments());
					existingCollege.setDepartments(input);
				}*/
			}
		}
		return existingCollege;
	
	}

	/**
	 * {@inheritDoc}
	 */
	public List<CollegeDTO> findCollegeByDate(Date startdate, Date endDate) {
		collegeRepository.findByInaugurationDateBetween(startdate, endDate);
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<CollegeDTO> getCollegesByMultipleId(List<Integer> ids) {
		
		collegeRepository.findByIdIn(ids);
		return null;
	}

			
}
