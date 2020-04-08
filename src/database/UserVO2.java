package database;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class UserVO2 { //오라클 userTBL 연동용
	private int no;
	private String name;
	private int birthyear;
	private String address;
	
}
