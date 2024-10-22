package com.cts.bikeapp2.service;

import java.util.List;

import com.cts.bikeapp2.entity.Bike;

public interface BikeService {
	
	public List<Bike> getAllBikes();
	
	public Bike updateById(Bike bike,Long id);
	public Bike createBike(Bike bike);
	public void deleteById(Long id);
	//public String getBikeDataFromExternalApi();



}
