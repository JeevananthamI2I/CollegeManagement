package com.ideas2it.collegemanagement.util.enumeration;

import com.ideas2it.collegemanagement.util.constant.CollegeConstant;
import com.ideas2it.collegemanagement.util.exception.CollegeManagementException;

/**
 * <p>
 * These are the type of college are available for education.
 * <p>
 *
 * @author jeevanantham
 * @version 1.0  25 AUG 2022
 */
public enum Type {
    WOMEN_COLLEGE(1),
    MEN_COLLEGE(2),
    COEDUCATION_COLLEGE(3);

    public final int value;

    Type (final int value) {
        this.value = value; 
    }
    
     /**
      * Get the choice from the user and return the enum constant based on user choice.
      *
      * @param value - the user choice to get the enum constant
      * @return       - enum constant
      * @throws CollegeManagementException - when the  is null, throw custom
      *                            exception to model               
      */  
     public static Type getType(int value) throws CollegeManagementException {
        Type result = null;
        for(Type type : Type.values()) {
            if(type.value == value) {
                result = type;
                break;
            }
        }
        if (null == result) {
            throw new CollegeManagementException(CollegeConstant.INVALID_OPTION);
        }
        return result;
    } 
    
}