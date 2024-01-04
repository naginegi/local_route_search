package com.reinext.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reinext.rental.entity.ManagerData;

@Repository
public interface ManagerDao extends JpaRepository<ManagerData, Integer>{

}
