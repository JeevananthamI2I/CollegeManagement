package com.ideas2it.collegemanagement.util;

import java.text.DateFormat;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.ideas2it.collegemanagement.util.constant.CollegeConstant;
import com.ideas2it.collegemanagement.util.exception.CollegeManagementException;

/**
 * <p>
 * DateUtil class handles the date related functions
 * <p>
 *
 * @author jeevanantham
 * @version 1.0  25 AUG 2022 
 */
public class DateUtil {

    private static final DateFormat formatter = new SimpleDateFormat(CollegeConstant.DATE_FORMAT);
   
    /**
     * This method is used to convert string to date format.
     *
     * @param userDate - is the  parameter to isValidDate method
     * @return     - if date given date is true return true
     *               otherwise false   
     */
    public static boolean isValidDate(String userDate)  {
        boolean value;
        formatter.setLenient(false);
        try {          
            Date parsedDate = formatter.parse(userDate); 
            value = true;          
        }
        catch (ParseException parseException) {
            value = false;
        }
        return value;       
    }
   
    /**
     * Convert String to Date class. 
     *
     * @param userDate - a value to be checked as valid pattern.
     * @return     - parsed date to controller,
     *               null otherwise
     * @throws CollegeManagementException - if string date convert date format occur 
     *      parse exception it converts and throw custom exception
     */
    public static Date parseDate(String userDate)throws CollegeManagementException {
        try {
            Date date = formatter.parse(userDate);
            return date;
        } catch (ParseException parseException) {
            throw new CollegeManagementException (CollegeConstant.INVALID_OPTION);
        }
    } 
   
    /**
     * Convert Date to String class. 
     *
     * @param userDate - a value to be checked as valid pattern.
     * @return     - formatter String date to controller,
     *               
     */
    public static String formatDate(Date userDate) {
        return formatter.format(userDate);
    }
    
    /**
     * Gets format date and gives the difference in years from given
     * date to current date. 
     *
     * @param dateOne - to calculate years from this date one.
     * @param dateTwo - to calculate years from this dateTwo.
     * @return     - calculated years between given date and current date.
     * @throws CollegeManagementException - if given date null throw exception use in this function           
     */
    public static int differenceBetweenTwoDates(Date dateOne, Date dateTwo )throws CollegeManagementException {
             
        if(null != dateOne && null != dateTwo) {
            long differenceInTime = dateTwo.getTime() - dateOne.getTime();
            long years = (differenceInTime / CollegeConstant.CONVERSION_OF_TIME_TO_YEAR);
            return (int)years;
        }
        else {
            throw new CollegeManagementException(CollegeConstant.NOT_FOUND);
        }
        
    }

    /**
     * This method is used to convert string to date format.
     *
     * @param userDate is the  parameter to isValidName method
     * @return LocalDate as datatype and return its object.
     */
    public static boolean validDate(String userDate)  {
        boolean value = false;
        formatter.setLenient(false);
        try {          
            Date parsedDate = formatter.parse(userDate); 
            value = true;          
        }
        catch (ParseException parseException) {
            value = false;
        }
        return value;       
    }

    public static Date getCurrentDate () {
        return new Date();
    }
   
    /**
     * @param date - given the Date data type
     * @return - date convert sql date and return it
     */
    public static java.sql.Date convertIntoSqlDate(Date date) { 
        return new java.sql.Date(date.getTime());
    }
    
    /**
     * @param date - given the Date data type
     * @return - date convert sql date and return it
     */
    public static java.util.Date convertIntoUtilDate(Date date) {
        java.util.Date value = null;
        if(null != date) {
            value =  new java.util.Date(date.getTime());   
        }
        return value;  
    }

    public static boolean compareTwoDates(java.util.Date dateOne, java.util.Date dateTwo) throws CollegeManagementException {
        if (!(dateOne.compareTo(dateTwo) > 0)) {
            throw new CollegeManagementException(CollegeConstant.NOT_FOUND);
        }
        return true;
    }
}
