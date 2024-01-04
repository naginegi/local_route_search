package com.reinext.rental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reinext.rental.entity.LocalData;

import jakarta.transaction.Transactional;

@Repository
public interface LocalDataDao extends JpaRepository<LocalData, Integer>{

	@Query(value = "select * from local_data l where l.PREF_NAME = :pref_name AND l.LOCAL_NAME != ''", nativeQuery = true)
	public List<LocalData> selectLocal(@Param("pref_name")String prefName);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO local_data VALUES (0,:pref_name,:local_name)", nativeQuery = true)
	public void createLocal(@Param("pref_name")String prefName
			,@Param("local_name")String localName);
	
	
	@Query(value = "select distinct l.PREF_NAME from local_data l" , nativeQuery = true)
	public List<String> getPref();
	
	@Query(value = "select distinct l.LOCAL_NAME from local_data l" , nativeQuery = true)
	public List<String> getLocal();

	@Query(value = "select * from local_data where local_data.LOCAL_NAME != ''" , nativeQuery = true)
	public List<LocalData> getLocalDataTables();
	
	public boolean existsByPrefNameAndLocalName(String prefName,String localName);
//	public boolean existsByLocalName(String localName);

}
