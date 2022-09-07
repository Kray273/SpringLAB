package com.springproj.biz.board.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproj.biz.board.BoardVO;
import com.springproj.biz.board.dao.BoardDAO;
import com.springproj.biz.common.Log4jAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO dao; 
	@Autowired
	//private LogAdvice log;
	private Log4jAdvice log;
	
	/*Annotation사용으로 불필요.
	 * public BoardServiceImpl() { dao = new BoardDAO(); log = new LogAdvice(); }
	 */
	
	
	@Override
	public void insertService(BoardVO vo) {
		  dao.insertBoaed(vo);
		  //log.printLog("= insertService() =");
		  log.printLogging("= insertService() =");
	}

	@Override
	public void getService(int seq) {
		dao.getBoaed(seq);
		//log.printLog("= getService() =");
		log.printLogging("= getService() =");
	}

	@Override
	public void getServiceList() {
		dao.getBoaedList();
		//log.printLog("= getServiceList() =");
		log.printLogging("= getServiceList() =");
	}

	@Override
	public void updateService(BoardVO vo) {
		dao.updateBoaed(vo);
		//log.printLog("= updateService() =");
		log.printLogging("= updateService() =");
		
	}

	@Override
	public void deleteService(int seq) {
		dao.deleteBoaed(seq);
		//log.printLog("= deleteService() =");
		log.printLogging("= deleteService() =");
	}

	

}
