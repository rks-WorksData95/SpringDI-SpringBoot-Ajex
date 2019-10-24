package com.ajaxdemo.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ajaxdemo.model.city;

@Repository
public interface cityRepository extends JpaRepository<city, Integer>
{
	@Query("Select s from city s where country.id= :id")
	List<city> findAllById(@Param("id") int id);
	
}
