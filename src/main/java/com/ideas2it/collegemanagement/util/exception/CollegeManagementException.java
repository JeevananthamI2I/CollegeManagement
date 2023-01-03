package com.ideas2it.collegemanagement.util.exception;

import org.springframework.http.HttpStatus;

/**
	 * <p>
	 * This class is used to create custom exception and use this function.
	 * <p>
	 *
	 * @author jeevanantham
	 * @version 1.0  10 SEP 2022
	 */
public class CollegeManagementException  extends Exception {

	    private String code;
		private HttpStatus status;

		public CollegeManagementException (String message) {
	        super (message);
	    }

	   public CollegeManagementException(String message, Throwable throwable) {
	       super (message);
	   }
	   
	   public CollegeManagementException(String message, String code, HttpStatus status) {
			super(message);
			this.code = code;
			this.status = status;
		}
	}