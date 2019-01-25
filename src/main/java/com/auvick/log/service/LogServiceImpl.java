package com.auvick.log.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.auvick.log.dto.LogDto;
import com.auvick.log.entity.Log;
import com.auvick.log.mapper.IMapper;
import com.auvick.log.repository.IlogRepository;

@Service
public class LogServiceImpl implements ILogService {
	
	
	private IlogRepository logRepository;
	
    private IMapper<Log, LogDto> mapper;
	@Autowired
	public LogServiceImpl(IlogRepository logRepository, IMapper<Log, LogDto> mapper) {
		this.logRepository = logRepository;
		this.mapper = mapper;
	}

	@Override
	public List<LogDto> getLogsByStatusCode(int statusCode) {
		List<Log> lLogs = logRepository.getLogsByStatusCode(statusCode);
		if (lLogs == null || lLogs.isEmpty()) return new ArrayList<LogDto>();
		return mapper.convertEntityToDto(lLogs);
	}

	@Override
	public Page<LogDto> getLogsByHostName(String hostname) {
		List<Log> lLogs = logRepository.getLogsByHostName(hostname);
		return mapper.convertEntityToStringPaginated(lLogs);
	}
}
