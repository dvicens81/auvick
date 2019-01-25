package com.auvick.log.entity;

public class Log {
	private String host;
	private String date;
	private String request;
	private int statusCode;
	private double bytes;
	
	public Log(String host, String date, String request, int statusCode, double bytes) {
		super();
		this.host = host;
		this.date = date;
		this.request = request;
		this.statusCode = statusCode;
		this.bytes = bytes;
	}
	
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
