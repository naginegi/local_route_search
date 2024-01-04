package com.reinext.rental.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "room_data")
public class RoomData {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "ROOM_ID")
	private int roomId;
	
	@Column(name = "BU_ID")
	private int buId;

	@Column(name = "ROOM_NUM")
	private String roomNum;
	
	@Column(name = "ROOM_AREA")
	private String roomArea;
	
	@Column(name = "ROOM_LAYOUT")
	private String roomLayout;
	
	@Column(name = "LAST_UPDATED")
	private LocalDate lastUpdated;

	public RoomData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomData(int roomId, int buId, String roomNum, String roomArea, String roomLayout, LocalDate lastUpdated) {
		super();
		this.roomId = roomId;
		this.buId = buId;
		this.roomNum = roomNum;
		this.roomArea = roomArea;
		this.roomLayout = roomLayout;
		this.lastUpdated = lastUpdated;
	}


	public RoomData(int buId, String roomNum, String roomArea, String roomLayout) {
		super();
		this.buId = buId;
		this.roomNum = roomNum;
		this.roomArea = roomArea;
		this.roomLayout = roomLayout;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getBuId() {
		return buId;
	}

	public void setBuId(int buId) {
		this.buId = buId;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public String getRoomArea() {
		return roomArea;
	}

	public void setRoomArea(String roomArea) {
		this.roomArea = roomArea;
	}

	public String getRoomLayout() {
		return roomLayout;
	}

	public void setRoomLayout(String roomLayout) {
		this.roomLayout = roomLayout;
	}

	public LocalDate getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDate lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
}
