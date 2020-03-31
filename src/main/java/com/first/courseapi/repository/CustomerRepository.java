package com.first.courseapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.first.courseapi.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	/*
	@Query("SELECT n FROM Customer n WHERE n.customername LIKE %:pattern%")
	List<Customer> searchByPatternLike(@Param("pattern") String pattern);
	*/
	
	List<Customer> findByCustomernameContainingIgnoreCase(String pattern);
	
	Customer findByCustomernameContainingIgnoreCaseAndCustomerid(String changedname,int cusid);
	
   // List<Customer> findByCustomername(String name);
    @Modifying
    @Query("update Customer set customername = :lastname where customerid = :cusid and customername = :name")
    int updateCustomerName (@Param("name") String name, @Param("cusid") int id, @Param("lastname") String lastname);
    
    List<Customer> findAll();
	
}
