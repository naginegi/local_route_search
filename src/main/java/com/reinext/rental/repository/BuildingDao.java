package com.reinext.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reinext.rental.entity.BuildingData;

import jakarta.transaction.Transactional;

@Repository
public interface BuildingDao extends JpaRepository<BuildingData, Integer>{

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO building_data (BU_NAME , BU_TYPE , BU_YEAR , BU_MATERIALS , BU_PREF , BU_LOCAL , BU_ADDRESS , BU_NOTES)"+
	"VALUES (:buName , :buType , :buYear , :buMaterials , :buPref , :buLocal , :buAddress , :buNotes)", nativeQuery = true)
	public int saveBuilding(
			@Param("buName") String buName,
			@Param("buType") String buType,
			@Param("buYear") String buYear,
			@Param("buMaterials") String buMaterials,
			@Param("buPref") String buPref,
			@Param("buLocal") String buLocal,
			@Param("buAddress") String buAddress,
			@Param("buNotes") String buNotes
			);
	
	@Query(value = "SELECT b.BU_ID FROM building_data b ORDER BY BU_ID DESC LIMIT 1 ", nativeQuery = true)
	public int findBuId();
}
