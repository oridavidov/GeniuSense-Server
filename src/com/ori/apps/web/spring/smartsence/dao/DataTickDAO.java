package com.ori.apps.web.spring.smartsence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("dataTickDao")
public class DataTickDAO {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<DataTick> getAllData() {

		return jdbc.query("select * from data", new RowMapper<DataTick>() {

			public DataTick mapRow(ResultSet rs, int rowNum) throws SQLException {
				DataTick dataTick = new DataTick();

				//dataTick.setTemperature(rs.getDouble("temperature"));
				//dataTick.setHumidity(rs.getDouble("humidity"));
				//dataTick.setLight(rs.getDouble("light"));
				//dataTick.setTime(rs.getDate("time"));				

				return dataTick;
			}

		});
	}

	public List<DataTick> getLastData() {
		
		return jdbc.query("SELECT * FROM data LIMIT 10", new RowMapper<DataTick>() {

			public DataTick mapRow(ResultSet rs, int rowNum) throws SQLException {
				DataTick dataTick = new DataTick();

				//dataTick.setTemperature(rs.getDouble("temperature"));
				//dataTick.setHumidity(rs.getDouble("humidity"));
				//dataTick.setLight(rs.getDouble("light"));
				//dataTick.setTime(rs.getLong("time"));				

				return dataTick;
			}

		});
	}

	public List<DataTick> getDataByTime(int time) {
		return jdbc.query("SELECT * FROM data WHERE timee="+time, new RowMapper<DataTick>() {

			public DataTick mapRow(ResultSet rs, int rowNum) throws SQLException {
				DataTick dataTick = new DataTick();

				//dataTick.setTemperature(rs.getDouble("temperature"));
				//dataTick.setHumidity(rs.getDouble("humidity"));
				//dataTick.setLight(rs.getDouble("light"));
				//dataTick.setTime(rs.getLong("time"));				

				return dataTick;
			}

		});
		
	}

	public int addDataTick(DataTick dt) {
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		 
		params.addValue("unitId"      , dt.getUnitId());
		params.addValue("time"        , dt.getTime());
		switch (dt.getUnitType()) {
			case "A": {
				for (int i=0; i<4; i++) {
					params.addValue("temperature"+(i+1), (dt.getTemperature())[i]);
				}				
				for (int i=0; i<4; i++) {
					params.addValue("humidity"+(i+1), (dt.getHumidity())[i]);
				}				
				for (int i=0; i<2; i++) {
					params.addValue("light"+(i+1), (dt.getLight())[i]);
				}
				for (int i=0; i<1; i++) {
					params.addValue("ph"+(i+1), (dt.getPh())[i]);
				}
				
				return jdbc. update("insert into "+dt.getUnitId()+" (time, temperature1, temperature2,"
						+ " temperature3, temperature4, humidity1, humidity2, humidity3, humidity4,"
						+ " light1, light2, ph1) values (:time, :temperature1, :temperature2,"
						+ ":temperature3, :temperature4, :humidity1, :humidity2, :humidity3,"
						+ ":humidity4, :light1, :light2, :ph1)", params); 
			}	
			
			default: {
				System.out.println("got unknown unit type");
				return 0;
			}
		}			
		
	}

	public boolean isUnitRegister(String unitId) {
		return jdbc.queryForObject("SELECT count(*) from units where unit_id=:unit_id", new MapSqlParameterSource("unit_id", unitId), Integer.class) > 0;		
	}
	
}
