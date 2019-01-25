package com.auvick.log.mapper;

import java.util.List;

import org.springframework.data.domain.Page;

import com.auvick.log.entity.Log;

public interface IMapper<E, T> {

	List<T> convertEntityToDto(List<E> listItems);
	Page<T> convertEntityToDtoPaginated(List<E> listItems);
	Page<T> convertEntityToStringPaginated(List<Log> listItems);
}
