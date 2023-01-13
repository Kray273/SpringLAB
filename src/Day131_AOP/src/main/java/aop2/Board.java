package aop2;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class Board { //Target
	public void insert(int seq) {
		System.out.println(seq + "번째 게시물에 저장합니다.");	
	}
	
	public ArrayList<String> getList() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("게시물1");
		list.add("게시물2");
		list.add("게시물3");
		list.add("게시물4");
		list.add("게시물5");
		return list;
	}
}
