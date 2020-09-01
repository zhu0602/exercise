package com.atguigu.test;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;

public class Demo {

	public static void main(String[] args) throws Exception {
		// 自己模拟HTTP请求调用WebService
		// 1.设置服务的地址
		URL url = new URL("http://localhost:8888/weather");
		// 2.打开一个链接
		HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();
		// 3.设置请求头
		// 设置请求方式
		openConnection.setRequestMethod("POST");
		// 设置请求的数据类型
		openConnection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
		//4. 设置可以读写的权限，默认是不能给请求体中写入东西的
		openConnection.setDoInput(true);
		openConnection.setDoOutput(true);
		//5. 获取调用的方法,并写入参数
		String xmlString = getSentXmlStirng();
		//6. 把xml写入到请求体重
		openConnection.getOutputStream().write(xmlString.getBytes());
		// 7.200表示响应成功
		if (200 == openConnection.getResponseCode()) {
			//8. 服务端响应的数据都在流中
			InputStream inputStream = openConnection.getInputStream();
			Scanner scanner = new Scanner(inputStream);
			//9. 准备一个buffer用来接收从流中读取中的数据
			StringBuffer stringBuffer=new StringBuffer();
			while (scanner.hasNextLine()) {
				//10. 一行一行的获取流中数据
				stringBuffer.append(scanner.nextLine());
			}
			//11. 关闭流
			scanner.close();
			// 解析xml
			String info=parseXml(stringBuffer.toString());
		}
	}

	private static String parseXml(String xmlString) throws Exception {
		//把xml字符串转成document对象
		Document document = DocumentHelper.parseText(xmlString);
		Node node = document.selectSingleNode("//return");
		String returnInfo = node.getText();
		System.out.println(returnInfo);
		return null;
	}

	private static String getSentXmlStirng() {
		String xmlString = "<?xml version=\"1.0\" ?>"
				+ "<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">" + "<S:Body>"
				+ "<ns2:getCity xmlns:ns2=\"http://test.auguigu.com/\">" + "<arg0>北京</arg0></ns2:getCity>" + "</S:Body>"
				+ "</S:Envelope>";
		return xmlString;
	}

}
