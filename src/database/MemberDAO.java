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
	public int insert(MemberVO vo) {
		
		String sql = "insert into memberTBL values(member_seq.nextval,?,?,?)";
		int result = 0;
		try (Connection con = getConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql)){
				
				pstmt.setString(1, vo.getName());
				pstmt.setInt(2, vo.getAge());
				pstmt.setString(3, vo.getGender());
				
				result = pstmt.executeUpdate();
				
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	public MemberVO getRow(int no) {
		String sql = "select * from memberTBL where no=?";
		MemberVO vo = null;
		try (Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new MemberVO();
				vo.setNo(rs.getInt(1));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt(3));
				vo.setGender(rs.getString("gender"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	//no 값을 이용하여 회원 삭제하기
	public int remove(int no) {
		int result=0;
		String sql = "delete from memberTBL where no = ?";
		
		try (Connection con = getConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql)){
			
				pstmt.setInt(1, no);
				result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
		
	}
}
