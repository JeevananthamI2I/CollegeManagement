package com.ideas2it.collegemanagement.service;

import java.util.Date;
import java.util.List;

import com.ideas2it.collegemanagement.util.exception.CollegeManagementException;
import com.ideas2it.collegemanagement.dto.CollegeDTO;

/**
 *<p>
 * CollegeService has the methods to handle college's operations.
 *</p>
 *
 * @author Jeevanantham K
 * @version 1.0 20-AUG-2022
 */
public interface CollegeService {

	/**
     * <p>
     * To Create the college.
     * </p>
     *
     * @param collegeDTO - the college to be created
     * @return - the created college 
     * @throws CollegeManagementException - if the input is invalid
     */
	 CollegeDTO saveCollege(CollegeDTO collegeDTO) throws CollegeManagementException;

	/**
	 * <p>
	 * To display all the active colleges stored in the colleges table.
	 * </p>
	 * 
	 * @return - the list of active colleges
	 * @throws CollegeManagementException - when colleges table is empty
	 */
	 List<CollegeDTO> getColleges() throws CollegeManagementException;
	
	 /**
     * <p>
     * To get the college for the given college id.
     * </p>
     *
     * @param id - an college id for which the college to be returned
     * @return   - the college if the college id is found
     * @throws CollegeManagementException - if the college id is not found 
     */
	 CollegeDTO getCollege(int id) throws CollegeManagementException;
	
	 /**
     * <p>
     * To remove the college for the given college id.
     * </p>
     *
     * @param id - an college id to be removed
     * @return   - the success message with HttpStatus.Ok
     * @throws CollegeManagementException - if the college is not found
     */
	 CollegeDTO deleteCollege(int id) throws CollegeManagementException;
	
	/**
     * <p>
     * To update the college for the given college id.
     * </p>
     *
     * @param  id - an college id to be updated
     * @return            - the success message if it is updated
     * @throws CollegeManagementException - if the college is not found, if the college is not updated
     */
	 CollegeDTO updateCollege(CollegeDTO collegeDTO, int id) throws CollegeManagementException;

	/**
     * <p>
     * To fetch the colleges between the range of date.
     * </p>
     *
     * @param startDate - a start date for which college will be filtered
     * @param endDate - an end date for which college will be filtered
     * @return        - the list of filtered colleges
     * @throws CollegeManagementException - if there is no college based on the given range
     */
	 List<CollegeDTO> findCollegeByDate(Date startDate, Date endDate);
	
	/**
     * <p>
     * To fetch the colleges for the multiple given id.
     * </p>
     *
     * @param ids - the list of id for which the college to be returned
     * @return   - the list of filtered colleges
     * @throws CollegeManagementException - if there is no college for the given id
     */
	 List<CollegeDTO> getCollegesByMultipleId(List<Integer> ids);

}
