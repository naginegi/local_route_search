package com.reinext.rental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "near_data")
public class NearData {
	
	//AI
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "ID")
	private int id;

	//��BuildingData��buildingId
	@Column(name = "BU_ID")
	private int buId;

	//������񪺸��u
	@Column(name = "NEAR_LINE")
	private String nearLine;
	
	//������񪺨��� A;B;C....
	@Column(name = "NEAR_STATION")
	private String nearStation;

	//�{�B�ɶ�  5;10;20...
	@Column(name = "WARKING_TIME")
	private String warkingTime;

	public NearData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NearData(int id, int buId, String nearLine, String nearStation, String warkingTime) {
		super();
		this.id = id;
		this.buId = buId;
		this.nearLine = nearLine;
		this.nearStation = nearStation;
		this.warkingTime = warkingTime;
	}



	public NearData(String nearLine, String nearStation, String warkingTime) {
		super();
		this.nearLine = nearLine;
		this.nearStation = nearStation;
		this.warkingTime = warkingTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBuId() {
		return buId;
	}

	public void setBuId(int buId) {
		this.buId = buId;
	}

	public String getNearLine() {
		return nearLine;
	}

	public void setNearLine(String nearLine) {
		this.nearLine = nearLine;
	}

	public String getNearStation() {
		return nearStation;
	}

	public void setNearStation(String nearStation) {
		this.nearStation = nearStation;
	}

	public String getWarkingTime() {
		return warkingTime;
	}

	public void setWarkingTime(String warkingTime) {
		this.warkingTime = warkingTime;
	}
	
	

}
