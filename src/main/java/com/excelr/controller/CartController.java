package com.excelr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.entity.Cart;
import com.excelr.repository.CartRepository;

@RestController
@RequestMapping("/cart")
@CrossOrigin("https://carshowrooms.netlify.app")
public class CartController {

	@Autowired
	CartRepository repo;
	
	@GetMapping("/get")
	public List<Cart> getALl(){
		return repo.findAll();
	}
	@PostMapping("/add")
	public ResponseEntity<String> addCart(@RequestBody Cart cart) {
		
		repo.save(cart);
		return new ResponseEntity<String>("Cart added success",HttpStatus.OK);
	}
	
	@GetMapping("/find/{customerId}")
	public List<Cart> findCartByCustid(@PathVariable int customerId) {
		List<Cart> c=null;
		if(repo.findByCustomerId(customerId)!=null) {
			c=repo.findByCustomerId(customerId);
			return c;
		}
		return c;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCartE(@PathVariable int id){
			repo.deleteById(id);
			return new ResponseEntity<String>("deleted cart item",HttpStatus.OK);
	}
}
