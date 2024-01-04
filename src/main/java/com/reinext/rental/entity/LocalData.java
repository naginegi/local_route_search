package com.reinext.rental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "local_data")
public class LocalData {

	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name = "PREF_NAME")
	private String prefName;
	
	@Column(name = "LOCAL_NAME")
	private String localName;

	public LocalData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocalData(int id, String prefName, String localName) {
		super();
		this.id = id;
		this.prefName = prefName;
		this.localName = localName;
	}

	public LocalData(String localName) {
		super();
		this.prefName = localName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrefName() {
		return prefName;
	}

	public void setPrefName(String prefName) {
		this.prefName = prefName;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}
	
	
}
