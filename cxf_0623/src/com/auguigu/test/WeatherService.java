package com.auguigu.test;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface WeatherService {

	public String getCity(@WebParam(name = "cityName")String name);
}
