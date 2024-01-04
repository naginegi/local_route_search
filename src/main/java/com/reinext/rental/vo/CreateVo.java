package com.reinext.rental.vo;

public class CreateVo {
	
	private String prefName;

	private String localName;
	
	private String stationName;
	
	private String address;
	
	private String lineName;

	public CreateVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateVo(String prefName, String localName, String stationName, String address, String lineName) {
		super();
		this.prefName = prefName;
		this.localName = localName;
		this.stationName = stationName;
		this.address = address;
		this.lineName = lineName;
	}

	public String getPrefName() {
		return prefName;
	}

	public void setPrefName(String prefName) {
		this.prefName = prefName;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
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
