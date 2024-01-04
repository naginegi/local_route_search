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
		int buId = buDao.save(req.getBuildingData()).getBuId();
		
		req.getCommonEquipmentData().setBuId(buId);
		cmEqDao.save(req.getCommonEquipmentData());
		
		List<NearData> nearList = req.getNearList();
		for(NearData near:nearList) {
			near.setBuId(buId);
		}
		nearDao.saveAll(nearList);
		
		for(ObjRoomDataVo roomData:req.getRoomDataVo()) {
			RoomData room = roomData.getRoomData();
			EquipmentData eq = roomData.getEquipmentData();
			FeeData fee = roomData.getFeeData();
			room.setBuId(buId);
			eq.setBuId(buId);
			fee.setBuId(buId);
			
			room.setLastUpdated(LocalDate.now());
			
			roomDao.save(room);
			eqDao.save(eq);
			feeDao.save(fee);
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
