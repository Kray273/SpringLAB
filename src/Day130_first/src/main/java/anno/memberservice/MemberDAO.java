package anno.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("memberdao")
public class MemberDAO {

	@Autowired // dto1,dto2,dto3 xml파일에 객체생성
	@Qualifier("dto1") //spting, 1111
	MemberDTO dto;
	//<property name="dto" ref="dto1">
		public void setDto(MemberDTO dto) {
			//dto, dto2,dto3(ioc구현하려면  의존성 주입(dependency injection))
			//1. setter injection
			//2. constructor injection
			this.dto = dto;
		}
		

	 public boolean selectMember() { // MemberDIO - id가 spring이고 pw1111 이면 정상 로그인
	 
	 if(dto.getId().equals("spring")&& dto.getPw().equals("1111")) { return true;
	 }else { return false; } 
	 }	

	public void insertMember() {
		System.out.println(dto.getId()+"님 회원가입 되셨습니다.");
	}


	
	

}
