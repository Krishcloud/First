package com.cts.bikeapp2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.bikeapp2.entity.Bike;
import com.cts.bikeapp2.repository.BikeRepository;

@Service
public class BikeServiceImpl implements BikeService{
	
	@Autowired
	private BikeRepository bikeRepository;
	
	
	public List<Bike> getAllBikes(){
		return bikeRepository.findAll();
	}
	
	public Bike updateById(Bike bike,Long id){
		Bike originalBike = bikeRepository.findById(bike.getId()).get();
		originalBike.setBrand(bike.getBrand());
		originalBike.setCc(bike.getCc());
		originalBike.setModel(bike.getModel());
		originalBike.setPrice(bike.getPrice());
		
		return bikeRepository.save(originalBike);
	
	}
	public Bike createBike(Bike bike) {
		return bikeRepository.save(bike);
	}
	
	public void deleteById(Long id) {
		bikeRepository.deleteById(id);
		
	}
	
	/*
	 * public String getBikeDataFromExternalApi() { String url=
	 * "https://api.example.com/bikes"; return restTemplate.getForObject(url,
	 * String.class); }
	 */

}
