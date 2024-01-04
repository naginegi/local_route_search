package com.reinext.rental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.reinext.rental.entity.LocalData;
import com.reinext.rental.entity.StationData;
import com.reinext.rental.service.ifs.ObjectService;
import com.reinext.rental.service.ifs.SearchService;
import com.reinext.rental.vo.ObjectReq;
import com.reinext.rental.vo.ObjectRes;

@Controller
public class ObjectController {

	@Autowired
	private ObjectService objService;

	@Autowired
	private SearchService searchService;

	// 轉json格式用
	ObjectMapper objectMapper = new ObjectMapper();
	

	////////////////////////////////////////////////

	// 設置頁面

////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/objTemp/Create/stage")
	public String objbackCreateStage() {

		return "objTemp/Create/stage";
	}

	@RequestMapping(value = "/objTemp/Create/Pref")
	public String objbackCreatePref(Model model) throws JsonProcessingException {
		model.addAttribute("pref_data", searchService.getPref().getStr());

		// 找全部資料 包含督到府跟市町村
		List<LocalData> LocalData = searchService.getLocalDataTables().getLocalData();
//		ObjectMapper objectMapper = new ObjectMapper();
		String LocalDataJson = objectMapper.writeValueAsString(LocalData);
		model.addAttribute("local_data", LocalDataJson);

		return "objTemp/Create/Pref";
	}

	////////////////////////////////////////////////

	// 前往local.html頁面
	// 帶Pref的select_Pref值進來，找市町村後回傳
	@RequestMapping(value = "/objTemp/Create/Local")
	public String gotoLocal(Model model) throws JsonProcessingException {

		// 找全部資料 包含督到府跟市町村
		List<LocalData> LocalData = searchService.getLocalDataTables().getLocalData();
//		ObjectMapper objectMapper = new ObjectMapper();
		String LocalDataJson = objectMapper.writeValueAsString(LocalData);
		model.addAttribute("local_data", LocalDataJson);

//		model.addAttribute("local_data", searchService.getLocalDataTables().getLocalData());		
		return "objTemp/Create/Local";
	}

	// 前往Building.html頁面
	@RequestMapping(value = "/objTemp/Create/Building")
	public String gotoBuilding(Model model) {

		return "objTemp/Create/Building";
	}

	// 前往Equipment.html頁面
	//
	@RequestMapping(value = "/objTemp/Create/Equipment")
	public String gotoEquipment() {

		return "objTemp/Create/Equipment";
	}

	// 前往Equipment.html頁面
	//
	@RequestMapping(value = "/objTemp/Create/Fee")
	public String gotoFee() {

		return "objTemp/Create/Fee";
	}

	@RequestMapping(value = "/objTemp/Create/Near")
	public String gotoNear(@RequestParam(name = "prefData") String prefData, Model model)
			throws JsonProcessingException {
		System.out.println(prefData);

		// 找全部資料 包含車站跟線路
		List<StationData> stationData = searchService.lineSearch(prefData).getStationData();
//        ObjectMapper objectMapper = new ObjectMapper();
		String stationDataJson = objectMapper.writeValueAsString(stationData);
		model.addAttribute("stationDataJson", stationDataJson);

		// 找線路，給select用

		return "objTemp/Create/Near";
	}

	@RequestMapping(value = "/objTemp/Create/complete")
	public String gotoComplete(Model model) throws JsonProcessingException {

		return "objTemp/Create/complete";
	}
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/objTemp/Create/savePage")
	public String gotosavePage(@RequestParam(name = "totalData") String totalData, Model model)
			throws JsonProcessingException {

//		ObjectMapper objectMapper = new ObjectMapper();
		// 轉換Json
//		ObjectReq req = objectMapper.readValue(totalData, ObjectReq.class);

//		objService.setData(req);

		return "objTemp/Create/savePage";
	}

	// 編輯
	@RequestMapping(value = "/objTemp/objEdit")
	public String gotoObjEdit(@RequestParam(name = "buid") int buid, Model model) throws JsonProcessingException {
		System.out.println(buid);
//		ObjectReq Res = objService.getDataByBuId(buid).getOdjectReq();
//		String ResJson = objectMapper.writeValueAsString(Res);
//		model.addAttribute("total_data", ResJson);

		return "objTemp/objEdit";
	}

	// 新的新增

	@RequestMapping(value = "/objTemp/objCreate")
	public String gotoObjCreate(Model model) throws JsonProcessingException {

		// 找全部資料 包含督到府跟市町村
		List<LocalData> LocalData = searchService.getLocalDataTables().getLocalData();
		String LocalDataJson = objectMapper.writeValueAsString(LocalData);
		model.addAttribute("total_local_data", LocalDataJson);

		List<StationData> stationData = searchService.getLineStation().getStationData();
		String stationDataJson = objectMapper.writeValueAsString(stationData);
		model.addAttribute("total_station_data", stationDataJson);

		return "objTemp/objCreate";
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/obj/objback")
	public String objback(Model model) throws JsonProcessingException {
		// 取全部建築資料供主頁面顯示用
		objectMapper.registerModule(new JavaTimeModule());
		String totalDataJson = objectMapper.writeValueAsString(objService.findViewData());
		model.addAttribute("totalDataJson", totalDataJson);
//		model.addAttribute("thy_building_data", objService.getAllTables().getBuRes());

//		model.addAttribute("buList",objService.findViewData().getBuildingList());
//		model.addAttribute("nearList",objService.findViewData().getNearList());
		return "obj/objback";
	}

	@RequestMapping(value = "/obj/objBuCreate")
	public String objBuCreate(Model model) throws JsonProcessingException {
		// 找全部資料 包含督到府跟市町村
		List<LocalData> LocalData = searchService.getLocalDataTables().getLocalData();
		String LocalDataJson = objectMapper.writeValueAsString(LocalData);
		model.addAttribute("total_data", LocalDataJson);

		List<StationData> stationData = searchService.getLineStation().getStationData();
		String stationDataJson = objectMapper.writeValueAsString(stationData);
		model.addAttribute("total_station_data", stationDataJson);

		return "obj/objBuCreate";
	}

	@RequestMapping(value = "/obj/objBuCreateSave")
	public String objBuCreateSave(@RequestParam(name = "buData") String buData, Model model)
			throws JsonProcessingException {
//		System.out.println(buData);
		ObjectReq req = objectMapper.readValue(buData, ObjectReq.class);
		ObjectRes res = objService.DataSave(req);
		model.addAttribute("res",res.getMsgCode());

		// 找全部資料 包含督到府跟市町村
		List<LocalData> LocalData = searchService.getLocalDataTables().getLocalData();
		String LocalDataJson = objectMapper.writeValueAsString(LocalData);
		model.addAttribute("total_data", LocalDataJson);

		List<StationData> stationData = searchService.getLineStation().getStationData();
		String stationDataJson = objectMapper.writeValueAsString(stationData);
		model.addAttribute("total_station_data", stationDataJson);

		return "obj/objBuCreate";
	}

	@RequestMapping(value = "/obj/objBuEdit")
	public String objBuEdit(Model model) {

		return "obj/objBuEdit";
	}

	///
	@RequestMapping(value = "/obj/objRoomCreate")
	public String objRoomCreate(Model model) {

		return "obj/objRoomCreate";
	}

	@RequestMapping(value = "/obj/objRoomCreateSave")
	public String objRoomCreateSave(Model model) throws JsonMappingException, JsonProcessingException {
//		ObjectReq req = objectMapper.readValue(roomData, ObjectReq.class);
//		ObjectRes res = objService.roomDataSave(req);
		model.addAttribute("res", "SUCCESSFUL");
		return "obj/objRoomCreate";
	}

	///
	@RequestMapping(value = "/obj/objRoomEdit")
	public String objRoomEdit(Model model) {

		return "obj/objRoomEdit";
	}

	//
	@RequestMapping(value = "/obj/objfront")
	public String objfront(Model model) throws JsonProcessingException {
		// 取全部建築資料供主頁面顯示用
//		String buildingDataJson = objectMapper.writeValueAsString(objService.getAllTables());
//		model.addAttribute("building_data", buildingDataJson);
//		model.addAttribute("thy_building_data", objService.getAllTables().getBuRes());

		return "obj/objfront";
	}

	@RequestMapping(value = "/obj/objview")
	public String objview(Model model) throws JsonProcessingException {
		// 取全部建築資料供主頁面顯示用
//		String buildingDataJson = objectMapper.writeValueAsString(objService.getAllTables());
//		model.addAttribute("building_data", buildingDataJson);
//		model.addAttribute("thy_building_data", objService.getAllTables().getBuRes());

		return "obj/objview";
	}

}
