package com.ideas2it.collegemanagement.dao;

import com.ideas2it.collegemanagement.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Integer>{
	
	@Query(value = "select count(id) from department", nativeQuery = true)
    Long getDepartmentCount();
}
