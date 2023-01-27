package ch02.domain;

import java.time.LocalDate;

//mybatis라 localdate쓸수 있음 class는 mybatis가 만드니 우리는 interface만 만들면 된다.
public class User{
	private int userId;
	private String userName;
	private LocalDate regDate;
	
	public User(int userId, String userName, LocalDate regDate) {
		this.userId = userId;
		this.userName = userName;
		this.regDate = regDate;
	}
	/*
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}
	*/
	@Override
	public String toString() {
		return String.format("%d %s %s", userId, userName, regDate);
	}
}
