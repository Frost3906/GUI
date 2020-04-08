package service;

import persistence.UserDAO;
import domain.UserVO;

public class UserUpdateService {
	public int Update(UserVO vo) {
		
		UserDAO dao = new UserDAO();
		
		dao.updateUser(vo);
		int result = dao.updateUser(vo);
		
		return result;
	}
}
