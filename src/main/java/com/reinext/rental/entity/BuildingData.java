package com.reinext.rental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "building_data")
public class BuildingData {
	
	//物件ID AI生成
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "BU_ID")
	private int buId;
	
	//物件名稱
	@Column(name = "BU_NAME")
	private String buName;
	
	//物件種類(公寓...等)
	@Column(name = "BU_TYPE")
	private String buType;

	//築年數
	@Column(name = "BU_YEAR")
	private String buYear;
	
	//物件建材 構造
	@Column(name = "BU_MATERIALS")
	private String buMaterials;
	
	//物件所在都道府
	@Column(name = "BU_PREF")
	private String buPref;
	
	//物件所在市町村
	@Column(name = "BU_LOCAL")
	private String buLocal;
	
	//物件地址
	@Column(name = "BU_ADDRESS")
	private String buAddress;
	
	//備考
	@Column(name = "BU_NOTES")
	private String buNotes;


	public BuildingData() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public BuildingData(String buName, String buType, String buYear, String buMaterials, String buPref, String buLocal,
			String buAddress, String buNotes) {
		super();
		this.buName = buName;
		this.buType = buType;
		this.buYear = buYear;
		this.buMaterials = buMaterials;
		this.buPref = buPref;
		this.buLocal = buLocal;
		this.buAddress = buAddress;
		this.buNotes = buNotes;
	}




	public BuildingData(int buId, String buName, String buType, String buYear, String buMaterials, String buPref,
			String buLocal, String buAddress, String buNotes) {
		super();
		this.buId = buId;
		this.buName = buName;
		this.buType = buType;
		this.buYear = buYear;
		this.buMaterials = buMaterials;
		this.buPref = buPref;
		this.buLocal = buLocal;
		this.buAddress = buAddress;
		this.buNotes = buNotes;
	}




	public int getBuId() {
		return buId;
	}


	public void setBuId(int buId) {
		this.buId = buId;
	}


	public String getBuName() {
		return buName;
	}


	public void setBuName(String buName) {
		this.buName = buName;
	}


	public String getBuType() {
		return buType;
	}


	public void setBuType(String buType) {
		this.buType = buType;
	}


	public String getBuYear() {
		return buYear;
	}


	public void setBuYear(String buYear) {
		this.buYear = buYear;
	}


	public String getBuMaterials() {
		return buMaterials;
	}


	public void setBuMaterials(String buMaterials) {
		this.buMaterials = buMaterials;
	}


	public String getBuPref() {
		return buPref;
	}


	public void setBuPref(String buPref) {
		this.buPref = buPref;
	}


	public String getBuLocal() {
		return buLocal;
	}


	public void setBuLocal(String buLocal) {
		this.buLocal = buLocal;
	}


	public String getBuAddress() {
		return buAddress;
	}


	public void setBuAddress(String buAddress) {
		this.buAddress = buAddress;
	}




	public String getBuNotes() {
		return buNotes;
	}




	public void setBuNotes(String buNotes) {
		this.buNotes = buNotes;
	}


}
