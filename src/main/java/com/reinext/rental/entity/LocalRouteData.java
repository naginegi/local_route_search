package com.reinext.rental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "local_route_data")
public class LocalRouteData {

	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name = "STARTION_NAME")
	private String stationName;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "LINE_NAME")
	private String lineName;

	public LocalRouteData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocalRouteData(int id, String stationName, String address, String lineName) {
		super();
		this.id = id;
		this.stationName = stationName;
		this.address = address;
		this.lineName = lineName;
	}

	public LocalRouteData(String stationName, String address, String lineName) {
		super();
		this.stationName = stationName;
		this.address = address;
		this.lineName = lineName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	
	
}
