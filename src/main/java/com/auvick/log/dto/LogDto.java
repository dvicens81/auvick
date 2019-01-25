package com.auvick.log.dto;

public class LogDto {
	
	private String host;
	private String date;
	private String request;
	private int statusCode;
	private double bytes;	
	
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public double getBytes() {
		return bytes;
	}
	public void setBytes(double bytes) {
		this.bytes = bytes;
	}

}
