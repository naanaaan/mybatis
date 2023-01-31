package com.my.hr.dao;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.my.hr.domain.Laborer;
import com.my.hr.domain.NoneException;

public class LaborerDaoImpl implements LaborerDao {
	private List<Laborer> laborers;
	private int laborerIdSeq;
	
	public LaborerDaoImpl(List<Laborer> laborers) {
		this.laborers = laborers;
		this.laborerIdSeq = 1;
	}
	
	@Override
	public List<Laborer> selectLaborers() {
		return laborers;
	}
	
	private Laborer selectLaborer(int laborerId) {
		List<Laborer> list = laborers.stream() //아래 filter에서 true인 값들을 stream에 추가
				.filter(laborer -> laborer.laborerId() == laborerId) //callback filter method가 laborer를 간접적으로 불러온다.
				.collect(Collectors.toList());
		
		Laborer laborer = null;
		if(list.size() != 0) laborer = list.get(0);
		
		return laborer; //key의 값 또는 null값 return. //true or false
	}
	
	@Override
	public void insertLaborer(String laborerName, LocalDate hireDate) {
		laborers.add(new Laborer(laborerIdSeq++, laborerName, hireDate));
	}
	
	@Override
	public void updateLaborer(Laborer laborer) {
		this.deleteLaborer(laborer.laborerId());
		laborers.add(laborer);
		laborers.sort(Comparator.comparing(Laborer::laborerId/*laborerId는 method다.*/)); //laborerId로 내림차순 정렬.
	}
	
	@Override
	public void deleteLaborer(int laborerId) throws NoneException {
		Laborer laborer = selectLaborer(laborerId);
		if(laborer != null) laborers.remove(laborer);
		else throw new NoneException("해당 노동자가 없습니다.");
	}
}
