package com.reinext.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reinext.rental.entity.CommonEquipmentData;

import jakarta.transaction.Transactional;

@Repository
public interface CommonEquipmentDao extends JpaRepository<CommonEquipmentData, Integer>{

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO common_equipment_data (BU_ID , ELEVATOR , AUTO_LOCK , MAIL_BOX , DELIVERY_BOX , PARKING , CMEQ_NOTES)"+
			" VALUES (:buId , :elevator , :autoLock , :mailBox , :deliveryBox , :parking , :cmeqNotes)", nativeQuery = true)
			public int saveCmeq(
					@Param("buId") int buId,
					@Param("elevator") String elevator,
					@Param("autoLock") String autoLock,
					@Param("mailBox") String mailBox,
					@Param("deliveryBox") String deliveryBox,
					@Param("parking") String parking,
					@Param("cmeqNotes") String cmeqNotes
					);
}
