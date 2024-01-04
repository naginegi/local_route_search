package com.reinext.rental.service.ifs;

import java.util.List;

import com.reinext.rental.vo.CreateVo;
import com.reinext.rental.vo.Res;

public interface SearchService {
	
	
	public Res getLocal();
	
	public Res getPref();

	public Res localSearch(String prefName);
	
	public Res lineSearch(String prefName);
	
	public Res stationSearch(List<String> lineName);
	
	public Res prefRoute(String prefName);

	public Res localRoute(String localName);

	public Res createRoute(CreateVo vo);

	public Res getLocalDataTables();
	
	public Res getLineStation();
	
//	public Res searchAll();
}
