package service;

import database.MemberDAO;
import database.MemberVO;

public class MemberAddService {
	public boolean insert(int no, String name, int age, String gender) {
		MemberDAO dao = new MemberDAO();
		int result = dao.insert(no, name, age, gender);
		
		return result>0?true:false;
	}
}
