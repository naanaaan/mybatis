package com.my.hr.dao;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.my.hr.config.Configuration;
import com.my.hr.dao.map.LaborerMap;
import com.my.hr.domain.Laborer;
import com.my.hr.domain.NoneException;

public class LaborerDaoImpl implements LaborerDao {
	private LaborerMap laborerMap;
	
	public LaborerDaoImpl(List<Laborer> laborers) {
		this.laborerMap = Configuration.getMapper(LaborerMap.class);
	}
	
	@Override
	public List<Laborer> selectLaborers() {
		return laborerMap.selectLaborers();
	}
	
	private Laborer selectLaborer(int laborerId) {
		
		List<Laborer> list = laborerMap.selectLaborers().stream() //아래 filter에서 true인 값들을 stream에 추가
				.filter(laborer -> laborer.getLaborerId() == laborerId) //callback filter method가 laborer를 간접적으로 불러온다.
				.collect(Collectors.toList());
		
		Laborer laborer = null;
		if(list.size() != 0) laborer = list.get(0);
		
		return laborer; //key의 값 또는 null값 return. //true or false
	}
	
	@Override
	public void insertLaborer(String laborerName, LocalDate hireDate) {
		laborerMap.insertLaborer(laborerName, hireDate);
	}
	
	@Override
	public void updateLaborer(Laborer laborer) {
		laborerMap.updateLaborer(laborer);
		laborerMap.selectLaborers().sort(Comparator.comparing(Laborer::getLaborerId/*laborerId는 method다.*/)); //laborerId로 내림차순 정렬.
	}
	
	@Override
	public void deleteLaborer(int laborerId) throws NoneException {
		Laborer laborer = selectLaborer(laborerId);
		if(laborer != null) laborerMap.deleteLaborer(laborerId);
		else throw new NoneException("해당 노동자가 없습니다.");
	}
}
