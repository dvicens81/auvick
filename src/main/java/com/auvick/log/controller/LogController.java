package com.auvick.log.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auvick.log.dto.LogDto;
import com.auvick.log.service.ILogService;

@RequestMapping("/auvick")
@RestController
public class LogController {

	private ILogService logService;
	
	@Autowired
	public LogController(ILogService logService) {
		this.logService = logService;
	}

	@GetMapping(value="/log")
    public ResponseEntity<List<LogDto>> getLogsByStatusCode(@RequestParam("statusCode") int statusCode) {
		List<LogDto> lLogsDto = logService.getLogsByStatusCode(statusCode);
		return new ResponseEntity<List<LogDto>>(lLogsDto, HttpStatus.OK);
    }
	
	@GetMapping("/request")
	public ResponseEntity<Page<LogDto>> getRequestByHostName(@RequestParam("hostName") String hostName) {
		Page<LogDto> lLogsDto = logService.getLogsByHostName(hostName);
		return new ResponseEntity<Page<LogDto>>(lLogsDto, HttpStatus.OK);
    }
	
}
