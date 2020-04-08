package action;

import java.util.Scanner;

import domain.UserVO;
import service.UserUpdateService;

public class UserUpdateAction implements Action {

	@Override
	public void execute(Scanner sc) {
		System.out.println("수정할 사용자 정보를 입력해 주세요 ");
		System.out.print("번호 입력 : ");
		int no = sc.nextInt();
		System.out.print("이름 입력 : ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("주소 입력 : ");
		String address = sc.nextLine();
		UserVO vo = new UserVO();
		vo.setNo(no);
		vo.setName(name);
		vo.setAddress(address);		
		
		UserUpdateService service = new UserUpdateService();
		
		if(service.Update(vo)>0) {
			System.out.println("수정 성공");
		}else {
			System.out.println("수정 실패");
		}

	}

}
