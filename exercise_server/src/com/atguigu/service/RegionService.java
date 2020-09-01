package com.atguigu.service;

import javax.jws.WebService;

@WebService
public interface RegionService {

	public String getRegionByParentId (String xmlString);
	
	
}
