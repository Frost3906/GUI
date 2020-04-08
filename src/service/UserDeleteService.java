package service;

import persistence.UserDAO;

public class UserDeleteService {
	public int delete(int no){
		UserDAO dao = new UserDAO();
		int result = dao.deleteUser(no);
		
		return result;
	}
	
}
