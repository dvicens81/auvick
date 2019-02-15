package com.auvick.log.mapper;

import java.util.LinkedList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.auvick.log.dto.LogDto;
import com.auvick.log.entity.Log;

@Component
public class MapperImpl<T> implements IMapper<Log, T> {
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<T> convertEntityToDto(List<Log> listItems) {
		return getListDtos(listItems);
	}

	@Override
	public Page<T> convertEntityToDtoPaginated(List<Log> listItems) {
		List<T> listDto = getListDtos(listItems);
		return new PageImpl<>(listDto, Pageable.unpaged(), listDto.size());
	}
	
	@SuppressWarnings("unchecked")
	private List<T> getListDtos(List<Log> listItems){
		List<T> lLogsDtos = new LinkedList<>();
		for (Log log : listItems) {
			LogDto logDTO = modelMapper.map(log, LogDto.class);
			lLogsDtos.add((T)logDTO);
		}
		return lLogsDtos;
	}
	
	@Override
	public Page<T> convertEntityToStringPaginated(List<Log> listItems) {
		List<T> listDto = getListString(listItems);
		return new PageImpl<>(listDto, Pageable.unpaged(), listDto.size());
	}
	
	@SuppressWarnings("unchecked")
	private List<T> getListString(List<Log> listItems){
		List<T> lLogsDtos = new LinkedList<>();
		String[] splitRequest = null;
		for (Log log : listItems) {
			splitRequest = log.getRequest().split(" ");
			lLogsDtos.add((T)splitRequest[1]);
		}
		return lLogsDtos;
	}

}
