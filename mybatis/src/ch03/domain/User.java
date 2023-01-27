package ch03.domain;

import java.time.LocalDate;

import org.apache.ibatis.type.Alias;

@Alias("myUser") //직접별명 지어줄수 도 있다.
public class User {
	private int userId;
	private String userName;
	private LocalDate regDate;
	private Address address;
	
	@Override
	public String toString() {
		return String.format("%d %s %s %s", userId, userName, regDate, address);
	}
}
