package action;

import java.util.List;
import java.util.Scanner;

import domain.UserVO;
import service.UserListService;

public class UserListAction implements Action {

	@Override
	public void execute(Scanner sc) {
	
		UserListService service = new UserListService();
		List<UserVO> list = service.getList();
		
		System.out.println("\n===== 사용자 전체 보기 =====");
		System.out.println("번호\t이름\t생년월일\t\t주소");
		
		for(UserVO vo : list) {
			System.out.print(vo.getNo()+"\t");
			System.out.print(vo.getName()+"\t");
			System.out.print(vo.getBirthday()+"\t");
			System.out.print(vo.getAddress()+"\n");
		}

	}

}
