package com.ajaxdemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajaxdemo.model.country;

@Repository
public interface countryRepository extends JpaRepository<country, Integer>
{

}
