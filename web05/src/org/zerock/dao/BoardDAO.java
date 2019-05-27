package org.zerock.dao;

import org.apache.ibatis.session.SqlSession;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class BoardDAO {

	private static final String PRE = "org.zerock.dao.";
	protected String mapperName = "BoardMapper";
	
	public int insert(BoardVO vo) {
		
		int result = 0;
		log.info(vo);
		
		try(SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true);) {
			result = session.insert(PRE + mapperName + ".insert", vo);
			
		} catch (Exception e) {
			throw e;
		}
		
		
		
		return result;
	}
}
