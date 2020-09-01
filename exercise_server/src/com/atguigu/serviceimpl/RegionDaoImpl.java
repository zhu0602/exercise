package com.atguigu.serviceimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.atguigu.bean.Region;
import com.atguigu.dao.RegionDao;

public class RegionDaoImpl implements RegionDao {
	private final String URL = "jdbc:mysql://localhost:3306/webservice";
	private final String USERNAME = "root";
	private final String PASSWORD = "root";
	private final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

	@Override
	public List<Region> getRegionByParentId(Integer id, Integer index, Integer size) {
		Connection connection=null;
		PreparedStatement statement =null;
		ResultSet result=null;
		 List<Region> list = new ArrayList<Region>();
		try {
			Class.forName(DRIVER_CLASS);
			connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			String sql = "SELECT * FROM tp_region2 WHERE parent_id= ? LIMIT ?,?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.setInt(2, index);
			statement.setInt(3, size);
			result = statement.executeQuery();
		  
			while (result.next()) {
				Region region = new Region();
				int region_id = result.getInt("id");
				String name  = result.getString("name");
				region.setId(region_id);
				region.setName(name);
				list.add(region);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (result!=null) {
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}

		return list;
	}

}
