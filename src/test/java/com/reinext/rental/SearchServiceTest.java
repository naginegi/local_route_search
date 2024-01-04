package com.reinext.rental;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reinext.rental.entity.LocalData;
import com.reinext.rental.service.ifs.SearchService;
import com.reinext.rental.vo.CreateVo;
import com.reinext.rental.vo.Res;

@SpringBootTest
public class SearchServiceTest {

	@Autowired
	private SearchService service;
	
	@Test
	public void createTest() {

		CreateVo vo = new CreateVo("北海道","函館市","stationName","北海道函館市字川端","lineName");
		Res res = service.createRoute(vo);
		System.out.println(res.getMsgCode());
	}

	@Test
	public void createTest2() {
		
		CreateVo vo = new CreateVo("北海道","小清水","stationName","北海道函館市字川端","lineName");
		Res res = service.createRoute(vo);
		System.out.println(res.getMsgCode());
	}
	
	@Test
	public void createTest3() {
		
		CreateVo vo = new CreateVo("北海道","小清水町","小清水駅","北海道小清水町字小清水25番5号","JR小清水線");
		Res res = service.createRoute(vo);
		System.out.println(res.getMsgCode());
	}
	
	@Test
	public void createTest4() {
		
		CreateVo vo = new CreateVo("北海道","小清水町","小清水駅","北海道小清水町字小清水35番5号","JR小清水線");
		Res res = service.createRoute(vo);
		System.out.println(res.getMsgCode());
	}
	
	@Test
	public void searchTest() {
		List<LocalData> res = service.localSearch("").getLocalData();
		System.out.println();
	}
	
	
	
	
	
	
	
	
}
