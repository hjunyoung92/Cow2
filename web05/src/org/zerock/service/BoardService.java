package org.zerock.service;

import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class BoardService {

	public int register(BoardVO vo) {
		
		log.info(vo);
		
		return 1;
	}
	
	
}
