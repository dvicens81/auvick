package com.auvick.log.integration.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.auvick.log.LogApplication;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes=LogApplication.class)
public class LogControllerIntegrationTest {
	
	@Autowired
	private WebApplicationContext wap;
	private MockMvc mockMvc;
	
	@BeforeEach
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wap).build();
	}
	
	@Test
	public void getLogByStatusCode() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/auvick/log?statusCode=200"))	
						.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void getLogByHostName() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/auvick/request?hostName=wpbfl2-45.gate.net"))	
						.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void getLogWithoutStatusCode() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/auvick/log"))	
						.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

}
