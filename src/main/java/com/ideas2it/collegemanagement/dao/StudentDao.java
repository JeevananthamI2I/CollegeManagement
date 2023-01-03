package com.ideas2it.collegemanagement.dao;

import com.ideas2it.collegemanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {

	@Query(value = "select count(id) from student", nativeQuery = true)
    Long getStudentCount();
}
