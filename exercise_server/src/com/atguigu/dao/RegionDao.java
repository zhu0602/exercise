package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.Region;

public interface RegionDao {

	public List<Region> getRegionByParentId(Integer id,Integer index,Integer size);
	
}
