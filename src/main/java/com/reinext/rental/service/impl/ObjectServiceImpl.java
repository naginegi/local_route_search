 package com.reinext.rental.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reinext.rental.constants.MsgCode;
import com.reinext.rental.entity.BuildingData;
import com.reinext.rental.entity.CommonEquipmentData;
import com.reinext.rental.entity.EquipmentData;
import com.reinext.rental.entity.FeeData;
import com.reinext.rental.entity.LessorData;
import com.reinext.rental.entity.LocalData;
import com.reinext.rental.entity.ManagerData;
import com.reinext.rental.entity.NearData;
import com.reinext.rental.entity.RoomData;
import com.reinext.rental.repository.BuildingDao;
import com.reinext.rental.repository.CommonEquipmentDao;
import com.reinext.rental.repository.EquipmentDao;
import com.reinext.rental.repository.FeeDao;
import com.reinext.rental.repository.LessorDao;
import com.reinext.rental.repository.ManagerDao;
import com.reinext.rental.repository.NearDao;
import com.reinext.rental.repository.RoomDao;
import com.reinext.rental.service.ifs.ObjectService;
import com.reinext.rental.vo.ObjResListVo;
import com.reinext.rental.vo.ObjRoomDataVo;
import com.reinext.rental.vo.ObjectReq;
import com.reinext.rental.vo.ObjectRes;

import jakarta.transaction.Transactional;
@Service
public class ObjectServiceImpl implements ObjectService{

	@Autowired
	private BuildingDao buDao;
	
	@Autowired
	private CommonEquipmentDao cmEqDao;
	
	@Autowired
	private NearDao nearDao;

	@Autowired
	private RoomDao roomDao;
	
	@Autowired
	private EquipmentDao eqDao;
	
	@Autowired
	private FeeDao feeDao;
	
	@Autowired
	private LessorDao lessorDao;
	
	@Autowired
	private ManagerDao managerDao;

	@Override
	public ObjectRes DataSave(ObjectReq req) {
		
		//
		BuildingData bu = req.getBuildingData();
		buDao.saveBuilding(bu.getBuName(), bu.getBuType(), bu.getBuYear(), bu.getBuMaterials(), bu.getBuPref(), bu.getBuLocal(), bu.getBuAddress(), bu.getBuNotes());
		int buId = buDao.findBuId();
		
		//
		//int buId = buDao.save(req.getBuildingData()).getBuId();
		
		//
		CommonEquipmentData cmEq = req.getCommonEquipmentData();
//		req.getCommonEquipmentData().setBuId(buId);
		cmEqDao.saveCmeq(buId, cmEq.getElevator(), cmEq.getAutoLock(), cmEq.getMailBox(), cmEq.getDeliveryBox(), cmEq.getParking(), cmEq.getCmeqNotes());
		
//		cmEqDao.save(req.getCommonEquipmentData());
		
		List<NearData> nearList = req.getNearList();
		for(NearData near:nearList) {
//			near.setBuId(buId);
			nearDao.saveNear(buId, near.getNearLine(), near.getNearStation(), near.getWarkingTime());
		}
//		nearDao.saveAll(nearList);
		
		for(ObjRoomDataVo roomData:req.getRoomDataVo()) {
			RoomData room = roomData.getRoomData();
			EquipmentData eq = roomData.getEquipmentData();
			FeeData fee = roomData.getFeeData();
//			room.setBuId(buId);
//			eq.setBuId(buId);
//			fee.setBuId(buId);
			
			room.setLastUpdated(LocalDate.now());
	
			//
			roomDao.saveRoom(buId, room.getRoomNum(), room.getRoomArea(), room.getRoomLayout(), room.getLastUpdated());
			eqDao.saveEquipment(buId, eq.getRoomNum(), eq.getElectric(), eq.getGas(), eq.getStove(), eq.getWaterWorks(), eq.getSewage(), eq.getKitchen(), eq.getToiBath(), eq.getWashingMachine(), eq.getWaterHeater(), eq.getAirConditioner(), eq.getLight(), eq.getInternet(), eq.getTrunkRoom(), eq.getRoofBalcony(),eq.getTv(), eq.getCatv(), eq.getYard(), eq.getFurniture());
			feeDao.saveFee(buId, fee.getRoomNum(), fee.getRent(), fee.getDeposit(), fee.getReward() ,fee.getCommonExpenses(), fee.getRenewal(), fee.getOtherExpenses(), fee.getFeeNotes());
//			roomDao.save(room);
//			eqDao.save(eq);
//			feeDao.save(fee);
		}
		
		
		return new ObjectRes(MsgCode.SUCCESSFUL);
	}

	@Override
	public List<ObjectRes> findViewData() {
		List<BuildingData> buList = buDao.findAll();
		List<ObjectRes> resList = new ArrayList<>();
		for(BuildingData bu:buList) {
			ObjectRes res = new ObjectRes();
			int buId = bu.getBuId();			
			res.setBuildingData(bu);
			res.setNearList(nearDao.findAllByBuId(buId));
			res.setRoomList(roomDao.findAllByBuId(buId));
			res.setFeeList(feeDao.findAllByBuId(buId));
			res.setMsgCode(MsgCode.SUCCESSFUL);
			resList.add(res);
		}
		
		return new ArrayList<ObjectRes>(resList);
	}





	

}
