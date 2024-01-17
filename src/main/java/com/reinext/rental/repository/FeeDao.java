package com.reinext.rental.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reinext.rental.entity.FeeData;

import jakarta.transaction.Transactional;

@Repository
public interface FeeDao extends JpaRepository<FeeData, Integer>{

	public List<FeeData> findAllByBuId(int buId);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO fee_data (BU_ID , ROOM_NUM , RENT , DEPOSIT , REWARD , COMMON_EXPENSES , RENEWAL , OTHER_EXPENSES , FEE_NOTES)"+
			" VALUES (:buId , :roomNum , :rent , :deposit , :reward , :commonExpenses , :renewal , :otherExpenses , :feeNotes)", nativeQuery = true)
			public int saveFee(
					@Param("buId") int buId,
					@Param("roomNum") String roomNum,
					@Param("rent") String rent,
					@Param("deposit") String deposit,
					@Param("reward") String reward,					
					@Param("commonExpenses") String commonExpenses,
					@Param("renewal") String renewal,
					@Param("otherExpenses") String otherExpenses,
					@Param("feeNotes") String feeNotes
					);
}
