package com.reinext.rental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "common_equipment_data")
public class CommonEquipmentData {

		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Id
		@Column(name = "CMEQ_ID")
		private int cmeqId;
	
	
	//	��BuildingData��buildingId
		@Column(name = "BU_ID")
		private int buId;
		
		//�q��
		@Column(name = "ELEVATOR")
		private String elevator;
		
		//�۰���
		@Column(name = "AUTO_LOCK")
		private String autoLock;
		
		//�H�c
		@Column(name = "MAIL_BOX")
		private String mailBox;
		
		//�l�c
		@Column(name = "DELIVERY_BOX")
		private String deliveryBox;
		
		//�n���t
		@Column(name = "PARKING")
		private String parking;
		
		//�Ʀ�
		@Column(name = "CMEQ_NOTES")
		private String cmeqNotes;

		public CommonEquipmentData() {
			super();
			// TODO Auto-generated constructor stub
		}

		public CommonEquipmentData(int cmeqId, int buId, String elevator, String autoLock, String mailBox,
				String deliveryBox, String parking, String cmeqNotes) {
			super();
			this.cmeqId = cmeqId;
			this.buId = buId;
			this.elevator = elevator;
			this.autoLock = autoLock;
			this.mailBox = mailBox;
			this.deliveryBox = deliveryBox;
			this.parking = parking;
			this.cmeqNotes = cmeqNotes;
		}

		public CommonEquipmentData(String elevator, String autoLock, String mailBox, String deliveryBox, String parking,
				String cmeqNotes) {
			super();
			this.elevator = elevator;
			this.autoLock = autoLock;
			this.mailBox = mailBox;
			this.deliveryBox = deliveryBox;
			this.parking = parking;
			this.cmeqNotes = cmeqNotes;
		}

		public int getCmeqId() {
			return cmeqId;
		}

		public void setCmeqId(int cmeqId) {
			this.cmeqId = cmeqId;
		}

		public int getBuId() {
			return buId;
		}

		public void setBuId(int buId) {
			this.buId = buId;
		}

		public String getElevator() {
			return elevator;
		}

		public void setElevator(String elevator) {
			this.elevator = elevator;
		}

		public String getAutoLock() {
			return autoLock;
		}

		public void setAutoLock(String autoLock) {
			this.autoLock = autoLock;
		}

		public String getMailBox() {
			return mailBox;
		}

		public void setMailBox(String mailBox) {
			this.mailBox = mailBox;
		}

		public String getDeliveryBox() {
			return deliveryBox;
		}

		public void setDeliveryBox(String deliveryBox) {
			this.deliveryBox = deliveryBox;
		}

		public String getParking() {
			return parking;
		}

		public void setParking(String parking) {
			this.parking = parking;
		}

		public String getCmeqNotes() {
			return cmeqNotes;
		}

		public void setCmeqNotes(String cmeqNotes) {
			this.cmeqNotes = cmeqNotes;
		}

		
}
