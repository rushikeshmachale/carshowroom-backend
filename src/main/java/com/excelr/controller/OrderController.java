package com.excelr.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import com.excelr.entity.Orders;
import com.excelr.repository.OrderRepository;
import com.excelr.service.EmailService;

import jakarta.persistence.criteria.Order;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrderController {
	

	@Autowired
	OrderRepository repo;
	

	@Autowired 
	EmailService emailService;
	
	@PostMapping("/add")
	public Orders addOrder(@RequestBody Orders orders) {
	
		return repo.save(orders);
	}
	
	@GetMapping("/get")
	public List<Orders> getall(){
		return repo.findAll();
	}

	@GetMapping("/find/{customerId}")
	public List<Orders> getall(@PathVariable int customerId){
		List<Orders> o=null;
		if(repo.existsByCustomerId(customerId)) {
			o=repo.findByCustomerId(customerId);
		}
		return o;
	}
	@GetMapping("/findorder/{orderId}")
	public Optional<Orders> getOrder(@PathVariable int orderId) {
		Optional<Orders> o=null;
		if(repo.existsByOrderId(orderId)) {
			o= repo.findByOrderId(orderId);
		}else {
			System.out.println("order not found");
		}
		return o;
	}
	
	@PutMapping("/update/{orderId}")
	public Orders updateOrder(@RequestBody Orders orders,@PathVariable int orderId) {
		Orders o = new Orders();
		if(repo.existsByOrderId(orderId)) {
			o.setNumbers(repo.getByOrderId(orders.getOrderId()).getNumbers());
			o.setName(orders.getName());
			o.setCustomerId(orders.getCustomerId());
			o.setColor(orders.getColor());
			o.setModelNo(orders.getModelNo());
			o.setOrderId(orderId);
			o.setPrice(orders.getPrice());
			o.setStatus(orders.getStatus());
			o.setDate(orders.getDate());
			o.setUrl(orders.getUrl());
			repo.save(o);
		}
		return o;
	}
	
	
	
	@PostMapping("/mail")
	public String sendMail() {
				int num = (int) Math.floor(Math.random()*1000000);
				
				emailService.sendMessaeg("tatabye0909@gmail.com","Hello user...",""
						+ "Welcome to our online car showroom mart,"
						+ "You make succefull order. You can track your order status by visiting our website."
						+ "Thank you. "
						+ " Please visit us again... "+num);
				return "email sended";
			}
}
