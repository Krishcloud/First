package com.cts.bikeapp2.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bike {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String brand;
	private double price;
	private Long cc;
	private String model;
	
	public Bike() {
		
	}
	public Bike(Long id,String brand, double price, Long cc, String model) {
		this.brand = brand;
		this.price = price;
		this.cc = cc;
		this.model = model;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getCc() {
		return cc;
	}
	public void setCc(Long cc) {
		this.cc = cc;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
}
