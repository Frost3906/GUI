package action;

import java.util.Scanner;

import service.UserDeleteService;

public class UserDeleteAction implements Action {

	@Override
	public void execute(Scanner sc) {
		System.out.println("삭제할 사용자 번호를 입력해 주세요");
		int no = sc.nextInt();
		
		UserDeleteService service = new UserDeleteService();
		
		
		if(service.delete(no)>0) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}
		
	}

}
