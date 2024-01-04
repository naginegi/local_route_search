package com.reinext.rental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reinext.rental.entity.RoomData;

@Repository
public interface RoomDao extends JpaRepository<RoomData, Integer>{

	public List<RoomData> findAllByBuId(int buId);
}
