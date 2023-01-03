package com.ideas2it.collegemanagement.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * <p>
 * The College class have attributes. This class contain getter and setter
 * method for college attributes
 * </p>
 *
 * @author jeevanantham
 * @version 1.0 10 AUG 2022
 */

@MappedSuperclass
@Getter
@Setter
public class BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "is_deleted", columnDefinition = "tinyint(1) default false", nullable = false)
	private boolean isDeleted;

	@CreationTimestamp
	@Column(name = "create_at" ,nullable = false, updatable = false)
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name = "updated_at" ,nullable = false, updatable = false)
	private Date updatedAt;

}
