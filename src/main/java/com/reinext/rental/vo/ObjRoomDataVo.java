package com.reinext.rental.vo;

import com.reinext.rental.entity.EquipmentData;
import com.reinext.rental.entity.FeeData;
import com.reinext.rental.entity.RoomData;

public class ObjRoomDataVo {
	
	private RoomData roomData;
	
	private EquipmentData equipmentData;
	
	private FeeData feeData;

	public ObjRoomDataVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ObjRoomDataVo(RoomData roomData, EquipmentData equipmentData, FeeData feeData) {
		super();
		this.roomData = roomData;
		this.equipmentData = equipmentData;
		this.feeData = feeData;
	}

	public RoomData getRoomData() {
		return roomData;
	}

	public void setRoomData(RoomData roomData) {
		this.roomData = roomData;
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
	
	
}
