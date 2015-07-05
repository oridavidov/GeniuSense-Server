package com.ori.apps.web.spring.smartsence.dao;

import java.sql.Date;


public class DataTick {

	private String msgType;
	private String unitId;
	private String unitType;
	private long   time;
    private double temperature1;
    private double temperature2;
	private double humidity1;
	private double humidity2;
	private double light;
		
	
	public DataTick() {		
	}
	
	public DataTick(long unixTime) {
		this.msgType = "TIME_REQUEST";
		this.time = unixTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public DataTick(String unitId, String unitType, double temperature1,
			double temperature2, double humidity1, double humidity2,
			double light, long time) {
		super();
		this.unitId = unitId;
		this.unitType = unitType;
		this.temperature1 = temperature1;
		this.temperature2 = temperature2;
		this.humidity1 = humidity1;
		this.humidity2 = humidity2;
		this.light = light;
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "DataTick [unitId=" + unitId + ", unitType=" + unitType
				+ ", temperature1=" + temperature1 + ", temperature2="
				+ temperature2 + ", humidity1=" + humidity1 + ", humidity2="
				+ humidity2 + ", light=" + light + ", time=" + time + "]";
	}

	
	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getUnitType() {
		return unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	public double getTemperature1() {
		return temperature1;
	}

	public void setTemperature1(double temperature1) {
		this.temperature1 = temperature1;
	}

	public double getTemperature2() {
		return temperature2;
	}

	public void setTemperature2(double temperature2) {
		this.temperature2 = temperature2;
	}

	public double getHumidity1() {
		return humidity1;
	}

	public void setHumidity1(double humidity1) {
		this.humidity1 = humidity1;
	}

	public double getHumidity2() {
		return humidity2;
	}

	public void setHumidity2(double humidity2) {
		this.humidity2 = humidity2;
	}

	
	public double getLight() {
		return light;
	}

	public void setLight(double light) {
		this.light = light;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}	
	
}
