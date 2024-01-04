package com.reinext.rental.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reinext.rental.service.ifs.SearchService;
import com.reinext.rental.vo.CreateVo;
import com.reinext.rental.vo.Res;

@RestController
@CrossOrigin
public class SearchResController {

	@Autowired
	private SearchService service;
	
	@GetMapping(value = "api/search/test")
	public List<String> test() {
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("A","B","C"));
		return list;
	}
	
	@PostMapping(value = "api/search/test2")
	public int test2(@RequestParam(value = "id") int id) {
//		ArrayList<String> list = new ArrayList<String>(Arrays.asList("A","B","C"));
		id=id+10;
		return id;
	}
	
	@PostMapping(value = "api/search/searchLocalData")
	public Res searchLocalData(@RequestParam(value = "prefName") String prefName){
		return service.localSearch(prefName);
	}
	
	@PostMapping(value = "api/search/searchLineData")	
	public Res searchLineData(@RequestParam(value = "prefName")String prefName) {
		return service.lineSearch(prefName);
	}
	
	@PostMapping(value = "api/search/searchStationData")	
	public Res searchStationData(@RequestParam(value = "lineName")List<String> lineName) {
		return service.stationSearch(lineName);
	}
	
	@PostMapping(value = "api/search/prefRoute")	
	public Res prefRoute(@RequestParam(value = "prefName")String prefName) {
		return service.prefRoute(prefName);
	}
	
	@PostMapping(value = "api/search/localRoute")	
	public Res localRoute(@RequestParam(value = "localName")String localName) {
		return service.localRoute(localName);
	}
	
	@PostMapping(value = "api/search/createRoute")	
	public Res createRoute(@RequestBody CreateVo vo) {
//		System.out.println(vo.getPrefName());
		
//		return null;
		return service.createRoute(vo);
	}
	
	@GetMapping(value = "api/search/getPref")	
	public Res getPref() {
		return service.getPref();
	}
	
	@GetMapping(value = "api/search/getLocal")	
	public Res getLocal() {
		return service.getLocal();
	}
}
