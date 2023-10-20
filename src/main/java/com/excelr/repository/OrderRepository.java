package com.excelr.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{

	Optional<Orders> findByOrderId(int orderId);

	List<Orders> findByCustomerId(int customerId);

	boolean existsByOrderId(int orderId);

	Orders getByOrderId(int orderId);

	boolean existsByCustomerId(int customerId);

	
}
