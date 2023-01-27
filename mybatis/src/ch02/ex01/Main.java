package ch02.ex01;

import java.util.List;

import ch02.domain.User;
import config.Configuration;

public class Main {
	public static void main(String[] args) {
		Map mapper = Configuration.getMapper(Map.class);
//		Class<ch02.ex01.Map> 꺼낸 맵퍼객체를 꺼내서 mapper에 넣은것
		
		List<User> users = mapper.selectUsers();
		//forEach(x -> System.out.println(x) 요약한거
		users.forEach(System.out::println);
		System.out.println(mapper.selectUsers());
	}
}
