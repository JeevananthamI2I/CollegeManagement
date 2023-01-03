package com.ideas2it.collegemanagement.util.constant;

/**
 * <p>
 * Only contains constants and use display the hard coding.
 * </p>
 *
 * @author jeevanantham
 * @version 1.0 20 Aug 2022 
 */
public class CollegeConstant {
    public static final String SHOW_MAIN_MENU = """
            Choose your options\s
             1.CollegeController\s
             2.DepartmentController\s
             3.StudentController\s
             4.Exit\s
            """;
    public static final String COLLEGE_SHOW_MENU      = """
            Choose your College options\s
             1.Create\s
             2.Display\s
             3.Get college\s
             4.AssignDepartment\s
             5.Update\s
             6.Delete\s
             7.Search\s
             8.GetAssignDepartments\s
             9.get College Between DateOfRecord\s
             10.display Colleges By Multiple Id\s
             11.Exit\s""";
    public static final String SHOW_STUDENT_MENU = """
            Choose your options\s
             1.Create\s
             2.Display\s
             3.Get Student\s
             4.Delete\s
             5.Update\s
             6.Exit""";
    public static final String SHOW_DEPARTMENT_MENU = new StringBuilder()
            .append("Choose your options ").
            append("\n 1.create department \n 2.show departments \n 3. Get departments\n 4.assignColleges ")
            .append("\n 5.DeleteDepartment\n 6.GetDepartmentByCollegeId \n 7.Exit \n").toString();
    public static final String WANT_CONTINUE  = new StringBuilder()
            .append("\n Do you want to continue? press 1")
            .append("\n For exit press any number").toString();
    public static final String ENTER_COLLEGE_NAME              = "Enter college name";
    public static final String ENTER_COLLEGE_UNIVERSITY        = "Enter university";
    public static final String ENTER_RANK                      = "Enter rank";
    public static final String ENTER_PLACE_NAME                = "Enter place name";
    public static final String ENTER_COLLEGE_INAUGURATION_DATE = "Enter the college inaugurationDate in this format(MM/dd/yyyy) :";
    public static final String ENTER_YOU_SEARCH_COLLEGE        = "Enter the College name you want to search";
    public static final String ENTER_YOU_SEARCH                = "Enter te name of you want to search";
    public static final String ENTER_COLLEGE_ID                = "Enter college id ";
    public static final String ENTER_DELETE_ID                 = "Enter delete id ";
    public static final String ENTER_UPDATE_ID                 = "Enter college id you want to update";
    public static final String ENTER_UPDATE_COLLEGE_MENU       = new StringBuilder()
            .append("Choose your replace menu \n").append(" 1.name \n 2.university \n")
            .append(" 3.rank \n 4.place \n 5.inaugurationYear \n 6.collegeType \n 7.Exit")
            .toString();
    public static final String ENTER_UPDATE_STUDENT_MENU       = new StringBuilder()
            .append("Choose your replace menu \n 1.firstName ")
            .append("\n 2.LastName \n 3.Place \n 4. MobileNumber \n 5. Code \n 6. DateOfBirth")
            .toString();
    public static final String CREATE_COLLEGE                  = "Successfully added college details \n";
    public static final String COLLEGE_LISTS                   = "Your college lists \n";
    public static final String DELETED_COLLEGE                 = "\n Deleted college successfully \n";
    public static final String UPDATED_COLLEGE                 = "\n Update college successfully \n";
    public static final String COLLEGE_TYPE_MENU               = "Enter your collegeType :\n 1.Women's college \n 2.Men's college \n 3.Coed college";
    public static final String CHOOSE_VALID_COLLEGE_TYPE       =  "Choose the valid College Type";
    public static final String YOUR_LIST_IS_EMPTY              = "Your list is empty";
    public static final String EMPTY_STRING = "";
    public static final String NOT_FOUND    = "Not found";
    public static final String INVALID_OPTION = "\n !! INVALID OPTION !!\n "
                                         + "\n Choose correct option \n" ;
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String ENTER_FIRST_DATE = "Enter first date MM/dd/yyyy";
    public static final String ENTER_SECOND_DATE = "Enter second date MM/dd/yyyy";
    public static final long CONVERSION_OF_TIME_TO_YEAR = 1000 * 60 * 60 * 24 * 365l;
    public static final String PREPARED_STATEMENT_CONNECTION = "Exception occurs while trying to close the prepared statement";
    public static final String CONNECTION_CLOSE = "Exception occurs while trying to close the connection";
    public static final String CHOICE_WANT = "How many choice you want?";
    public static final String ENTER_STUDENT_ID  = "Enter student id ";
    public static final String ENTER_DEPARTMENT_ID  = "Enter department id ";
    public static final String ENTER_FIRST_NAME  = "Enter first name";
    public static final String ENTER_LAST_NAME  = "Enter last name";
    public static final String ENTER_MOBILE_NUMBER  = "Enter mobile number";
    public static final String EXIT_MESSAGE = "Exit is successful ";
    public static final String ENTER_YOUR_DEPARTMENT = "Enter your department";
    public static final String INSERT_MESSAGE = "Insert successful";
    public static final String GIVEN_ID_NULL = "Given id is something error!!!!";
    public static final String ENTER_STUDENT_NAME = "Enter your name ";
    public static final String ENTER_DATE_OF_BIRTH_DATE = "Enter your date of birth " ;
    public static final String DELETED_DEPARTMENT = "Delete department successful";
    public static final String CREATE_STUDENT = "successfully created student details ";
    public static final String retrieve_MSG = "User given id is didn't retrieve";
    public static final String REMOVE_MSG = "User given id is did not remove";
    public static final String INSERT_MSG = "User create something wrong";
    public static final String CREATE_COLLEGE_UNSUCCESSFUL = "Insert values unsuccessful";
    public static final String UPDATE_MSG = "User given id didn't update";
    public static final String ENTER_SIZE_OF_IDS = "Enter the no of ids you want ?";
    public static final String ENTER_NUMBER_OF_ID = "Enter you want ids";
    public static final String ENTER_TO_CONTINUE = "you want continue";
    public static final String CHOOSE_YOUR_COLLEGE = "Choose your college";
    public static final String CREATE_DEPARTMENT = new StringBuilder()
            .append("\n Press 1 if you find your Department ")
            .append("\npress any other number to create new Department\"").toString();
    public static final String DEPARTMENT_LIST = new StringBuilder()
            .append("\n List of Departments are given below.\n")
            .append("If you don't find any, please create new Department\"").toString();
    public static final String INSERT_COLLEGE = new StringBuilder()
            .append("\n Press 1 if you find your College ")
            .append("\npress any other number to create new College\"").toString();
    public static final String COLLEGE_LIST = new StringBuilder()
            .append("\n List of Colleges are given below.\n")
            .append("If you don't find any, please create new Colleges\"").toString();
    public static final String ENTER_COLLEGE_ID_TO_ASSIGN_DEPARTMENT = "Enter college id to assign department";
}