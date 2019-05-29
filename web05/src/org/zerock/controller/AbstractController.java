package org.zerock.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.zerock.dao.MyBatisLoader;
import org.zerock.dao.TimeDAO;

import lombok.extern.log4j.Log4j;

/**
 * Servlet implementation class AbstractController
 */
@Log4j
public abstract class AbstractController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AbstractController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String jspName = null;
		try {
			jspName = execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (jspName.startsWith("redirect:")) {
			String targetURL = jspName.substring(9);
			response.sendRedirect(targetURL);
			return;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/" + jspName + ".jsp");
		dispatcher.forward(request, response);

	}
	
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		log.info("BoardController execute...");
		
		String way = request.getMethod();
		
		String path = request.getServletPath();
		
		String methodName = request.getPathInfo();
		
		log.info("way: " + way);
		log.info("path: " + path);
		log.info("methodName: " + methodName);
		
		String target =(methodName + way).substring(1);
		
		Class clz = this.getClass();
		
		Method targetMethod = clz.getDeclaredMethod(target, 
				HttpServletRequest.class, 
				HttpServletResponse.class); 
		
		String result = 
				(String)targetMethod.invoke(this, request,response);
		
		return result;
	}
	
	protected Integer getInt(String paramName,
			HttpServletRequest req, 
			int defaultValue) {
		
		Integer result = getInt(paramName, req);
		
		if(result == null) {
			return defaultValue;
		}
		return result;
	}
	
	protected Integer getInt(String paramName, 
			HttpServletRequest req) {
		
		Integer result = null;
		
		try {
			result = 
					Integer.parseInt(
							req.getParameter(paramName)
							);
		}catch(Exception e) {
			log.error(e.getMessage());
		}		
		
		return result;
	}

}




