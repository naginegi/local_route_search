package com.reinext.rental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fee_data")
public class FeeData {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "FEE_ID")
	private int feeId;
	
	//物件中的各種費用、契約、人等資料
	//跟BuildingData的buildingId
	@Column(name = "BU_ID")
	private int buId;
	
	//房號，獨棟就寫一戶建
	@Column(name = "ROOM_NUM")
	private String roomNum;

	//賃金
	@Column(name = "RENT")
	private String rent;

	//敷金
	@Column(name = "DEPOSIT")
	private String deposit;

	//禮金
	@Column(name = "REWARD")
	private String reward;

	//共益費
	@Column(name = "COMMON_EXPENSES")
	private String commonExpenses;

	//更新料
	@Column(name = "RENEWAL")
	private String renewal;
	
	//その他料金
	@Column(name = "OTHER_EXPENSES")
	private String otherExpenses;
	
	//備考
	@Column(name = "FEE_NOTES")
	private String feeNotes;

	public FeeData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FeeData(int feeId, int buId, String roomNum, String rent, String deposit, String reward,
			String commonExpenses, String renewal, String otherExpenses, String feeNotes) {
		super();
		this.feeId = feeId;
		this.buId = buId;
		this.roomNum = roomNum;
		this.rent = rent;
		this.deposit = deposit;
		this.reward = reward;
		this.commonExpenses = commonExpenses;
		this.renewal = renewal;
		this.otherExpenses = otherExpenses;
		this.feeNotes = feeNotes;
	}

	

	public FeeData(int buId, String roomNum, String rent, String deposit, String reward, String commonExpenses,
			String renewal, String otherExpenses, String feeNotes) {
		super();
		this.buId = buId;
		this.roomNum = roomNum;
		this.rent = rent;
		this.deposit = deposit;
		this.reward = reward;
		this.commonExpenses = commonExpenses;
		this.renewal = renewal;
		this.otherExpenses = otherExpenses;
		this.feeNotes = feeNotes;
	}

	public int getFeeId() {
		return feeId;
	}

	public void setFeeId(int feeId) {
		this.feeId = feeId;
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

	public String getRent() {
		return rent;
	}

	public void setRent(String rent) {
		this.rent = rent;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}

	public String getCommonExpenses() {
		return commonExpenses;
	}

	public void setCommonExpenses(String commonExpenses) {
		this.commonExpenses = commonExpenses;
	}

	public String getRenewal() {
		return renewal;
	}

	public void setRenewal(String renewal) {
		this.renewal = renewal;
	}

	public String getOtherExpenses() {
		return otherExpenses;
	}

	public void setOtherExpenses(String otherExpenses) {
		this.otherExpenses = otherExpenses;
	}

	public String getFeeNotes() {
		return feeNotes;
	}

	public void setFeeNotes(String feeNotes) {
		this.feeNotes = feeNotes;
	}




}
