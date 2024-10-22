package com.cts.bikeapp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.bikeapp2.entity.Bike;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long>{

}
