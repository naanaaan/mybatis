package config;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Configuration {
	private static SqlSessionFactory sqlSessionFactory;//connection은 피지컬한 연결
	//session은 로지컬한 연결
	//mybatis 패키지 추가해야함
	//config패키지 보기엔 2개지만 실제론 1개 패키지임 
	static {
		try {
			Reader reader = Resources.getResourceAsReader("config/sqlMapConfig.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	//mapper풀에는 mapper가 있는데 구분을 데이터타입으로 구분할것이고 arg타입의 매퍼를 골라내겠따.
	//이작업을 누구한테 시키냐 session객체한테 시킨다. sqlsessionfatory를 통해서
	//session을통해서 request response를한다 connetion이랑 똑같음
	public static <T> T getMapper(Class<T> arg) {
		return sqlSessionFactory.openSession(true).getMapper(arg);//true auto commit하겠따.
		//true를 하면 자동commit인데 transaction이 짧을 때 주로쓰며
		//batch작업을 할때 보통 오래걸리므로 false를 쓴다.
		
	}
}
