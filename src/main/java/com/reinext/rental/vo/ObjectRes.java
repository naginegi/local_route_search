package com.reinext.rental.vo;

import java.util.List;

import com.reinext.rental.constants.MsgCode;
import com.reinext.rental.entity.BuildingData;
import com.reinext.rental.entity.CommonEquipmentData;
import com.reinext.rental.entity.EquipmentData;
import com.reinext.rental.entity.FeeData;
import com.reinext.rental.entity.NearData;
import com.reinext.rental.entity.RoomData;

public class ObjectRes {

//	private ObjectReq odjectReq;
	
	private BuildingData buildingData;
	
	private List<BuildingData> buildingList;
	
	private CommonEquipmentData commonEquipmentData;
	
	private List<NearData> nearList;
	
	private RoomData roomData;
	
	private List<RoomData> roomList;
	
	private EquipmentData equipmentData;
	
	private FeeData feeData;
	
	private List<FeeData> feeList;
	
	private MsgCode	msgCode;

	public ObjectRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ObjectRes(List<BuildingData> buildingList, MsgCode msgCode) {
		super();
		this.buildingList = buildingList;
		this.msgCode = msgCode;
	}

	

	public ObjectRes(MsgCode msgCode) {
		super();
		this.msgCode = msgCode;
	}

	public ObjectRes(BuildingData buildingData, CommonEquipmentData commonEquipmentData, List<NearData> nearList,
			List<RoomData> roomList, MsgCode msgCode) {
		super();
		this.buildingData = buildingData;
		this.commonEquipmentData = commonEquipmentData;
		this.nearList = nearList;
		this.roomList = roomList;
		this.msgCode = msgCode;
	}

	public ObjectRes(RoomData roomData, EquipmentData equipmentData, FeeData feeData, MsgCode msgCode) {
		super();
		this.roomData = roomData;
		this.equipmentData = equipmentData;
		this.feeData = feeData;
		this.msgCode = msgCode;
	}
	

	
	
	public ObjectRes(BuildingData buildingData, List<NearData> nearList, List<RoomData> roomList, List<FeeData> feeList,
			MsgCode msgCode) {
		super();
		this.buildingData = buildingData;
		this.nearList = nearList;
		this.roomList = roomList;
		this.feeList = feeList;
		this.msgCode = msgCode;
	}

	public ObjectRes(List<BuildingData> buildingList, List<NearData> nearList, List<RoomData> roomList,
			List<FeeData> feeList, MsgCode msgCode) {
		super();
		this.buildingList = buildingList;
		this.nearList = nearList;
		this.roomList = roomList;
		this.feeList = feeList;
		this.msgCode = msgCode;
	}

	public BuildingData getBuildingData() {
		return buildingData;
	}

	public void setBuildingData(BuildingData buildingData) {
		this.buildingData = buildingData;
	}

	public List<BuildingData> getBuildingList() {
		return buildingList;
	}

	public void setBuildingList(List<BuildingData> buildingList) {
		this.buildingList = buildingList;
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

	public RoomData getRoomData() {
		return roomData;
	}

	public void setRoomData(RoomData roomData) {
		this.roomData = roomData;
	}

	public List<RoomData> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<RoomData> roomList) {
		this.roomList = roomList;
	}

	public EquipmentData getEquipmentData() {
		return equipmentData;
	}

	public void setEquipmentData(EquipmentData equipmentData) {
		this.equipmentData = equipmentData;
	}

	public FeeData getFeeData() {
		return feeData;
	}

	public void setFeeData(FeeData feeData) {
		this.feeData = feeData;
	}

	public MsgCode getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(MsgCode msgCode) {
		this.msgCode = msgCode;
	}

	public List<FeeData> getFeeList() {
		return feeList;
	}

	public void setFeeList(List<FeeData> feeList) {
		this.feeList = feeList;
	}
	
	


	
}
