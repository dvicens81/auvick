package com.auvick.log.convert;

import java.util.List;

public interface IConverter<T> {

	List<T> convertLogFileInEntityLog(List<String> lAccessLog);
	
	//List<T> getRequestFiltered(List<String> lAccessLog);
}
