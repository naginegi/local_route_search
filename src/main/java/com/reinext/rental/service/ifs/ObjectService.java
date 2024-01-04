package com.reinext.rental.service.ifs;

import java.util.List;

import com.reinext.rental.vo.ObjectReq;
import com.reinext.rental.vo.ObjectRes;

public interface ObjectService {

	public ObjectRes DataSave(ObjectReq req);
	
	public List<ObjectRes> findViewData();
}
