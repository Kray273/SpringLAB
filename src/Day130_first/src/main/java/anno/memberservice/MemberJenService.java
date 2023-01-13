package anno.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service1")
public class MemberJenService implements MemberService{
	@Autowired
	MemberDAO memberdao;
	
	@Autowired
	PointDAO pointdao;
	
	@Override
	public void registerMember() {
		boolean isLogin = memberdao.selectMember();
		if(!isLogin) {
			memberdao.insertMember();
			//pointdao.setPoint(10000); //xml
			System.out.println(pointdao.getPoint()+"포인트를 받았습니다.");
		}
	}
	
	/*
	 * public void setMemberdao(MemberDAO memberdao) { this.memberdao = memberdao; }
	 * 
	 * public void setPointdao(PointDAO pointdao) { this.pointdao = pointdao; }
	 */


	
}
