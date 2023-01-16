package mybatis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MemberMain {

	public static void main(String[] args) throws IOException{
		// 1. Mybatis 읽을 객체 준비
		SqlSessionFactoryBuilder bullder = 
				new SqlSessionFactoryBuilder();
		// 2. Mybatis 설정 파일과 연결
		SqlSessionFactory factory = bullder.build
		(Resources.getResourceAsReader("mybatis/mybatis-config.xml"));
		//3. DB Connection (jdbc 자동 commit/ mybatis 수동 commit => 변경 필요)
		SqlSession session = factory.openSession(true);
		
		// 해당 작업을 DAO및 impl에 위임
//		// 4. sql-mapping.xml id=memberlist 정의 sql호출 resultTyoe="MemberDTO"
//		List<MemberDTO> memberlist = session.selectList("memberlist");
		MemberDAO dao = new MemberDAO();
		dao.setSession(session);

		MemberService service = new MemberServiceimpl();
		((MemberServiceimpl)service).setDao(dao);
				
		// 5. 조회
		//test1 - list조회	
		List<MemberDTO> list = service.memberlist();
		for(MemberDTO m : list)System.out.println(m);
		// test2 - 조회 int
		System.out.println("전체회원수 = " + service.membercount());
		// test3 - 하나의 맴버 조회(입력 파라미터 존재, 결과 MemberDTO)
		MemberDTO one = service.onemember("test");
		if(one != null) {			
			System.out.println(one);
		}
		// test4 - (입력 파라미터 존재, 결과 MemberDTO)
		int[] limit = {0,3};
		List<MemberDTO> page = service.pageinglist(limit);
		for(MemberDTO m : page) System.out.println(m);
		
		//test5
		MemberDTO insertdto = new MemberDTO();
		insertdto.setId("mybatis");
		insertdto.setPw("mybatis");
		insertdto.setName("바티스");
		insertdto.setPhone("01000000000");
		insertdto.setEmail("batis@my.com");
		insertdto.setAddress("용산시 지이구");
		service.insertmember(insertdto);
		
		//test6
		// id= mybatis, name="박한국", phone=01012341234, email="my@batis.com"
		MemberDTO updatedto = new MemberDTO();
		updatedto.setId("mybatis");
		updatedto.setName("박한국");
		updatedto.setPhone("01012341234");
		updatedto.setEmail("my@batis.com");
		service.updatemember(updatedto);
		
		//test7
		//id mybatis 삭제
		int result = service.deletemember("mybatis");
		if(result > 0) {
			System.out.println("정상처리 되었습니다.");
		}
				
		//test8 - map
		HashMap<String,String> map = new HashMap();
		map.put("colname", "name");
		map.put("colvalue", "%es%");
		//selec * from member where ${colname} like #{colvalue}
		List<MemberDTO> searchlist = service.searchmember(map);
		for(MemberDTO m : searchlist) System.out.println(m);
		
		
		//test9 - list
		//select * from member where address in('서울시 용산구', '제주시 용산구' , '부산시 xxx')
		ArrayList<String> addresslist = new ArrayList<String>();
		addresslist.add("서울시 용산구");
		addresslist.add("서울시 종로구");
		addresslist.add("용산시 지이구");
		//select * from member where address in
			// <foreach collection="list" item="addr" open="(" separator="," close=")">
			// #{addr}
			// </foreach>
		 List<MemberDTO>  resultaddress = service.addresssearch(addresslist);
		 for(MemberDTO m : resultaddress) System.out.println(m);
			 
		 //test10 동적 sql
		 MemberDTO comdto = new MemberDTO();
		 comdto.setName("이지은");
		 comdto.setEmail("diwl@gmail.com");
		 List<MemberDTO> resultcom = service.combination(comdto);
		 for(MemberDTO m : resultcom) System.out.println(m);
		 
		 //test11 join 
		 List<HashMap<String, String>> mblist = service.memberboard("김무길");
		 for(HashMap mbmap : mblist) {
			 Set<String> keys = mbmap.keySet();
			 for(String s : keys)System.out.println( s +" : " + mbmap.get(s));
		 }
		
	}
}
