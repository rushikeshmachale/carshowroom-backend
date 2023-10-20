package com.excelr.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.excelr.entity.Car;
import com.excelr.repository.CarRepository;

import jakarta.persistence.Id;

@RestController
@RequestMapping("/car")
@CrossOrigin("http://localhost:3000")
public class CarController {

	@Autowired 
	CarRepository repo;
	@PostMapping("/add")
	public String addCar(@RequestBody Car car) {
		if(repo.existsById(car.getId())) {
			return "car already exists";
		}else {
			repo.save(car);
			return "car added..";
					
		}
	}
	
	@GetMapping("/get")
	public List<Car> getAllCars(){
		return repo.findAll();
	}
	
	@GetMapping("/find/{id}")
	public Optional<Car> getbyid(@PathVariable int id) {
		if(repo.findById(id)!=null) {
			return repo.findById(id);
		}
		return null;
	}
	
	@PutMapping("/update/{modelNo}")
	public ResponseEntity<String> updateCar(@RequestBody Car car,@PathVariable String modelNo){
		Car c=new Car();
		if(repo.findByModelNo(modelNo)!=null) {
			c.setId(car.getId());
			c.setName(car.getName());
			c.setEngine(car.getEngine());
			c.setUrl(car.getUrl());
			c.setColor(car.getColor());
			c.setModelNo(modelNo);
			c.setPrice(car.getPrice());
			c.setRatings(car.getRatings());
			c.setProdyear(car.getProdyear());
			c.setUrl(car.getUrl());
			repo.save(c);
			return new ResponseEntity<String>("Car data updated success...",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Car not found...",HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findmodel/{modelNo}")
	public Car findModel(@PathVariable String modelNo) {
		if(repo.findByModelNo(modelNo)!=null) {
			return repo.findByModelNo(modelNo);
		}else {
			return null;
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCar(@PathVariable int id){
		if(repo.findById(id)!=null) {
			repo.deleteById(id);
			return new ResponseEntity<String>("deleted",HttpStatus.OK);
		}
		return new ResponseEntity<String>("car not found",HttpStatus.BAD_REQUEST);
	}
}
