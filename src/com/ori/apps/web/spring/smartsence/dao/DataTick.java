package com.ori.apps.web.spring.smartsence.dao;

import java.util.Arrays;

import javax.validation.constraints.NotNull;

public class DataTick {
	
	@NotNull
	private String unitId;
	private String unitType;
	@NotNull
	private long   time;
	
    private double[] temperature;
    private double[] humidity;
	private double[] ph;
	private double[] light;
	@NotNull
	private int    errorCode;
		
	
	public DataTick() {		
	}
	
	public DataTick(long unixTime) {
		
		this.time = unixTime;
	}	
	
		
	public DataTick(String msgType, String unitId, String unitType, long time,
			double[] temperature, double[] humidity, double[] ph,
			double[] light, int errorCode) {
		super();
		this.unitId = unitId;
		this.unitType = unitType;
		this.time = time;
		this.temperature = temperature;
		this.humidity = humidity;
		this.ph = ph;
		this.light = light;
		this.errorCode = errorCode;
	}

	
	@Override
	public String toString() {
		return "DataTick [unitId=" + unitId
				+ ", unitType=" + unitType + ", time=" + time
				+ ", temperature=" + Arrays.toString(temperature)
				+ ", humidity=" + Arrays.toString(humidity) + ", ph="
				+ Arrays.toString(ph) + ", light=" + Arrays.toString(light)
				+ ", errorCode=" + errorCode + "]";
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

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
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

	public double[] getPh() {
		return ph;
	}

	public void setPh(double[] ph) {
		this.ph = ph;
	}

	public double[] getLight() {
		return light;
	}

	public void setLight(double[] light) {
		this.light = light;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

		
}
