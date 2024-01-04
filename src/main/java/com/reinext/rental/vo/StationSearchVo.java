package com.reinext.rental.vo;

import java.util.List;

public class StationSearchVo {

	private String prefName;
	
	private List<String> lineName;

	public StationSearchVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StationSearchVo(String prefName, List<String> lineName) {
		super();
		this.prefName = prefName;
		this.lineName = lineName;
	}

	public String getPrefName() {
		return prefName;
	}

	public void setPrefName(String prefName) {
		this.prefName = prefName;
	}

	public List<String> getLineName() {
		return lineName;
	}

	public void setLineName(List<String> lineName) {
		this.lineName = lineName;
	}
	
	
}
