package com.reinext.rental.vo;

import java.util.List;

import com.reinext.rental.entity.BuildingData;
import com.reinext.rental.entity.CommonEquipmentData;
import com.reinext.rental.entity.EquipmentData;
import com.reinext.rental.entity.FeeData;
import com.reinext.rental.entity.LessorData;
import com.reinext.rental.entity.ManagerData;
import com.reinext.rental.entity.NearData;
import com.reinext.rental.entity.RoomData;
import com.reinext.rental.repository.ManagerDao;
import com.reinext.rental.repository.RoomDao;

public class ObjectReq {
	
	private BuildingData buildingData;
	
	private CommonEquipmentData commonEquipmentData;

	private List<NearData> nearList;
	
	private List<ObjRoomDataVo> roomDataVo;
	
//	private LessorData lessorDatal;
	
//	private ManagerData managerData;
	

	public ObjectReq() {
		super();
		// TODO Auto-generated constructor stub
	}

public ObjectReq(BuildingData buildingData, CommonEquipmentData commonEquipmentData, List<NearData> nearList,
		List<ObjRoomDataVo> roomDataVo) {
	super();
	this.buildingData = buildingData;
	this.commonEquipmentData = commonEquipmentData;
	this.nearList = nearList;
	this.roomDataVo = roomDataVo;
}

public BuildingData getBuildingData() {
	return buildingData;
}

public void setBuildingData(BuildingData buildingData) {
	this.buildingData = buildingData;
}

public CommonEquipmentData getCommonEquipmentData() {
	return commonEquipmentData;
}

public void setCommonEquipmentData(CommonEquipmentData commonEquipmentData) {
	this.commonEquipmentData = commonEquipmentData;
}

public List<NearData> getNearList() {
	return nearList;
}

public void setNearList(List<NearData> nearList) {
	this.nearList = nearList;
}

public List<ObjRoomDataVo> getRoomDataVo() {
	return roomDataVo;
}

public void setRoomDataVo(List<ObjRoomDataVo> roomDataVo) {
	this.roomDataVo = roomDataVo;
}

	
}
