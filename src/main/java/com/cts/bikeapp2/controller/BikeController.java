package com.cts.bikeapp2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.bikeapp2.entity.AirAPI;
import com.cts.bikeapp2.entity.Bike;
import com.cts.bikeapp2.entity.Bike3API;
import com.cts.bikeapp2.service.BikeService;
import com.cts.bikeapp2.service.ExternalBikeServiceImpl;


@RestController
@RequestMapping("/v1")
public class BikeController {
	
	@Autowired
    private BikeService bikeService;
	
	@Autowired
	private ExternalBikeServiceImpl externalBikeServiceImpl;

	@PostMapping("/create")
	public void saveBike(@RequestBody Bike b) {
		bikeService.createBike(b);
	}
	
	@GetMapping
	public Iterable<Bike>getAllBikes(){
		return bikeService.getAllBikes();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Long id) {
		bikeService.deleteById(id);
	}
	
	@PutMapping("/update/{id}")
	public void saveBike(@RequestBody Bike b,Long id) {
		bikeService.updateById(b,id);
	}
	
	
	
	/*
	 * @GetMapping("/external") public String getExternalBikeData() { return
	 * bikeService.getBikeDataFromExternalApi(); }
	 */
	/*
	 * @GetMapping("/external") public String getExternalBikeDetails() { String
	 * s=externalBikeServiceImpl.getBikeDetails(); return s; }
	 */
	
//	https://api.api-ninjas.com/v1/motorcycles?make=Kawasaki&model=Ninja

	
	@GetMapping("/motorcycles/make/{make}/model/{model}") //
	public List<Bike3API> getBikeDetails(@PathVariable String make, @PathVariable String model) {
		System.out.println("Requesting Bike brand and details for {}/{}"+ make + model);
		//String s=externalBikeServiceImpl.getBikeDetails(model);
		List<Bike3API> s=externalBikeServiceImpl.getBikeDetails(make, model);
		System.out.println(s.getClass());
		return s;
	}
	
	
	@GetMapping("/airlines/name/{name}")
	public List<AirAPI> getAirlines(@PathVariable String name) {
		List<AirAPI> s1=externalBikeServiceImpl.getAirlines(name);
		return s1;
	}
}

//Changes were started
