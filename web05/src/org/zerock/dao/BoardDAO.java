package org.zerock.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class BoardDAO {

	private static final String PRE = "org.zerock.dao.";
	protected String mapperName = "BoardMapper";
	
	public BoardVO read(Integer bno) {
		BoardVO result = null;
		
		try(SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true);) {
			result = session.selectOne(PRE + mapperName + ".read", bno);
			
		} catch (Exception e) {
			throw e;
		}
		
		
		
		return result;
		
	}
	
	
	public List<BoardVO> list100(){
		List<BoardVO> result = null;
		
		try(SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true);) {
			result = session.selectList(PRE + mapperName + ".list100");
			
		} catch (Exception e) {
			throw e;
		}
		
		
		
		return result;
	}
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
