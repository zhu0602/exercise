package com.atguigu.serviceimpl;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class ClientInvocation {

	public static void main(String[] args) throws Exception {
	//设置url
	URL url = new URL("http://localhost:7777/areas?wsdl");
	//设置nameSpace和服务视名称
	QName qName=new QName("http://serviceimpl.atguigu.com/","RegionServiceImplService");
	//创建服务试图
	Service service = Service.create(url,qName);
	//获取服务的实现类
	RegionServiceImpl serviceImpl = service.getPort(RegionServiceImpl.class);
	//调用方法
	String id="10";
	String index="1";
	String size="10";
	//把参数封装到xml中
	String xmlString=getXmlStr(id,index,size);
	String result = serviceImpl.getRegionByParentId(xmlString);
	//客户端将xmlString数据转换成Map
	List<Map<String, Object>> list=getParseXmlStringToList(result);
	
	for (Map<String, Object> map : list) {
		System.out.println(map);
	}
	}

	private static List<Map<String, Object>> getParseXmlStringToList(String xmlString) throws Exception {
		List<Map<String, Object>> list= new  ArrayList<Map<String, Object>>();
		
		Document document = DocumentHelper.parseText(xmlString);
       //获取根节点
       Element rootElement = document.getRootElement();
       //获取根节点下的子节点
       Iterator<Element> iterator = rootElement.elementIterator();
       
       while (iterator.hasNext()) {
    	Map<String, Object> map = new HashMap<String, Object> ();
		Element element = iterator.next();
		String id = element.selectSingleNode("id").getText();
		String name= element.selectSingleNode("name").getText();
		map.put("id",id);
		map.put("name",name);
		list.add(map);
	}
 
       return list;
	}

	private static String getXmlStr(String id, String index, String size) {
		Document createDocument = DocumentHelper.createDocument();
		//创建根节点
		Element element = createDocument.addElement("param");
		element.addElement("id").setText(id);
		element.addElement("index").setText(index);
		element.addElement("size").setText(size);
		return element.asXML();
	}
}
