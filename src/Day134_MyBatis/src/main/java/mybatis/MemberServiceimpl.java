package mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MemberServiceimpl implements MemberService {
	MemberDAO dao;
	
	//main에서 받아올 DAO
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}


	@Override
	public List<MemberDTO> memberlist() {
		// dao.xxxx()를 실행해주면됨.
		return dao.memberlist();
	}

	@Override
	public int membercount() {
		return dao.membercount();
	}


	@Override
	public MemberDTO onemember(String id) {
		return dao.onemember(id);
	}


	@Override
	public List<MemberDTO> pageinglist(int[] limit) {
		return dao.pageinglist(limit);
	}


	@Override
	public int insertmember(MemberDTO dto) {
		MemberDTO resultdto = dao.onemember(dto.getId());
		if (resultdto == null) {
			return dao.insertmember(dto);			
		}
		return 0;
	}


	@Override
	public int updatemember(MemberDTO dto) {
		MemberDTO resultdto = dao.onemember(dto.getId());
		if (resultdto == null) {
			return dao.updatemember(dto);		
		}
		return 0;
	}

	@Override
	public String deletemember(String id) {
		//tes7 - 삭제 수정(join으로 인한! )
		//1. id회원이 작성 글이 있는 지 검사
		//2. 글이 잇으면 사용자 탈퇴전 글도 삭제하시겠습니까?y/n
		//3-1 Y : 사용자 탈퇴
		//3-2 N : 사용자 탈퇴 취소
		MemberDTO resultm = dao.onemember(id);
		if (resultm != null) {
			//board에 글이 있는지 조회
			int resultb = dao.oneboard(id);
			if(resultb > 0 ) {
				//글을 삭제할 것인지 확인
				System.out.print("탈퇴전 글도 삭제하시겠습니까?y/n");
				Scanner scanner = new Scanner(System.in);
				String sc = scanner.nextLine();
				if(sc.equals("y")) {
					dao.deletemember(id);		
					return id + "회원을 삭제하였습니다."; 									
				}else if(sc.equals("n")) {
					return "탈퇴를 취소하였습니다."; 														
				}else {
					System.out.print("탈퇴전 글도 삭제하시겠습니까?y/n");
					sc = ne
				}
			}
		}
		return "일치하는 회원이 없습니다.";
	}

	@Override
	public List<MemberDTO> searchmember(HashMap map) {
		return dao.searchmember(map);
	}


	@Override
	public List<MemberDTO> addresssearch(ArrayList<String> addresslist) {
		return dao.addresssearch(addresslist);
	}


	@Override
	public List<MemberDTO> combination(MemberDTO comdto) {
		return dao.combination(comdto);
	}

	@Override
	public List<HashMap<String, String>> memberboard(String writer) {
		return dao.memberboard(writer);
	}
	
	
	
}
