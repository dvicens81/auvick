package com.auvick.log.integration.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.auvick.log.LogApplication;
import com.auvick.log.entity.Log;
import com.auvick.log.repository.IlogRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes=LogApplication.class)
public class LogRepositoryIntegrationTest {
	
	@Autowired
	private IlogRepository repository;
	
	@Test
	public void getLogsByStatusCode() throws Exception {
		List<Log> lLogs = repository.getLogsByStatusCode(200);
		assertNotNull(lLogs);
		assertEquals(lLogs.size(), 8);
	}
	
	@Test
	public void getLogsByIP() throws Exception {
		List<Log> lLogs = repository.getLogsByHostName("140.112.68.165");
		assertNotNull(lLogs);
		assertEquals(lLogs.size(), 1);
	}
	
	@Test
	public void getLogsByHostName() throws Exception {
		List<Log> lLogs = repository.getLogsByHostName("tanuki.twics.com");
		assertNotNull(lLogs);
		assertEquals(lLogs.size(), 1);
	}

}
