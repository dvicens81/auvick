package com.auvick.log.repository;

import java.util.List;

import com.auvick.log.entity.Log;

public interface IlogRepository {

	public List<Log> getLogsByStatusCode(int statusCode);
	
	public List<Log> getLogsByHostName(String hostName);
}
