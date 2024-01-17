package com.reinext.rental.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reinext.rental.entity.RoomData;

import jakarta.transaction.Transactional;

@Repository
public interface RoomDao extends JpaRepository<RoomData, Integer>{

	public List<RoomData> findAllByBuId(int buId);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO room_data (BU_ID , ROOM_NUM , ROOM_AREA , ROOM_LAYOUT , LAST_UPDATED)"+
			" VALUES (:buId , :roomNum , :roomArea , :roomLayout , :lastUpdated)", nativeQuery = true)
			public int saveRoom(
					@Param("buId") int buId,
					@Param("roomNum") String roomNum,
					@Param("roomArea") String roomArea,
					@Param("roomLayout") String roomLayout,
					@Param("lastUpdated") LocalDate lastUpdated
					);
}
