package ch02.ex01;

import java.util.List;

import ch02.domain.User;

public interface Map {
	List<User> selectUsers();//mybatis에서 자바코딩을 알아서 해주며 sql코드는 우리가해야함
	//따로 문서를 만들어서 sql을 작성함
}
