package com.my.hr;

import com.my.hr.config.Configuration;
import com.my.hr.dao.Map.LaborerMap;

public class Main {
	public static void main(String[] args) {
//		List<Laborer> laborers = new ArrayList<>();
//		
//		LaborerDao laborerDao = new LaborerDaoImpl(laborers);
//		LaborerService laborerService = new LaborerServiceImpl(laborerDao);
//		LaborerIo laborerIo	= new LaborerIo(laborerService);
//		
//		laborerIo.play();
//		Console.info("end.");
		LaborerMap mapper = Configuration.getMapper(LaborerMap.class);
		mapper.selectLaborers();
	}
}
