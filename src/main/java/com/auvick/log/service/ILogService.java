package com.auvick.log.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.auvick.log.dto.LogDto;

public interface ILogService {

	List<LogDto> getLogsByStatusCode(int statusCode);
	Page<LogDto> getLogsByHostName(String hostname);
}
