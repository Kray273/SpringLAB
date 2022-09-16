package com.springproj.biz.board;

import java.sql.Date;

public class BoardVO {//JavaBean

	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regdate;
	private int cnt;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	@Override //JavaBean에서 한번에 출력할 수 있도록
	public String toString() {
		String data = 
				"BoardVO[seq="+ seq +", title="+ title +
				", writer="+ writer +", content="+content+
				", date="+ regdate +", cnt="+cnt+"]";  
		return data;
	}
	

	
}