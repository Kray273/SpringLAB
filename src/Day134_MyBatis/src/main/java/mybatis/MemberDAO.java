package mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MemberDAO {
	SqlSession session;
	//main에서 session전달 받기
	public void setSession(SqlSession session) {
		this.session = session;
	}

	public List<MemberDTO> memberlist() {
		return session.selectList("member.memberlist");//여러개의 값
	}
	
	public int membercount() {
		return session.selectOne("member.membercount"); //하나의 값
	}
	
	public MemberDTO onemember(String id) {
		return session.selectOne("member.onemember", id); //매개변수 추가
	}
	
	public List<MemberDTO> pageinglist(int[] limit) {
		return session.selectList("member.pageinglist", limit);
	}
	
	public int insertmember(MemberDTO dto) {
		return session.insert("member.insertmember", dto);	
	}
	
	public int updatemember(MemberDTO dto) {
		return session.update("member.updatemember", dto);
	}
	
	public int deletemember(String id) {
		return session.delete("member.deletemember", id);
	}
	
	public List<MemberDTO> searchmember(HashMap map) {
		return session.selectList("member.searchmember", map);
	}
	
	public List<MemberDTO> addresssearch(ArrayList<String> addresslist) {
		return session.selectList("member.addresssearch", addresslist);
	}
	
	public List<MemberDTO> combination(MemberDTO comdto) {
		return session.selectList("member.combination", comdto);
	}
	
	public List<HashMap<String,String>> memberboard(String writer) {
		return session.selectList("member.memberboard", writer);
	}
	
	
}
