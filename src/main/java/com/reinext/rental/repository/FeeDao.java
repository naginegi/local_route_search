package com.reinext.rental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reinext.rental.entity.FeeData;

@Repository
public interface FeeDao extends JpaRepository<FeeData, Integer>{

	public List<FeeData> findAllByBuId(int buId);
}
