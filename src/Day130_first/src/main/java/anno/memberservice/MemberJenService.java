package anno.memberservice;

public class MemberJenService implements MemberService{
	MemberDAO memberdao;
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
	
	public void setMemberdao(MemberDAO memberdao) {
		this.memberdao = memberdao;
	}

	public void setPointdao(PointDAO pointdao) {
		this.pointdao = pointdao;
	}



	
}
