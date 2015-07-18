package com.ori.apps.web.spring.smartsence.dao;

import java.sql.Date;
import java.util.Arrays;


public class DataTick {

	private String   msgType;
	private String   unitId;
	private String   unitType;
	private long     time;
    private double[] temperature;
    private double[] humidity;
	private double[] ph;
	private int[]    light;
		
	
	public DataTick() {		
	}
	
	public DataTick(long unixTime) {
		this.msgType = "TIME_REQUEST";
		this.time = unixTime;
	}
	
	public DataTick(String msgType, String unitId, String unitType, long time,
			double[] temperature, double[] humidity, double[] ph, int[] light) {
		super();
		this.msgType = msgType;
		this.unitId = unitId;
		this.unitType = unitType;
		this.time = time;
		this.temperature = temperature;
		this.humidity = humidity;
		this.ph = ph;
		this.light = light;
	}
	
	@Override
	public String toString() {
		return "DataTick [msgType=" + msgType + ", unitId=" + unitId
				+ ", unitType=" + unitType + ", time=" + time
				+ ", temperature=" + Arrays.toString(temperature)
				+ ", humidity=" + Arrays.toString(humidity) + ", ph="
				+ Arrays.toString(ph) + ", light=" + Arrays.toString(light)
				+ "]";
	}	

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
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

	public double[] getTemperature() {
		return temperature;
	}

	public void setTemperature(double[] temperature) {
		this.temperature = temperature;
	}

	public double[] getHumidity() {
		return humidity;
	}

	public void setHumidity(double[] humidity) {
		this.humidity = humidity;
	}

	
	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public double[] getPh() {
		return ph;
	}

	public void setPh(double[] ph) {
		this.ph = ph;
	}

	public int[] getLight() {
		return light;
	}

	public void setLight(int[] light) {
		this.light = light;
	}	
	
}
