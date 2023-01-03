package com.ideas2it.collegemanagement.model;

import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * <p>
 * The College class have attributes.
 * This class contain getter and setter method for student attributes
 * </p>
 *
 * @author jeevanantham
 * @version 1.0  10 AUG 2022
 */
@SQLDelete(sql = "UPDATE students SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted = false")
@Entity
@Getter
@Setter
public class Student extends BaseModel {
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "mobile_number", nullable = false)
    private long mobileNumber;
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;
    @Column(name = "place", nullable = false)
    private String place;
    @Column(name = "code", unique = true, nullable = false)
    private String code;
    
    @ManyToOne()
    private Department department;

}