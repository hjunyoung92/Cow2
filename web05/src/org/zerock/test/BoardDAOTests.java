package org.zerock.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.zerock.dao.BoardDAO;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class BoardDAOTests {

	BoardDAO dao = new BoardDAO();
	
	@Test
	public void testDelete() {
		dao.delete(10795926);
		
	}

	@Test
	public void testRead() {
		log.info(dao.read(10793784));
	}

	@Test
	public void testList100() {
		dao.list100().forEach(vo -> log.info(vo));
	}

	@Test
	public void testInsert() {

		int result = 0;
		for (int i = 0; i < 10; i++) {

			BoardVO vo = new BoardVO();
			vo.setTitle("제목");
			vo.setContent("내용");
			vo.setWriter("허준영");

			result += dao.insert(vo);

			log.info(result);
		}
		assertEquals(100, result);

	}
	
}
