package service;

import java.util.List;

import domain.UserVO;
import persistence.UserDAO;

public class UserListService {

	
	public List<UserVO> getList(){
		UserDAO dao = new UserDAO();
		return dao.getList();
	}
}
