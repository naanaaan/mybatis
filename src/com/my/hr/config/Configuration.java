package com.my.hr.config;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class Configuration {
	private static SqlSessionFactory sqlSessionFactory;//connection은 피지컬한 연결
	
	static {
		try {
			Reader reader = Resources.getResourceAsReader("config/sqlMapConfig.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch(Exception e) {
			e.printStackTrace();
			
		}
	}

	public static <T> T getMapper(Class<T> arg) {
		return sqlSessionFactory.openSession(true).getMapper(arg);
	}
}