package action;


import database.MemberVO;
import service.MemberAddService;

public class memberAddAction implements Action {

	@Override
	public void execute() {
		
		int no,age;
		String name,gender;
		
		no = 
		
		MemberAddService service = new MemberAddService();
		
		System.out.println(service.insert(no,name,age,gender)?"삽입 성공":"삽입 실패");
		
		
	}

}
