package com.ideas2it.collegemanagement.service;

import java.util.List;

import com.ideas2it.collegemanagement.dto.DepartmentDTO;
import com.ideas2it.collegemanagement.util.exception.CollegeManagementException;

/**
 *<p>
 * DepartmentService has the methods to handle department's operations.
 *</p>
 *
 * @author Jeevanantham K
 * @version 1.0 20-AUG-2022
 */
public interface DepartmentService {

	/**
     * <p>
     * To Create the Department.
     * </p>
     *
     * @param departmentDTO - the department to be created
     * @return - the created college 
     * @throws CollegeManagementException - if the input is invalid
     */
	 DepartmentDTO saveDepartment(DepartmentDTO departmentDTO)throws CollegeManagementException;


	/**
	 * <p>
	 * To display all the active department stored in the department table.
	 * </p>
	 * 
	 * @return - the list of active department
	 * @throws CollegeManagementException - when department table is empty
	 */
	public List<DepartmentDTO> getDepartments();
	
	 /**
     * <p>
     * To get the department for the given department id.
     * </p>
     *
     * @param id - an department id for which the department to be returned
     * @return   - the department if the department id is found
     * @throws CollegeManagementException - if the department id is not found 
     */
	public DepartmentDTO getDepartment(int id)throws CollegeManagementException;
	
	/**
     * <p>
     * To remove the department for the given department id.
     * </p>
     *
     * @param id - an department id to be removed
     * @return   - the success message with HttpStatus.Ok
     * @throws CollegeManagementException - if the department is not found
     */
	 String deleteDepartment(int id) throws CollegeManagementException;

	/**
     * <p> 
     * To update the department for the given department id.
     * </p>
     *
     * @param  id - an department id to be updated
     * @return            - the success message if it is updated
     * @throws CollegeManagementException - if the department is not found, if the college is not updated
     */
	 DepartmentDTO updateDepartment(DepartmentDTO departmentDTO, int id) throws CollegeManagementException;

}