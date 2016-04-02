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
		String query;
		 
		params.addValue("time", dt.getTime());
		
		for (int i=0; i<dt.getTemperature().length; i++) {
			params.addValue("temperature"+(i+1), (dt.getTemperature())[i]);
		}				
		for (int i=0; i<dt.getHumidity().length; i++) {
			params.addValue("humidity"+(i+1), (dt.getHumidity())[i]);
		}				
		for (int i=0; i<dt.getLight().length; i++) {
			params.addValue("light"+(i+1), (dt.getLight())[i]);
		}
		for (int i=0; i<dt.getPh().length; i++) {
			params.addValue("ph"+(i+1), (dt.getPh())[i]);
		}
		query = "insert into data" + dt.getUnitId() + " (time, ";
		for (int i=0; i<dt.getTemperature().length; i++) {
			query.concat("temperature" + (i+1) + ",");
		}
		for (int i=0; i<dt.getHumidity().length; i++) {
			query.concat("humidity" + (i+1) + ",");
		}
		for (int i=0; i<dt.getLight().length; i++) {
			query.concat("light" + (i+1) + ",");
		}
		for (int i=0; i<dt.getPh().length; i++) {
			query.concat("ph" + (i+1) + ",");
		}
		query.concat(" values (time, ");
		
		for (int i=0; i<dt.getTemperature().length; i++) {
			query.concat(":temperature" + (i+1) + ",");
		}
		for (int i=0; i<dt.getHumidity().length; i++) {
			query.concat(":humidity" + (i+1) + ",");
		}
		for (int i=0; i<dt.getLight().length; i++) {
			query.concat(":light" + (i+1) + ",");
		}
		for (int i=0; i<dt.getPh().length; i++) {
			query.concat(":ph" + (i+1) + ",");
		}
				
		return jdbc. update(query, params); 		
	}

	public boolean isUnitRegister(String unitId) {
		return jdbc.queryForObject("SELECT count(*) from units where unit_id=:unit_id", new MapSqlParameterSource("unit_id", unitId), Integer.class) > 0;		
	}
	
}
