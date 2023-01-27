package ch01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
	public static void main(String[] args) {
		final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		final String DB_USER = "mybatis";
		final String DB_PASSWORD = "mybatis";
	
		Connection conn = null;
		PreparedStatement stmt = null; //request
		ResultSet rs = null;  //response를 나타넬객체
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//Class바이트코드를 매소드영역에 넣는 명렁어 수동
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);//연결시켜준다
			//오라클에게 쿼리를 보내기 위해서
			String query = "select user_id, user_name, reg_date from users";
			stmt = conn.prepareStatement(query); //String state로 만듬
			rs = stmt.executeQuery();
			//ORM
			//rs의 row만큼 유저를 만들어야함
			User user = null;
			while(rs.next()) { //커서를 이동시킴 데이터맞으면 true 없음 false리턴 row선택이라 생각하면편함
				user = new User(rs.getInt(1), rs.getString(2), rs.getDate(3));//세터이용하거나 생성자를 이용해서 매핑가능 요건 생성자
				//id, name, date라 int String Date임 rs의 리턴값의 인덱스별 타입에 맞춰 가져오는것?
				System.out.println(user);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close(); //생성한역순으로 끈다.
			} catch(Exception e) {}

		}
		//buield path에 들어가서 class path에 ojdbc를 추가해준다 jre external로 외부니까
	}
}
