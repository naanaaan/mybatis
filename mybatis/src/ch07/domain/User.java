package ch07.domain;

import java.time.LocalDate;
// 7장의 내용은 졸업할때까지 쓰지말 것 현장에서 쓰면 쓰는 거지 따로 분리되어 있지않아 좋지 않다.
public class User {
	private int userId;
	private String userName;
	private LocalDate regDate;
	
	public User(int userId, String userName, LocalDate regDate) {
		this.userId = userId;
		this.userName = userName;
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return String.format("%d %s %s", userId, userName, regDate);
	}
}
