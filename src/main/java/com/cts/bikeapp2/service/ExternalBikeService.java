package com.cts.bikeapp2.service;

import java.util.List;

import com.cts.bikeapp2.entity.AirAPI;
import com.cts.bikeapp2.entity.Bike3API;

public interface ExternalBikeService {

	public List<Bike3API> getBikeDetails(String make, String model);
	
	public List<Bike3API> getBikeDetails2(String make, String model);

	public List<AirAPI> getAirlines(String name);

//	public String getBikeDetails(String make, String model);
//
//	public String getBikeDetails2(String make, String model);
//
//	public String getAirlines(String name);

}
