package com.reinext.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reinext.rental.entity.EquipmentData;

@Repository
public interface EquipmentDao extends JpaRepository<EquipmentData, Integer>{

}
