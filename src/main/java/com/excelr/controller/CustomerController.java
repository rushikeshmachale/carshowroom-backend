package com.excelr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import com.excelr.entity.Customer;
import com.excelr.repository.CustomerRepository;

@RestController
@RequestMapping("/car/customer")
@CrossOrigin
public class CustomerController {

	@Autowired
	CustomerRepository repo;
	
	@PostMapping("/add")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
		
		if(repo.findByEmail(customer.getEmail()) != null) {
			return new ResponseEntity<String>("Customer already exists",HttpStatus.BAD_REQUEST);
		}else {
			repo.save(customer);
			return new ResponseEntity<String>("Customer added success",HttpStatus.OK);
		}
	}
	
	@GetMapping("/get")
	public List<Customer> getCustomers(){
		return repo.findAll();
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Customer customer){
		if(repo.findByEmail(customer.getEmail())!=null) {
			if(customer.getPassword().equals(repo.findByEmail(customer.getEmail()).getPassword())) {
			return new ResponseEntity<String>("login success",HttpStatus.OK);
			}
		}
		return new ResponseEntity<String>("error",HttpStatus.BAD_REQUEST);

	}
	@DeleteMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable int id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return "customer deleted success..";
		}else {
			return "customer not found";
		}
	}
	
	@GetMapping("/find/{email}")
	public Customer getCustomer(@PathVariable String email) {
		return repo.findByEmail(email);
	}
}
