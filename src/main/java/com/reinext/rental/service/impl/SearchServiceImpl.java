package com.reinext.rental.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.reinext.rental.constants.MsgCode;
import com.reinext.rental.entity.LocalData;
import com.reinext.rental.entity.StationData;
import com.reinext.rental.repository.LocalDataDao;
import com.reinext.rental.repository.LocalRouteDataDao;
import com.reinext.rental.repository.StationDataDao;
import com.reinext.rental.service.ifs.SearchService;
import com.reinext.rental.vo.CreateVo;
import com.reinext.rental.vo.Res;

//import ch.qos.logback.core.boolex.Matcher;

@Service
public class SearchServiceImpl implements SearchService{

	@Autowired
	private LocalDataDao localDataDao;

	@Autowired
	private StationDataDao stationDataDao;
	
	@Autowired
	private LocalRouteDataDao localRouteDataDao;
	
	
	@Override
	public Res localSearch(String prefName) {
//		if(StringUtils.hasText(prefName)) {
//			return new Res(null,null,null,MsgCode.INPUT_ERROR);
//		}
		List<LocalData> res = localDataDao.selectLocal(prefName);
//		if(res.isEmpty()) {			
//			return new Res(null,null,null,MsgCode.AREA_NOT_FOUND);
//		}
		return new Res(null,res,null,MsgCode.SUCCESSFUL);
	}

//	@Override
//	public Res getLocalDataTables() {
////		if(StringUtils.hasText(prefName)) {
////			return new Res(null,null,null,MsgCode.INPUT_ERROR);
////		}
//		List<LocalData> res = localDataDao.getLocalDataTables();
////		if(res.isEmpty()) {			
////			return new Res(null,null,null,MsgCode.AREA_NOT_FOUND);
////		}
//		return new Res(null,res,null,MsgCode.SUCCESSFUL);
//	}

	@Override
	public Res lineSearch(String prefName) {
//		if(StringUtils.hasText(prefName)) {
//			return new Res(null,null,null,MsgCode.INPUT_ERROR);
//		}
		
		List<StationData> res = stationDataDao.selectLine(prefName);
//		if(res.isEmpty()) {			
//			return new Res(null,null,null,MsgCode.AREA_NOT_FOUND);
//		}
		return new Res(res,null,null,MsgCode.SUCCESSFUL);
	}

	@Override
	public Res stationSearch(List<String> lineName) {
//		if(lineName.isEmpty()) {
//			return new Res(null,null,null,MsgCode.LINE_NOT_FOUND);
//		}
		List<StationData> res = stationDataDao.selectStation(lineName);
//		if(res.isEmpty()) {	
//			return new Res(null,null,null,MsgCode.AREA_NOT_FOUND);
//		}
		return new Res(res,null,null,MsgCode.SUCCESSFUL);
	}

	@Override
	public Res prefRoute(String prefName) {
//		if(StringUtils.hasText(prefName)) {
//			return new Res(null,null,null,MsgCode.INPUT_ERROR);
//		}
		List<String> res = stationDataDao.prefRoute(prefName);
//		if(res.isEmpty()) {			
//			return new Res(null,null,null,MsgCode.AREA_NOT_FOUND);
//		}
		return new Res(res,MsgCode.SUCCESSFUL);
	
	}

	@Override
	public Res localRoute(String localName) {
//		if(StringUtils.hasText(localName)) {
//			return new Res(null,null,null,MsgCode.INPUT_ERROR);
//		}
		List<String> res = localRouteDataDao.localRoute(localName);
//		if(res.isEmpty()) {			
//			return new Res(null,null,null,MsgCode.AREA_NOT_FOUND);
//		}
		return new Res(res,MsgCode.SUCCESSFUL);
	
	}

	@Override
	public Res createRoute(CreateVo vo) {
		
//		localDataDao.createLocal(vo.getPrefName(), vo.getLocalName());
		
		if(!StringUtils.hasText(vo.getPrefName())
				||!StringUtils.hasText(vo.getLocalName())
				||!StringUtils.hasText(vo.getLineName())
				||!StringUtils.hasText(vo.getStationName())
				||!StringUtils.hasText(vo.getAddress())) {
			return new Res(null,MsgCode.INPUT_ERROR);
		}
		
		if(!localDataDao.existsByPrefNameAndLocalName(vo.getPrefName(),vo.getLocalName())){
			return new Res(null,MsgCode.AREA_NOT_FOUND);
		}
		
		String prefRegex = vo.getPrefName();
		Pattern prefPattern = Pattern.compile(prefRegex);
		Matcher prefMatcher = prefPattern.matcher(vo.getAddress());

		String localRegex = vo.getLocalName();
		Pattern localPattern = Pattern.compile(localRegex);
		Matcher localMatcher = localPattern.matcher(vo.getAddress());
        
		if(prefMatcher.find() == false || localMatcher.find() == false) {
			return new Res(null,MsgCode.ADDRESS_ERROR);
		}
	
		if(localRouteDataDao.existsByAddress(vo.getAddress())) {
			return new Res(null,MsgCode.ADDRESS_EXISTED);
		}
		
		if(stationDataDao.existsByStationNameAndLineName(vo.getStationName(), vo.getLineName())) {
			return new Res(null,MsgCode.STATION_EXISTED);

		}
		
		stationDataDao.createStation(vo.getPrefName(), vo.getStationName(), vo.getLineName());
		localRouteDataDao.createRoute(vo.getStationName(), vo.getAddress(), vo.getLineName());
		return new Res(null,MsgCode.SUCCESSFUL);
	}

	@Override
	public Res getPref() {
		List<String> res = localDataDao.getPref();
//		if(res.isEmpty()) {			
//			return new Res(null,null,null,MsgCode.AREA_NOT_FOUND);
//		}
		return new Res(res,MsgCode.SUCCESSFUL);
	}

	@Override
	public Res getLocal() {
		List<String> res = localDataDao.getLocal();
//		if(res.isEmpty()) {			
//			return new Res(null,null,null,MsgCode.AREA_NOT_FOUND);
//		}
		return new Res(res,MsgCode.SUCCESSFUL);
	}

	@Override
	public Res getLocalDataTables() {
		List<LocalData> res = localDataDao.getLocalDataTables();
		return new Res(null,res,null,MsgCode.SUCCESSFUL);
	}

	@Override
	public Res getLineStation() {
		List<StationData> res = stationDataDao.findAll();
		return new Res(res,null,null,MsgCode.SUCCESSFUL);
	}

	
}
