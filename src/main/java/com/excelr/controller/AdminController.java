package com.excelr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.excelr.entity.Admin;
import com.excelr.repository.AdminRepository;

@RestController
@RequestMapping("/car/admin")
@CrossOrigin
public class AdminController {

	@Autowired 
	AdminRepository repo;
	
	@PostMapping("/add")
	public ResponseEntity<String> addAdmin(@RequestBody Admin admin){
		if(repo.findByEmail(admin.getEmail()) != null) {
			return new ResponseEntity<String>("admin already exists",HttpStatus.BAD_REQUEST);
		}else {
			repo.save(admin);
			return new ResponseEntity<String>("admin added success...",HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/get")
	public List<Admin>getALladmin(){
		return repo.findAll();
	}
	@GetMapping("/find/{email}")
	public String Adminbyemail(@PathVariable String email) {
		if(repo.findByEmail(email) != null) {
			return "admin found";
		}
		return "admin not found";
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Admin admin) {
		if(repo.findByEmail(admin.getEmail())!=null) {
			if(admin.getPassword().equals(repo.findByEmail(admin.getEmail()).getPassword())) {
				return new ResponseEntity<String>("login success",HttpStatus.OK);
			}else {
				return new ResponseEntity<String>("login failure",HttpStatus.BAD_REQUEST);
			}
		}
			return new ResponseEntity<String>("admin not found",HttpStatus.BAD_REQUEST);
	}
}
