package com.auvick.log.integration.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.auvick.log.LogApplication;
import com.auvick.log.dto.LogDto;
import com.auvick.log.service.ILogService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes=LogApplication.class)
public class LogServiceIntegrationTest {
	
	@Autowired
	private ILogService service;
	
	@Test
	public void getLogsByStatusCode() throws Exception {
		List<LogDto> lLogs = service.getLogsByStatusCode(200);
		assertNotNull(lLogs);
		assertEquals(lLogs.size(), 8);
	}
	
	@Test
	public void getLogsByIP() throws Exception {
		Page<LogDto> lLogs = service.getLogsByHostName("140.112.68.165");
		assertNotNull(lLogs);
		assertEquals(lLogs.getNumberOfElements(), 1);
	}
	
	@Test
	public void getLogsByHostName() throws Exception {
		Page<LogDto> lLogs = service.getLogsByHostName("wpbfl2-45.gate.net");
		assertNotNull(lLogs);
		assertEquals(lLogs.getNumberOfElements(), 5);
	}
}
