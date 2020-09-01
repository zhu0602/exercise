package com.atguigu.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

import com.atguigu.bean.Region;
import com.atguigu.dao.RegionDao;
import com.atguigu.service.RegionService;

@WebService
public class RegionServiceImpl implements RegionService {
	
	private  RegionDao regionDao=new RegionDaoImpl();

	public  String getRegionByParentId(String xmlString) {
		//解 析 xml字符串为map
		Map<String, Integer> map =ParseXmlStringToMap(xmlString);
		List<Region> list = regionDao.getRegionByParentId(map.get("id"),map.get("index"), map.get("size"));
		String parsexml = parseListToxmlString(list);
		return parsexml;
	}

	private  String parseListToxmlString(List<Region> list) {
		Document document = DocumentHelper.createDocument();
		Element element = document.addElement("areas");
		for (Region region : list) {
			Element areaElement = element.addElement("area");
			areaElement.addElement("id").setText(String.valueOf(region.getId()));
			areaElement.addElement("name").setText(region.getName());
		}
		
		return document.asXML();
	}

	private  Map<String, Integer> ParseXmlStringToMap(String xmlString) {
		try {
			//将xml字符串转化为document文档形式
			Document document = DocumentHelper.parseText(xmlString);
			//document中获取参数
			Node id = document.selectSingleNode("//id");
			Node index  = document.selectSingleNode("//index");
			Node size  = document.selectSingleNode("//size");
			
			Map<String,Integer> map = new HashMap<String, Integer>();
			map.put("id", Integer.parseInt(id.getText()));
			int sizeInt = Integer.parseInt(size.getText());
			map.put("size",sizeInt);
			map.put("index",(Integer.parseInt(index.getText())-1)*sizeInt);
			return map;
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
//	public static void main(String[] args) {
//		//模拟客户端传递过来的xml字符串
//		String xmlString="<param>"
//				+ "<id>10</id>"
//				+ "<index>1</index>"
//				+"<size>10</size>"
//				+ "</param>";
//		String reslut = getRegionByParentId(xmlString);
//		System.out.println(reslut);
//	}

}
