package com.reinext.rental.vo;

import java.util.List;

import com.reinext.rental.constants.MsgCode;
import com.reinext.rental.entity.LocalData;
import com.reinext.rental.entity.LocalRouteData;
import com.reinext.rental.entity.StationData;

public class Res {

//	private List<Req> req;
	
	private List<StationData> stationData;
	
	private List<LocalData> localData;
	
	private List<LocalRouteData> localRouteData;
	
	private List<String> str;
	
	private MsgCode msgCode;

	public Res() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Res(List<StationData> stationData, List<LocalData> localData, List<LocalRouteData> localRouteData,
			MsgCode msgCode) {
		super();
		this.stationData = stationData;
		this.localData = localData;
		this.localRouteData = localRouteData;
		this.msgCode = msgCode;
	}


	public Res(List<String> str, MsgCode msgCode) {
		super();
		this.str = str;
		this.msgCode = msgCode;
	}

	public List<StationData> getStationData() {
		return stationData;
	}

	public void setStationData(List<StationData> stationData) {
		this.stationData = stationData;
	}

	public List<LocalData> getLocalData() {
		return localData;
	}

	public void setLocalData(List<LocalData> localData) {
		this.localData = localData;
	}

	public List<LocalRouteData> getLocalRouteData() {
		return localRouteData;
	}

	public void setLocalRouteData(List<LocalRouteData> localRouteData) {
		this.localRouteData = localRouteData;
	}

	public MsgCode getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(MsgCode msgCode) {
		this.msgCode = msgCode;
	}

	public List<String> getStr() {
		return str;
	}

	public void setStr(List<String> str) {
		this.str = str;
	}


	
}