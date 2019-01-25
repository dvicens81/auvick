package com.auvick.log.filter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.auvick.log.entity.Log;

@Component
public class LogFilterImpl implements IFilter<Log> {

	@Override
	public List<Log> getListFilteredByStatusCodeAndLimit(List<Log> listItems, int statusCode, int limit) {
		return listItems.stream()
				.filter(log -> (log.getStatusCode() == statusCode))
				.limit(limit)
				.collect(Collectors.toList());
	}

	@Override
	public List<Log> getListFilteredByHostName(List<Log> listItems, String hostname) {
		return listItems.stream()
				.filter(log -> (log.getHost().toLowerCase().compareTo(hostname) == 0))
				.collect(Collectors.toList());
	}

}
