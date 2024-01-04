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

		//��BuildingData��buildingId
		@Column(name = "BUILDING_ID")
		private int buildingId;
		
		//�и��A�W�ɴN�g�@���
		@Column(name = "ROOM_NUM")
		private String roomNum;
		
		//��D �W��
		@Column(name = "LESSOR_NAME")
		private String lessorName;
		
		//��D �q��
		@Column(name = "LESSOR_PHONE")
		private String lessorPhone;
		
		//��D �a�}
		@Column(name = "LESSOR_ADDRESS")
		private String lessorAddress;
		
		//�Ʀ�
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
