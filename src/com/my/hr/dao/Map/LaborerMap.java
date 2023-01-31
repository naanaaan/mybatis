package com.my.hr.dao.Map;

import java.util.List;

import com.my.hr.domain.Laborer;

public interface LaborerMap {
	List<Laborer> selectLaborers();
	int selectlaborerSqe();
}
