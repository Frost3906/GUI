package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDAO {
	//드라이버 클래스 로드
	
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		String url="jdbc:oracle:thin:@localhost:1521:orcl";//DB서버 주소 및 연결 문자열
		String user="javadb";//허가받은 사용자
		String password="12345";//비밀번호
		Connection con=null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//데이터 베이스 요청 작업
	public int insert(int no, String name, int age, String gender) {
		int result = 0;
		
		String sql = "insert into memberTBL(no,name,age,gender) values(?,?,?)";
		try (Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setInt(1, no);	
			pstmt.setString(2, name);	
			pstmt.setInt(3, age);
			pstmt.setString(4, gender);
			
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
