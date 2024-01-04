package com.reinext.rental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "manager_data")
public class ManagerData {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "ID")
	private int id;

	// ��BuildingData��buildingId
	@Column(name = "BUILDING_ID")
	private int buildingId;
	
	//�и��A�W�ɴN�g�@���
	@Column(name = "ROOM_NUM")
	private String roomNum;

	// �޲z�~�� �W��
	@Column(name = "MANAGER_NAME")
	private String managerName;

	// �޲z�~�� �q��
	@Column(name = "MANAGER_PHONE")
	private String manegerPhone;

	// �޲z�~�� �a�}
	@Column(name = "MANAGER_ADDRESS")
	private String managerAddress;

	// �Ʀ�
	@Column(name = "NOTES")
	private String notes;

	public ManagerData() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public ManagerData(int buildingId, String roomNum, String managerName, String manegerPhone, String managerAddress,
			String notes) {
		super();
		this.buildingId = buildingId;
		this.roomNum = roomNum;
		this.managerName = managerName;
		this.manegerPhone = manegerPhone;
		this.managerAddress = managerAddress;
		this.notes = notes;
	}



	public ManagerData(int id, int buildingId, String roomNum, String managerName, String manegerPhone,
			String managerAddress, String notes) {
		super();
		this.id = id;
		this.buildingId = buildingId;
		this.roomNum = roomNum;
		this.managerName = managerName;
		this.manegerPhone = manegerPhone;
		this.managerAddress = managerAddress;
		this.notes = notes;
	}



	public int getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManegerPhone() {
		return manegerPhone;
	}

	public void setManegerPhone(String manegerPhone) {
		this.manegerPhone = manegerPhone;
	}

	public String getManagerAddress() {
		return managerAddress;
	}

	public void setManagerAddress(String managerAddress) {
		this.managerAddress = managerAddress;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getRoomNum() {
		return roomNum;
	}



	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	
	
}
