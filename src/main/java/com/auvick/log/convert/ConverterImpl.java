package com.auvick.log.convert;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.auvick.log.entity.Log;

@Component
class ConverterImpl<T> implements IConverter<T> {
	
	private static final String REGEX = "^([\\d-\\w.]+)\\s(\\[\\d{2}\\:\\d{2}\\:\\d{2}\\:\\d{2}\\])\\s(\"(.+?)\")\\s(\\d{3})\\s(\\d+)"; //IP - HOSTNAME


	@SuppressWarnings("unchecked")
	@Override
	public List<T> convertLogFileInEntityLog(List<String> lAccessLog) {
		List<T> lLogs = new LinkedList<T>();
		Log log = null;
		for (String lineLog : lAccessLog) {
			Matcher matcher = getMatchByPattern(REGEX, lineLog);
			if (!matcher.matches()) continue; 
			log = new Log(matcher.group(1),
							matcher.group(2),
							matcher.group(3),
							new Integer(matcher.group(5)),
							Double.parseDouble(matcher.group(6)));
			lLogs.add((T)log);			
		}
		
		return lLogs;
	}
	
	private Matcher getMatchByPattern(String regex, String lineLog) {
		//REGEX HOSTNAME =  ^([\\d.]+)
		//REGEX DATE = (^\\[\\d{2}\\:\\d{2}\\:\\d{2}\\:\\d{2}\\])
		//REGEX REQUEST = (\"(.+?)\")
		//REGEX RESPONSE = (\\d{3})
		//REGEX BYTES = (\\d+)
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(lineLog);

		return matcher;
	}

}
