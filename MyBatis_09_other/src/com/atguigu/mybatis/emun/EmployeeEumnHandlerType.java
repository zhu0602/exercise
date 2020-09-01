package com.atguigu.mybatis.emun;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.atguigu.mybatis.test.EmpStatus;

public class EmployeeEumnHandlerType implements TypeHandler<EmpStatus>{

	public static  Map<String,EmpStatus> map= new HashMap<>();
	
	  public static void EmployeeEumnHandlerType() {
		 for(EmpStatus empStatus:EmpStatus.values()) {
			 map.put(empStatus.getCode(), empStatus);
		 }
	  }
	
	/**
	 * 定义当前数据如何保存到数据库
	 */
	@Override
	public void setParameter(PreparedStatement ps, int i, EmpStatus parameter, JdbcType jdbcType) throws SQLException {
		System.out.println("保存的状态码："+parameter.getCode());
		ps.setString(i, parameter.getCode());
		
	}

	@Override
	public EmpStatus getResult(ResultSet rs, String columnName) throws SQLException {
		//需要从数据库中获取的状态码，转换成枚举
		int code = rs.getInt(columnName);
		EmpStatus empStatus = map.get(code);
		return empStatus;
	}

	@Override
	public EmpStatus getResult(ResultSet rs, int columnIndex)
			throws SQLException {
		// TODO Auto-generated method stub
		int code = rs.getInt(columnIndex);
		System.out.println("从数据库中获取的状态码："+code);
		return map.get(code);
	}

	@Override
	public EmpStatus getResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		// TODO Auto-generated method stub
		int code = cs.getInt(columnIndex);
		System.out.println("从数据库中获取的状态码："+code);
		return map.get(code);
	}


}
