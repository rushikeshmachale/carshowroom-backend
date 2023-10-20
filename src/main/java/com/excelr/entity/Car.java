package com.excelr.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.excelr.repository.CarRepository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Car {

	@Id
	private int id;
	private String name;
	private String color;
	private String modelNo;
	private String engine;
	private String prodyear;
	private double price;
	private String ratings;
	private String url;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getModelNo() {
		return modelNo;
	}
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public String getProdyear() {
		return prodyear;
	}
	public void setProdyear(String prodyear) {
		this.prodyear = prodyear;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getRatings() {
		return ratings;
	}
	public void setRatings(String ratings) {
		this.ratings = ratings;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Car(int id, String name, String color, String modelNo, String engine, String prodyear, double price,
			String ratings, String url) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.modelNo = modelNo;
		this.engine = engine;
		this.prodyear = prodyear;
		this.price = price;
		this.ratings = ratings;
		this.url = url;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
