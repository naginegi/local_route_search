package com.reinext.rental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reinext.rental.entity.StationData;

import jakarta.transaction.Transactional;

@Repository
public interface StationDataDao extends JpaRepository<StationData, Integer>{

	
	@Query(value = "select * from station_data s where s.PREF_NAME = :pref_name", nativeQuery = true)
	public List<StationData> selectLine(@Param("pref_name")String prefName);
	
	@Query(value = "select * from station_data s where s.LINE_NAME IN :line_name", nativeQuery = true)
	public List<StationData> selectStation(@Param("line_name")List<String> lineName);
	
	@Query(value = "select DISTINCT s.LINE_NAME from station_data s where s.PREF_NAME = :pref_name", nativeQuery = true)
	public List<String> prefRoute(@Param("pref_name")String prefName);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO station_data VALUES (0,:pref_name,:station_name,:line_name)", nativeQuery = true)
	public void createStation(
			@Param("pref_name")String prefName,
			@Param("station_name")String stationName,
			@Param("line_name")String lineName);
	
	public boolean existsByStationNameAndLineName(String stationName,String lineName);
}
