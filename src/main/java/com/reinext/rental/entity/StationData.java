package com.reinext.rental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "station_data")
public class StationData {

	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name = "PREF_NAME")
	private String prefName;
	
	@Column(name = "STATION_NAME")
	private String stationName;
	
	@Column(name = "LINE_NAME")
	private String lineName;

	public StationData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StationData(int id, String prefName, String stationName, String lineName) {
		super();
		this.id = id;
		this.prefName = prefName;
		this.stationName = stationName;
		this.lineName = lineName;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrefName() {
		return prefName;
	}

	public void setPrefName(String prefName) {
		this.prefName = prefName;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	
	
}
