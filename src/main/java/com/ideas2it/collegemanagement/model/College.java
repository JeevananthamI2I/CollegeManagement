package com.ideas2it.collegemanagement.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.ideas2it.collegemanagement.util.enumeration.Type;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * <p>
 * The College class have attributes.
 * This class contain getter and setter method for College attributes
 * </p>
 *
 * @author jeevanantham
 * @version 1.0  10 AUG 2022
 */

@Entity
@Getter
@Setter
@SQLDelete(sql = "UPDATE College SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted = false")
public class College extends BaseModel {

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "university", nullable = false)
	private String university;

	@Column(name = "grade", nullable = false)
	private String rank;

	@Column(name = "place", nullable = false)
	private String place;

	@Column(name = "inauguration_date", nullable = false)
	private Date inaugurationDate;

	@Column(name = "type", nullable = false)
	private Type type;

	@Column(name = "code", nullable = false, unique = true)
	private String code;

	@ManyToMany()
	@JoinTable(name = "colleges_departments",
			joinColumns = @JoinColumn(name = "college_id"),
			inverseJoinColumns = @JoinColumn(name = "department_id"))
	private List<Department> departments;
}























