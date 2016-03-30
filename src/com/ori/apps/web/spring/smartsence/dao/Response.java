package com.ori.apps.web.spring.smartsence.dao;

public class Response {
	
	private String result;

	public Response() {
		
	}

	@Override
	public String toString() {
		return "Response [result=" + result + "]";
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
