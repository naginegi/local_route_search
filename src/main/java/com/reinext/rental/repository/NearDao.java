package com.reinext.rental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reinext.rental.entity.NearData;

@Repository
public interface NearDao extends JpaRepository<NearData, Integer>{
	
	@Query(value = "select * from near_data where BU_ID = :buId", nativeQuery = true)
	public List<NearData> getByBuId(@Param("buId")int buId);
	
	@Query(value = "delete from near_data where BU_ID = :buId", nativeQuery = true)
	public void deleByBuId(@Param("buId")int buId);
	
	public void deleteByBuId(int buid);
	
	public List<NearData> findAllByBuId(int buId);
	
	
}
