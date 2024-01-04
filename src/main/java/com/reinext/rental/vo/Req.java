package com.reinext.rental.vo;

import com.reinext.rental.entity.LocalData;
import com.reinext.rental.entity.LocalRouteData;
import com.reinext.rental.entity.StationData;

public class Req {

	private LocalData localData;
	
	private LocalRouteData localRouteData;

	private StationData stationData;

	public Req() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Req(LocalData localData, LocalRouteData localRouteData, StationData stationData) {
		super();
		this.localData = localData;
		this.localRouteData = localRouteData;
		this.stationData = stationData;
	}
	public Req(LocalData localData) {
		super();
		this.localData = localData;
	}

	public LocalData getLocalData() {
		return localData;
	}

	public void setLocalData(LocalData localData) {
		this.localData = localData;
	}

	public LocalRouteData getLocalRouteData() {
		return localRouteData;
	}

	public void setLocalRouteData(LocalRouteData localRouteData) {
		this.localRouteData = localRouteData;
	}

	public StationData getStationData() {
		return stationData;
	}

	public void setStationData(StationData stationData) {
		this.stationData = stationData;
	}
	
	
}
