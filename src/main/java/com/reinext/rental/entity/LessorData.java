package com.reinext.rental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "lessor_data")
public class LessorData {
	
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Id
		@Column(name = "ID")
		private int id;

		//跟BuildingData的buildingId
		@Column(name = "BUILDING_ID")
		private int buildingId;
		
		//房號，獨棟就寫一戶建
		@Column(name = "ROOM_NUM")
		private String roomNum;
		
		//賃主 名稱
		@Column(name = "LESSOR_NAME")
		private String lessorName;
		
		//賃主 電話
		@Column(name = "LESSOR_PHONE")
		private String lessorPhone;
		
		//賃主 地址
		@Column(name = "LESSOR_ADDRESS")
		private String lessorAddress;
		
		//備考
		@Column(name = "NOTES")
		private String notes;

		public LessorData() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		

		public LessorData(int buildingId, String roomNum, String lessorName, String lessorPhone, String lessorAddress,
				String notes) {
			super();
			this.buildingId = buildingId;
			this.roomNum = roomNum;
			this.lessorName = lessorName;
			this.lessorPhone = lessorPhone;
			this.lessorAddress = lessorAddress;
			this.notes = notes;
		}



		public LessorData(int id, int buildingId, String roomNum, String lessorName, String lessorPhone,
				String lessorAddress, String notes) {
			super();
			this.id = id;
			this.buildingId = buildingId;
			this.roomNum = roomNum;
			this.lessorName = lessorName;
			this.lessorPhone = lessorPhone;
			this.lessorAddress = lessorAddress;
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



		public int getBuildingId() {
			return buildingId;
		}

		public void setBuildingId(int buildingId) {
			this.buildingId = buildingId;
		}

		public String getLessorName() {
			return lessorName;
		}

		public void setLessorName(String lessorName) {
			this.lessorName = lessorName;
		}

		public String getLessorPhone() {
			return lessorPhone;
		}

		public void setLessorPhone(String lessorPhone) {
			this.lessorPhone = lessorPhone;
		}

		public String getLessorAddress() {
			return lessorAddress;
		}

		public void setLessorAddress(String lessorAddress) {
			this.lessorAddress = lessorAddress;
		}

		public String getNotes() {
			return notes;
		}

		public void setNotes(String notes) {
			this.notes = notes;
		}
		
		
}
