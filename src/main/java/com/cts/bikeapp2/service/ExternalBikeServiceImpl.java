package com.cts.bikeapp2.service;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.bikeapp2.entity.AirAPI;
import com.cts.bikeapp2.entity.Bike3API;

@Service
public class ExternalBikeServiceImpl implements ExternalBikeService {


	@Autowired
	private RestTemplate restTemplate;
	
	
	@Value("${BIKEBRAND_URL}")
	private String BIKEBRAND_URL;
	
	@Value("${AIRLINES_URL}")
	private String AIRLINES_URL;
	
	@Value("${apiKey}")
	private String apikey;
	
	
	public List<Bike3API> getBikeDetails(String make, String model) {
		String url = MessageFormat.format(BIKEBRAND_URL, make, model);
		System.out.println(url);
		   HttpHeaders headers = new HttpHeaders();
		   headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		   headers.add("x-api-key", apikey);

		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		ResponseEntity<Bike3API[]> s= restTemplate.exchange(url, HttpMethod.GET, entity, Bike3API[].class);
		
		return Arrays.asList(s.getBody());
		//return s.getBody();
	}
	
	public List<Bike3API> getBikeDetails2(String make, String model) {
		String url = MessageFormat.format(BIKEBRAND_URL, make, model);
		System.out.println(url);
		   HttpHeaders headers = new HttpHeaders();
		   headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		   headers.add("x-api-key", apikey);

		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		ResponseEntity<Bike3API[]> s2= restTemplate.exchange(url, HttpMethod.GET, entity, Bike3API[].class);
		
		//return s2.getBody();
		return Arrays.asList(s2.getBody());
		
	}
	
	public List<AirAPI> getAirlines(String name) {
		String url = MessageFormat.format(AIRLINES_URL, name);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("x-api-key", apikey);  
		
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<AirAPI[]> s1 = restTemplate.exchange(url, HttpMethod.GET, entity, AirAPI[].class);
		return Arrays.asList(s1.getBody());
		//return s1.getBody();
	}

}