package com.reinext.rental.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipment_data")
public class EquipmentData {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "EQ_ID")
	private int eqId;
	
	//物件中的設備
	//跟BuildingData的buildingId
	@Column(name = "BU_ID")
	private int buId;
	
	@Column(name = "ROOM_NUM")
	private String roomNum;
	
	//電気
	@Column(name = "ELECTRIC")
	private String electric;
	
	//ガス
	@Column(name = "GAS")
	private String gas;
	
	//コンロ 爐子
	@Column(name = "STOVE")
	private String stove;
	
	//上水道
	@Column(name = "WATERWORKS")
	private String waterWorks;
	
	//下水道
	@Column(name = "SEWAGE")
	private String sewage;
	
	//台所 廚房
	@Column(name = "KITCHEN")
	private String kitchen;
	
	//廁 浴
	@Column(name = "TOI_BATH")
	private String toiBath;
	
	//洗濯機　洗衣機
	@Column(name = "WASHING_MACHINE")
	private String washingMachine;
	
	//給湯設備 熱水器
	@Column(name = "WATER_HEATER")
	 private String waterHeater;
	
	//エアコン 冷暖氣機
	@Column(name = "AIR_CONDITIONER")
	private String airConditioner;
	
	//照明器具  燈
	@Column(name = "LIGHT")
	private String light;
	
	//インターネット　網路
	@Column(name = "INTERNET")
	private String internet;
	
	//トランクルーム 倉庫
	@Column(name = "TRUNK_ROOM")
	private String trunkRoom;
	
	//ルーフバルコニー　陽台
	@Column(name = "ROOF_BALCONY")
	private String roofBalcony;
	
	//無線TV 地デジ
//	@JsonProperty("TV")
	@Column(name = "TV")
	private String tv;
	
	//有線TV
//	@JsonProperty("CATV")
	@Column(name = "CATV")
	private String catv;
	
	//專用庭
	@Column(name = "YARD")
	private String yard;
	
	//備附家具及備考
	@Column(name = "FURNITURE")
	private String furniture;

	public EquipmentData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EquipmentData(int eqId, int buId, String roomNum, String electric, String gas, String stove,
			String waterWorks, String sewage, String kitchen, String toiBath, String washingMachine, String waterHeater,
			String airConditioner, String light, String internet, String trunkRoom, String roofBalcony, String tv,
			String catv, String yard, String furniture) {
		super();
		this.eqId = eqId;
		this.buId = buId;
		this.roomNum = roomNum;
		this.electric = electric;
		this.gas = gas;
		this.stove = stove;
		this.waterWorks = waterWorks;
		this.sewage = sewage;
		this.kitchen = kitchen;
		this.toiBath = toiBath;
		this.washingMachine = washingMachine;
		this.waterHeater = waterHeater;
		this.airConditioner = airConditioner;
		this.light = light;
		this.internet = internet;
		this.trunkRoom = trunkRoom;
		this.roofBalcony = roofBalcony;
		this.tv = tv;
		this.catv = catv;
		this.yard = yard;
		this.furniture = furniture;
	}

	

	public EquipmentData(int buId, String roomNum, String electric, String gas, String stove, String waterWorks,
			String sewage, String kitchen, String toiBath, String washingMachine, String waterHeater,
			String airConditioner, String light, String internet, String trunkRoom, String roofBalcony, String tv,
			String catv, String yard, String furniture) {
		super();
		this.buId = buId;
		this.roomNum = roomNum;
		this.electric = electric;
		this.gas = gas;
		this.stove = stove;
		this.waterWorks = waterWorks;
		this.sewage = sewage;
		this.kitchen = kitchen;
		this.toiBath = toiBath;
		this.washingMachine = washingMachine;
		this.waterHeater = waterHeater;
		this.airConditioner = airConditioner;
		this.light = light;
		this.internet = internet;
		this.trunkRoom = trunkRoom;
		this.roofBalcony = roofBalcony;
		this.tv = tv;
		this.catv = catv;
		this.yard = yard;
		this.furniture = furniture;
	}

	public int getEqId() {
		return eqId;
	}

	public void setEqId(int eqId) {
		this.eqId = eqId;
	}

	public int getBuId() {
		return buId;
	}

	public void setBuId(int buId) {
		this.buId = buId;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public String getElectric() {
		return electric;
	}

	public void setElectric(String electric) {
		this.electric = electric;
	}

	public String getGas() {
		return gas;
	}

	public void setGas(String gas) {
		this.gas = gas;
	}

	public String getStove() {
		return stove;
	}

	public void setStove(String stove) {
		this.stove = stove;
	}

	public String getWaterWorks() {
		return waterWorks;
	}

	public void setWaterWorks(String waterWorks) {
		this.waterWorks = waterWorks;
	}

	public String getSewage() {
		return sewage;
	}

	public void setSewage(String sewage) {
		this.sewage = sewage;
	}

	public String getKitchen() {
		return kitchen;
	}

	public void setKitchen(String kitchen) {
		this.kitchen = kitchen;
	}

	public String getToiBath() {
		return toiBath;
	}

	public void setToiBath(String toiBath) {
		this.toiBath = toiBath;
	}

	public String getWashingMachine() {
		return washingMachine;
	}

	public void setWashingMachine(String washingMachine) {
		this.washingMachine = washingMachine;
	}

	public String getWaterHeater() {
		return waterHeater;
	}

	public void setWaterHeater(String waterHeater) {
		this.waterHeater = waterHeater;
	}

	public String getAirConditioner() {
		return airConditioner;
	}

	public void setAirConditioner(String airConditioner) {
		this.airConditioner = airConditioner;
	}

	public String getLight() {
		return light;
	}

	public void setLight(String light) {
		this.light = light;
	}

	public String getInternet() {
		return internet;
	}

	public void setInternet(String internet) {
		this.internet = internet;
	}

	public String getTrunkRoom() {
		return trunkRoom;
	}

	public void setTrunkRoom(String trunkRoom) {
		this.trunkRoom = trunkRoom;
	}

	public String getRoofBalcony() {
		return roofBalcony;
	}

	public void setRoofBalcony(String roofBalcony) {
		this.roofBalcony = roofBalcony;
	}

	public String getTv() {
		return tv;
	}

	public void setTv(String tv) {
		this.tv = tv;
	}

	public String getCatv() {
		return catv;
	}

	public void setCatv(String catv) {
		this.catv = catv;
	}

	public String getYard() {
		return yard;
	}

	public void setYard(String yard) {
		this.yard = yard;
	}

	public String getFurniture() {
		return furniture;
	}

	public void setFurniture(String furniture) {
		this.furniture = furniture;
	}

}

