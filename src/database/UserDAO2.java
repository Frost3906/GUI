package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.ResultSet;


public class UserDAO2 {
	
	static {
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection con = null;
		
		//커넥션 연결
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "javadb";
		String password = "12345";
		
		try {
			con = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	//전체 리스트 가져오기
	
	public Vector<UserVO2> getList(){
		Vector<UserVO2> vecList = new Vector<UserVO2>();
		String sql = "select * from userTBL";
		
		try (Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			
			while(rs.next()) {
				UserVO2 vo = new UserVO2();
				vo.setNo(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setBirthyear(rs.getInt(3));
				vo.setAddress(rs.getString(4));
				vecList.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vecList;
		
	}
	
	
	
}
