package service;

import java.util.List;

import domain.UserVO;

public interface Service {
	public int insert(UserVO vo);
	public int update(UserVO vo);
	public int delete(int no);
	public UserVO getUser(int no);
	public List<UserVO> getList();
}
