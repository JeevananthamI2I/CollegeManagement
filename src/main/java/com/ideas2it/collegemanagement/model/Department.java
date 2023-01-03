package com.ideas2it.collegemanagement.model;

import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * <p>
 * The College class have attributes. This class contain getter and setter
 * method for department attributes
 * </p>
 *
 * @author jeevanantham
 * @version 1.0 22 SEP 2022
 */

@SQLDelete(sql = "UPDATE departments SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted = false")
@Entity
@Getter
@Setter
public class Department extends BaseModel {
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "code", unique = true, nullable = false)
	private String code;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Student> students;

    @ManyToMany(mappedBy = "departments",cascade = CascadeType.ALL)
	private List<College> colleges;

}




















//@ManyToMany(cascade = CascadeType.ALL)
//@JoinTable(name = "colleges_departments",
//joinColumns = {@JoinColumn(name = "department_id" ,nullable = false, updatable = false)},
//inverseJoinColumns = {@JoinColumn(name = "college_id",nullable = false, updatable = false)})

//@ManyToMany(mappedBy = "departments", fetch = FetchType.LAZY)
//private List<College> colleges;