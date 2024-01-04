package com.reinext.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reinext.rental.entity.BuildingData;

@Repository
public interface BuildingDao extends JpaRepository<BuildingData, Integer>{

}
