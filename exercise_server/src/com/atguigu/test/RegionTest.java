package com.atguigu.test;

import java.util.List;

import org.junit.Test;

import com.atguigu.bean.Region;
import com.atguigu.dao.RegionDao;
import com.atguigu.serviceimpl.RegionDaoImpl;

public class RegionTest {
	
	private RegionDao regionDap=new RegionDaoImpl();

	@Test
	public void test() {
		List<Region> list = regionDap.getRegionByParentId(10, 0, 10);
	   list.stream().forEach(region->System.out.println(region.getName()));
	}

}
