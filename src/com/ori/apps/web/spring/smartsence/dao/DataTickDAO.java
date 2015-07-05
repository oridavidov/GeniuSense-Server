package com.ori.apps.web.spring.smartsence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
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
				dataTick.setLight(rs.getDouble("light"));
				dataTick.setTime(rs.getLong("time"));				

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
				dataTick.setLight(rs.getDouble("light"));
				dataTick.setTime(rs.getLong("time"));				

				return dataTick;
			}

		});
		
	}

	public int addDataTick(DataTick dt) {
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		 
		params.addValue("unitId"      , dt.getUnitId());
		params.addValue("unitType"    , dt.getUnitType());
		params.addValue("time"        , dt.getTime());
		params.addValue("temperature1", dt.getTemperature1());
		params.addValue("temperature2", dt.getTemperature2());
		params.addValue("humidity1"   , dt.getHumidity1());
		params.addValue("humidity2"   , dt.getHumidity2());
		params.addValue("light"       , dt.getLight());
		
		return jdbc.update("insert into "+dt.getUnitId()+" (time, temperature1, temperature2,"
							+ " humidity1, humidity2, light) values (:time, :temperature1, "
							+ ":temperature2, :humidity1, :humidity2, :light)", params); 		
		
	}

	public boolean isUnitRegister(String unitId) {
		return jdbc.queryForObject("SELECT count(*) from units where unit_id=:unit_id", new MapSqlParameterSource("unit_id", unitId), Integer.class) > 0;		
	}
	
}
