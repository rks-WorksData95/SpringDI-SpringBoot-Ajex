package com.SpringCrudPostman.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.SpringCrudPostman.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>
{
	
}
