package com.reinext.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reinext.rental.entity.BorrowerData;

@Repository
public interface BorrowerDao extends JpaRepository<BorrowerData, Integer>{

}
