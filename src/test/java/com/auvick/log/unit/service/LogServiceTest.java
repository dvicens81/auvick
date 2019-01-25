package com.auvick.log.unit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.auvick.log.dto.LogDto;
import com.auvick.log.entity.Log;
import com.auvick.log.mapper.IMapper;
import com.auvick.log.repository.IlogRepository;
import com.auvick.log.service.ILogService;
import com.auvick.log.service.LogServiceImpl;

public class LogServiceTest {
	
	private ILogService logService;
	private Log log;
	private IlogRepository logRepository;
	private LogDto logDto;
	private IMapper<Log, LogDto> modelmapper;
	private Page<LogDto> page;
	
	@SuppressWarnings("unchecked")
	@BeforeEach
	public void setUp() {
		logRepository = Mockito.mock(IlogRepository.class);
		modelmapper = Mockito.mock(IMapper.class);
		logService = new LogServiceImpl(logRepository, modelmapper);
		log = new Log("141.243.1.172", "[29:23:53:25]", "\"GET /Software.html HTTP/1.0\"", 200, 1497);
		logDto = new LogDto();
		logDto.setHost("141.243.1.172");
		logDto.setBytes(1497);
		logDto.setDate("[29:23:53:25]");
		logDto.setRequest("GET /Software.html HTTP/1.0");
		logDto.setStatusCode(200);
		page = new PageImpl<LogDto>(Arrays.asList(logDto));
	}
	
	@Test
	public void getLogsDtoByStatusCode() {
		int statusCode = 200;
		Mockito.when(logRepository.getLogsByStatusCode(statusCode)).thenReturn(Arrays.asList(log));
		Mockito.when(modelmapper.convertEntityToDto(Arrays.asList(log))).thenReturn(Arrays.asList(logDto));
		List<LogDto> lLogsDto = logService.getLogsByStatusCode(statusCode);
		assertEquals(lLogsDto, Arrays.asList(logDto));
	}
	
	@Test
	public void getLogsDtoByHostName() {
		String hostname = "141.243.1.172";
		Mockito.when(logRepository.getLogsByHostName(hostname)).thenReturn(Arrays.asList(log));
		Mockito.when(modelmapper.convertEntityToStringPaginated(Arrays.asList(log))).thenReturn(page);
		Page<LogDto> lLogsDto = logService.getLogsByHostName(hostname);
		assertEquals(lLogsDto, page);		
	}
}
