package com.zfgc.zfgbb.dataprovider;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDataProvider {
	@Autowired
	protected DozerBeanMapper mapper;
	
	public <T,U> List<U> convertDboListToModel(List<T> input, Class<U> type){
		if(input != null) {
			return input.stream().map(x -> mapper.map(x, type)).collect(Collectors.toList());
		}
		
		return new ArrayList<U>();
	}
}