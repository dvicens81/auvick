package com.auvick.log.unit.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.auvick.log.controller.LogController;
import com.auvick.log.dto.LogDto;
import com.auvick.log.service.ILogService;

public class LogControllerTest {
	
	private LogController logController;
	private ILogService logService;
	private LogDto logDto;
	private Page<LogDto> page;
	private List<String> lRequest;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@BeforeEach
	public void setUp() {
		logService = Mockito.mock(ILogService.class);
		logController = new LogController(logService);
		logDto = new LogDto();
		logDto.setHost("141.243.1.172");
		logDto.setBytes(1497);
		logDto.setDate("[29:23:53:25]");
		logDto.setRequest("GET /Software.html HTTP/1.0");
		logDto.setStatusCode(200);
		lRequest = new ArrayList<String>();
		lRequest.add("www.google.com");
		page = new PageImpl(lRequest);
	}
	
	@Test
	public void getLogsByStatusCode() {
		int statusCode = 200;
		Mockito.when(logService.getLogsByStatusCode(statusCode)).thenReturn(Arrays.asList(logDto));
		ResponseEntity<List<LogDto>> httpResponse = logController.getLogsByStatusCode(statusCode);

        assertEquals(httpResponse.getStatusCode(), HttpStatus.OK);
        assertEquals(Arrays.asList(logDto), httpResponse.getBody());
	}
	
	@Test
	public void getLogsByHostName() {
		String hostname = "tanuki.twics.com";
		Mockito.when(logService.getLogsByHostName(hostname)).thenReturn(page);
		ResponseEntity<Page<LogDto>> httpResponse = logController.getRequestByHostName(hostname);

        assertEquals(httpResponse.getStatusCode(), HttpStatus.OK);
        assertEquals(page, httpResponse.getBody());
	}
	

}
