package annotation.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository("dao")
public class MemberDAO {
	@Autowired //같은이름 2개라면 dto , dto
//	@Qualifier("dto2") // 어떤이름 쓸지 명시
	MemberDTO dto;

	/* 
	 * Qualifier 없으면 우선순위
	 * 1. MemberDTO타입 객체들 찾는다 1개주입
	 * 2. 여러개 찾는다- 변수명과 일치하는 객체 찾는다 - 1개 자동주입
	 * 3. 객체 여러개 찾는다 - 이름 일치하지 않는다  -(@Qualifier 필요!)
	 * 
	 * */
		
		public boolean selectMember() {
			
			if(dto.getId().equals("spring")&& dto.getPw().equals("1111")) {
				return true;
			}else {
				return false;
			}
		}

	public void insertMember() {
		System.out.println(dto.getId()+"님 회원가입 되셨습니다.");
	}


	
	

}
