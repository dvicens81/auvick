package com.auvick.log.filter;

import java.util.List;

public interface IFilter<T> {
	
	List<T> getListFilteredByStatusCodeAndLimit(List<T> listItems, int statusCode, int limit );
	
	List<T> getListFilteredByHostName(List<T> listItems, String hostname );

}
