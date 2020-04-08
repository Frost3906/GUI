package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

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
	public Vector<MemberVO> getList(){
		Vector<MemberVO> vecList = new Vector<MemberVO>();
		
		String sql = "select * from memberTBL";
		
		try (Connection con = getConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql);
			 ResultSet rs = pstmt.executeQuery()){
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setNo(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setAge(rs.getInt(3));
				vo.setGender(rs.getString(4));
				vecList.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vecList;
	}
}