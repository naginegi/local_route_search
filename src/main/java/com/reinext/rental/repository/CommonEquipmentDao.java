package com.reinext.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reinext.rental.entity.CommonEquipmentData;

@Repository
public interface CommonEquipmentDao extends JpaRepository<CommonEquipmentData, Integer>{

}
