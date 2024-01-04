package com.reinext.rental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reinext.rental.constants.MsgCode;
import com.reinext.rental.service.ifs.SearchService;
import com.reinext.rental.vo.CreateVo;

//import ch.qos.logback.core.model.Model;

@Controller
public class SearchController {

	@Autowired
	private SearchService service;

	/*
	 * @RequestMapping(value = "/front") public void front() {
	 * 
	 * };
	 */
	@RequestMapping(value = "/back")
	public void back() {

	};

	@GetMapping(value = "/frontLocal")
	public String frontLocal(Model model) {
		model.addAttribute("total_data", service.getPref().getStr());
//	    model.addAttribute("local_data");
		return "frontLocal";
	}

	@GetMapping(value = "/frontLine")
	public String frontStation(Model model) {
		model.addAttribute("total_data", service.getPref().getStr());
//	    model.addAttribute("local_data");
		return "frontLine";
	}

	@PostMapping(value = "/frontLocal")
	public String front_searchLocal(@RequestParam(name = "select_pref") String select_pref, Model model) {
		System.out.println("Selected Area: " + select_pref);
//		model.addAttribute("select_pref", selectedArea);
		model.addAttribute("total_data", service.getPref().getStr());
		model.addAttribute("local_data", service.localSearch(select_pref).getLocalData());
		model.addAttribute("prefName", select_pref);

		return "frontLocal";
	}

	@PostMapping(value = "/frontLine")
	public String front_searchLine(@RequestParam(name = "select_pref") String select_pref, Model model) {
		System.out.println("Selected Area: " + select_pref);
//		model.addAttribute("select_pref", selectedArea);
		model.addAttribute("total_data", service.getPref().getStr());
		model.addAttribute("line_data", service.prefRoute(select_pref).getStr());
//		model.addAttribute("prefName", select_pref);

		return "frontLine";
	}

	@PostMapping(value = "/frontStation")
	public String front_searchStation(@RequestParam(name = "checkbox") List<String> checkbox, Model model) {
		for (String che : checkbox) {
			System.out.println(che);
		}
		model.addAttribute("line_data", checkbox);
		model.addAttribute("station_data", service.stationSearch(checkbox).getStationData());

		return "frontStation";
	}

////////////////////////////////////////////////////////////////

	@GetMapping(value = "/back")
	public String backGetPref(Model model) {
		model.addAttribute("pref_data", service.getPref().getStr());
		model.addAttribute("local_data", service.getLocal().getStr());
		return "back";
	}

	@GetMapping(value = "/backPrefLine")
	public String getbackPrefLine(Model model) {
		model.addAttribute("pref_data", service.getPref().getStr());
		model.addAttribute("local_data", service.getLocal().getStr());
		return "backPrefLine";
	}

	@GetMapping(value = "/backLocalLine")
	public String getbackLocalLine(Model model) {
		model.addAttribute("pref_data", service.getPref().getStr());
		return "backLocalLine";
	}

	@GetMapping(value = "/backPrefLocal")
	public String getbackPrefLocal(Model model) {
		model.addAttribute("pref_data", service.getPref().getStr());
		return "backLocalLine";
	}

	@GetMapping(value = "/backCreate")
	public String getbackCreate(Model model) {
		model.addAttribute("pref_data", service.getPref().getStr());
		model.addAttribute("local_data", service.getLocal().getStr());
		model.addAttribute("total_data", service.localSearch(""));

		return "backCreate";
	}

	//用都道府找路線
	@PostMapping(value = "/backPrefLine")
	public String backPrefLine(@RequestParam(name = "select_pref") String select_pref, Model model) {
		model.addAttribute("pref_data", service.getPref().getStr());
		model.addAttribute("line_data", service.prefRoute(select_pref).getStr());

		return "backPrefLine";
	}

	
	@PostMapping(value = "/backPrefLocal")
	public String backPrefLocal(@RequestParam(name = "select_pref") String select_pref, Model model) {
		model.addAttribute("pref_data", service.getPref().getStr());

		model.addAttribute("pref", select_pref);
		model.addAttribute("local_data", service.localSearch(select_pref).getLocalData());
		return "backLocalLine";

	}

	@PostMapping(value = "/backLocalLine")
	public String backLocalLine(@RequestParam(name = "select_local") String select_local,
			@RequestParam(name = "pref") String select_pref, Model model) {
		model.addAttribute("pref_data", service.getPref().getStr());
		model.addAttribute("pref", select_pref);
		model.addAttribute("local_data", service.localSearch(select_pref).getLocalData());
		List<String> res = service.localRoute(select_local).getStr();
		if (res.isEmpty()) {
			res.add("路線のデータがありません");
			model.addAttribute("line", res);
		} else {
			model.addAttribute("line", res);
		}

		return "backLocalLine";
	}

	@PostMapping(value = "/backCreate")
	public String backCreate(//
			@RequestParam(name = "prefName") String prefName,//
			@RequestParam(name = "localName") String localName, //
			@RequestParam(name = "lineName") String lineName,//
			@RequestParam(name = "stationName") String stationName, //
			@RequestParam(name = "address") String address,//
//			@RequestParam(name = "code") String code,//
			Model model) {
		CreateVo vo = new CreateVo(prefName,localName,stationName,address,lineName);
		String res = service.createRoute(vo).getMsgCode().getMessage();
		model.addAttribute("code", res);
		System.out.println(res);
		return "backCreate";
	}

	/////////////////////////////////////////////////////////////////////////////////////////

	
	
	@RequestMapping(value = "/house/houseHome")
	public String houseHome() {
		
		return "house/houseHome";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/sample")
	public void sample() {

	}
	
	

}
