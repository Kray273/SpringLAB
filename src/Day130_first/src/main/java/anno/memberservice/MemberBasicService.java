package anno.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service  //memberBasicService 라는 빈이 생성 이름이 붙지 않으면
@Service("service2")
public class MemberBasicService implements MemberService {
	
	@Autowired
	MemberDAO dao;
	
	/*
	 * public void setDao(MemberDAO dao) { this.dao = dao; }
	 */
	
	
	@Override
	public void registerMember() {
		
		boolean isLogin =dao.selectMember();
		
		if(!isLogin) {
			dao.insertMember();
		}
	}

}
