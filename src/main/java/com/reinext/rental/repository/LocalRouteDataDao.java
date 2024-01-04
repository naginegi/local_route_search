package com.reinext.rental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reinext.rental.entity.LocalRouteData;

import jakarta.transaction.Transactional;

@Repository
public interface LocalRouteDataDao extends JpaRepository<LocalRouteData, Integer>{

	@Query(value = "select DISTINCT l.LINE_NAME from local_route_data l where  l.ADDRESS like %:local_name%", nativeQuery = true)
	public List<String> localRoute(@Param("local_name")String localName);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO local_route_data VALUES (0,:station_name,:address,:line_name)", nativeQuery = true)
	public void createRoute(
			@Param("station_name")String stationlName,
			@Param("address")String address,
			@Param("line_name")String lineName);
	
	public boolean existsByAddress(String address);
}
