package com.reinext.rental.vo;

import java.util.List;

import com.reinext.rental.constants.MsgCode;
import com.reinext.rental.entity.BuildingData;
import com.reinext.rental.entity.CommonEquipmentData;
import com.reinext.rental.entity.EquipmentData;
import com.reinext.rental.entity.FeeData;
import com.reinext.rental.entity.LessorData;
import com.reinext.rental.entity.ManagerData;
import com.reinext.rental.entity.NearData;

public class ObjResListVo {
	
	private List<BuildingData> buRes;
	private List<EquipmentData> eqRes;
	private List<CommonEquipmentData> cmEqRes;
	private List<FeeData> feeRes;
	private List<LessorData> lessorRes;
	private List<ManagerData> managerRes;
	private List<NearData> nearRes;
	
	private MsgCode	msgCode;

	public ObjResListVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ObjResListVo(List<BuildingData> buRes, List<EquipmentData> eqRes, List<CommonEquipmentData> cmEqRes,
			List<FeeData> feeRes, List<LessorData> lessorRes, List<ManagerData> managerRes, List<NearData> nearRes,
			MsgCode msgCode) {
		super();
		this.buRes = buRes;
		this.eqRes = eqRes;
		this.cmEqRes = cmEqRes;
		this.feeRes = feeRes;
		this.lessorRes = lessorRes;
		this.managerRes = managerRes;
		this.nearRes = nearRes;
		this.msgCode = msgCode;
	}

	public List<BuildingData> getBuRes() {
		return buRes;
	}

	public void setBuRes(List<BuildingData> buRes) {
		this.buRes = buRes;
	}

	public List<EquipmentData> getEqRes() {
		return eqRes;
	}

	public void setEqRes(List<EquipmentData> eqRes) {
		this.eqRes = eqRes;
	}

	public List<CommonEquipmentData> getCmEqRes() {
		return cmEqRes;
	}

	public void setCmEqRes(List<CommonEquipmentData> cmEqRes) {
		this.cmEqRes = cmEqRes;
	}

	public List<FeeData> getFeeRes() {
		return feeRes;
	}

	public void setFeeRes(List<FeeData> feeRes) {
		this.feeRes = feeRes;
	}

	public List<LessorData> getLessorRes() {
		return lessorRes;
	}

	public void setLessorRes(List<LessorData> lessorRes) {
		this.lessorRes = lessorRes;
	}

	public List<ManagerData> getManagerRes() {
		return managerRes;
	}

	public void setManagerRes(List<ManagerData> managerRes) {
		this.managerRes = managerRes;
	}

	public List<NearData> getNearRes() {
		return nearRes;
	}

	public void setNearRes(List<NearData> nearRes) {
		this.nearRes = nearRes;
	}

	public MsgCode getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(MsgCode msgCode) {
		this.msgCode = msgCode;
	}

	

	
}
