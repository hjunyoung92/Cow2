package org.zerock.service;

import java.util.List;

import org.zerock.dao.BoardDAO;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class BoardService {
	
	BoardDAO dao = new BoardDAO();
	
	public void remove(Integer bno) {
		dao.delete(bno);
	}

	public int register(BoardVO vo) {
		
		log.info(vo);
		
		return dao.insert(vo);
	}

	public List<BoardVO> get100() {
		
		return dao.list100();
	}
	
	public BoardVO findById(Integer bno) {
		return dao.read(bno);
		
	}
	
	
}
