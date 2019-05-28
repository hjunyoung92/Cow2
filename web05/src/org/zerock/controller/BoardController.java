package org.zerock.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.zerock.domain.BoardVO;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.extern.log4j.Log4j;

@Log4j
@WebServlet("/board/*")
@MultipartConfig(location ="c://zzz")
public class BoardController extends AbstractController{

	private BoardService service = new BoardService();
	
	public String removePOST(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		Integer bno = getInt("bno", request);
		Integer page = getInt("page", request);
		if(bno == null) {
			throw new Exception("null bno");
		}
		request.setAttribute("page", page);
		service.remove(bno);
		
		return "views/board/resultFrame";
	}
	
	public String modifyGET(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		Integer bno = getInt("bno", request);
		
		if(bno == null) {
			throw new Exception("null bno");
		}
		
		request.setAttribute("vo", service.findById(bno) );
		
		return "views/board/modify";
	}
	
	public String readGET(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		Integer bno = getInt("bno", request);
		
		if(bno == null) {
			throw new Exception("null bno");
		}
		
		request.setAttribute("vo", service.findById(bno) );
		
		return "views/board/read";
	}

	public String registerGET(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		return "views/board/register";
	}
	
	public String registerPOST(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		log.info("register post.............");
		BoardVO vo = new BoardVO();
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		vo.setWriter(request.getParameter("writer"));
		
		log.info(vo);
		
		Collection<Part> parts = request.getParts();
	
		log.info("parts:" + parts);
		
		parts.forEach(part -> {
			String fileName = part.getSubmittedFileName();
			
			if(fileName != null) {
				try {
					part.write(fileName);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		int count = service.register(vo);
		
		return "views/board/result";
	}

	
	public String listGET(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		int current = getInt("page", request, 1);
		int total = service.getTotalCount();
		
		List<BoardVO> list = service.getList(current);
		
		request.setAttribute("pm", 
				new PageDTO(current, total));
		
		request.setAttribute("list", list);
		
		return "views/board/list";
	}
}