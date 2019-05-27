package org.zerock.controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.extern.log4j.Log4j;


@Log4j
@WebServlet("/board/*")
public class BoardController extends AbstractController{
	
	private BoardService service = new BoardService();
	

	public String registerGET(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		return "views/board/register";
		
	}
	
	public String registerPOST(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		log.info("Register Post");
		
		BoardVO vo = new BoardVO();
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		vo.setWriter(request.getParameter("writer"));
		
		log.info(vo);
		
		int count = service.register(vo);
		
		
		return "result";
	}
	
	public String listGET(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		List<BoardVO> list = service.get100();
		
		request.setAttribute("list", list);
		
		return "views/board/list";
		
	}
	

}
