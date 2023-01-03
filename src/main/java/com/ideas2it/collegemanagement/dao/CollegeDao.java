package com.ideas2it.collegemanagement.dao;

import java.util.Date;
import java.util.List;

import com.ideas2it.collegemanagement.model.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeDao extends JpaRepository<College, Integer> {
		
	@Query(value = "select count(id) from college" , nativeQuery = true)
    Long getCollegesCount();
	
	@Query("select c from College c where c.name like %:keyword% or c.name like %:keyword% or c.university like %:keyword%")
    List<College> searchProduct(@Param("keyword") String value);

    List<College> findByInaugurationDateBetween(Date startDate, Date endDate);

    List<College> findByIdIn(List<Integer> ids);

}
