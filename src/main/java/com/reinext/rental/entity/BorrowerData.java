package com.reinext.rental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "borrower_data")
public class BorrowerData {
	
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
	@Column(name = "BORROWER_NAME")
	private String borrowerName;

	// �޲z�~�� �q��
	@Column(name = "BORROWER_PHONE")
	private String borrowerPhone;

	// �޲z�~�� �a�}
	@Column(name = "BORROWER_ADDRESS")
	private String borrowerAddress;

	// �Ʀ�
	@Column(name = "NOTES")
	private String notes;

	public BorrowerData() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public BorrowerData(int buildingId, String roomNum, String borrowerName, String borrowerPhone,
			String borrowerAddress, String notes) {
		super();
		this.buildingId = buildingId;
		this.roomNum = roomNum;
		this.borrowerName = borrowerName;
		this.borrowerPhone = borrowerPhone;
		this.borrowerAddress = borrowerAddress;
		this.notes = notes;
	}



	public BorrowerData(int id, int buildingId, String roomNum, String borrowerName, String borrowerPhone,
			String borrowerAddress, String notes) {
		super();
		this.id = id;
		this.buildingId = buildingId;
		this.roomNum = roomNum;
		this.borrowerName = borrowerName;
		this.borrowerPhone = borrowerPhone;
		this.borrowerAddress = borrowerAddress;
		this.notes = notes;
	}



	public int getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

	public String getBorrowerName() {
		return borrowerName;
	}

	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}

	public String getBorrowerPhone() {
		return borrowerPhone;
	}

	public void setBorrowerPhone(String borrowerPhone) {
		this.borrowerPhone = borrowerPhone;
	}

	public String getBorrowerAddress() {
		return borrowerAddress;
	}

	public void setBorrowerAddress(String borrowerAddress) {
		this.borrowerAddress = borrowerAddress;
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
