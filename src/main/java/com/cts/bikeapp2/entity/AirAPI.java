package com.cts.bikeapp2.entity;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class AirAPI {
	
	
	private String iata;
	private String icao;
	private Map<String, Integer> fleet;
	private String logo_url;
	private String name;
	
	
}
