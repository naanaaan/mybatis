package com.my.hr.config;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class Configuration {
	private static SqlSessionFactory sqlSessionFactory;//connection은 피지컬한 연결
	
	static {
		try {
			InputStream stream = Resources.getResourceAsStream("com/my/hr/config/sqlMapConfig.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream, "hr2");
		} catch(Exception e) {
			e.printStackTrace();
			
		}
	}

	public static <T> T getMapper(Class<T> arg) {
		return sqlSessionFactory.openSession(true).getMapper(arg);
	}
}
