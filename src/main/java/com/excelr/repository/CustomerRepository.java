package com.excelr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{


	Customer findByPassword(String password);

	Customer findByEmail(String email);





}
