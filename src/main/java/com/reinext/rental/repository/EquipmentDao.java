package com.reinext.rental.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reinext.rental.entity.EquipmentData;

import jakarta.transaction.Transactional;

@Repository
public interface EquipmentDao extends JpaRepository<EquipmentData, Integer>{

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO equipment_data (BU_ID , ROOM_NUM , ELECTRIC , GAS , STOVE , WATERWORKS , SEWAGE , KITCHEN , TOI_BATH , WASHING_MACHINE , WATER_HEATER , AIR_CONDITIONER , LIGHT , INTERNET , TRUNK_ROOM , ROOF_BALCONY , TV , CATV , YARD , FURNITURE)"+
			" VALUES (:buId , :roomNum , :electric , :gas , :stove , :waterWorks , :sewage , :kitchen , :toiBath , "
			+":washingMachine , :waterHeater , :airConditioner , :light , :internet , "
			+":trunkRoom , :roofBalcony  , :tv , :catv , :yard , :furniture)", nativeQuery = true)
			public int saveEquipment(
					@Param("buId") int buId,
					@Param("roomNum") String roomNum,
					@Param("electric") String electric,
					@Param("gas") String gas,
					@Param("stove") String stove,
					@Param("waterWorks") String waterWorks,
					@Param("sewage") String sewage,
					@Param("kitchen") String kitchen,
					@Param("toiBath") String toiBath,
					@Param("washingMachine") String washingMachine,
					@Param("waterHeater") String waterHeater,
					@Param("airConditioner") String airConditioner,
					@Param("light") String light,
					@Param("internet") String internet,
					@Param("trunkRoom") String trunkRoom,
					@Param("roofBalcony") String roofBalcony,
					@Param("tv") String tv,
					@Param("catv") String catv,
					@Param("yard") String yard,
					@Param("furniture") String furniture
					);
}
