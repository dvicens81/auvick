package com.auvick.log.repository;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auvick.log.convert.IConverter;
import com.auvick.log.entity.Log;
import com.auvick.log.filter.IFilter;

@Component
public class LogRepositoryImpl implements IlogRepository {
	private static final String LOG_FILE = "/access.log";
	private static List<String> accessLogFile = new LinkedList<>();
	
	@Autowired
	private IConverter<Log> converter;
	@Autowired
	private IFilter<Log> filter;

    static {
        try (InputStream input = LogRepositoryImpl.class.getResourceAsStream(LOG_FILE)) {        	
            accessLogFile = IOUtils.readLines(input, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

	@Override
	public List<Log> getLogsByStatusCode(int statusCode) {
		List<Log> lLogs = converter.convertLogFileInEntityLog(accessLogFile);
		return filter.getListFilteredByStatusCodeAndLimit(lLogs, statusCode, 10);
	}

	@Override
	public List<Log> getLogsByHostName(String hostName) {
		List<Log> lLogs = converter.convertLogFileInEntityLog(accessLogFile);
		return filter.getListFilteredByHostName(lLogs, hostName);
	}
}
