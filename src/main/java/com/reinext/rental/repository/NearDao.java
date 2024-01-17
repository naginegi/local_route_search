package com.reinext.rental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reinext.rental.entity.NearData;

import jakarta.transaction.Transactional;

@Repository
public interface NearDao extends JpaRepository<NearData, Integer>{
	
	@Query(value = "select * from near_data where BU_ID = :buId", nativeQuery = true)
	public List<NearData> getByBuId(@Param("buId")int buId);
	
	@Query(value = "delete from near_data where BU_ID = :buId", nativeQuery = true)
	public void deleByBuId(@Param("buId")int buId);
	
	public void deleteByBuId(int buid);
	
	public List<NearData> findAllByBuId(int buId);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO near_data (BU_ID , NEAR_LINE , NEAR_STATION , WARKING_TIME)"+
			" VALUES (:buId , :nearLine , :nearStation , :warkingTime)", nativeQuery = true)
			public int saveNear(
					@Param("buId") int buId,
					@Param("nearLine") String nearLine,
					@Param("nearStation") String nearStation,
					@Param("warkingTime") String warkingTime
					);
	
	
}
