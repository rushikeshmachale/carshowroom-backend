package com.excelr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{

	Car findByModelNo(String modelNo);

}
