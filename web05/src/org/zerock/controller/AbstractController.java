package org.zerock.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j;

/**
 * Servlet implementation class AbcstractController
 */
@Log4j
public abstract class AbstractController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public AbstractController() {
        super();

    }

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 공통된 부분을 뭉쳐서 부모클래스로 올린다. 그리고 이 아래 메소드들은 상속받으면 바로 이용할수 있다.
		// 이자리에 공통인 부분을 쓴다.
		// 3. 필요한 jsp경로 알아내기
		// 4. forward(request, response)
		
		req.setCharacterEncoding("UTF-8");
		
		String jspName = null;
		try {
			jspName = execute(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/" + jspName + ".jsp");
		dispatcher.forward(req, resp);
	}

	
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		log.info("BoardController 실행...");

		String way = request.getMethod();

		String path = request.getServletPath();

		String methodName = request.getPathInfo();

		log.info("way:" + way);
		log.info("path:" + path);
		log.info("methodName:" + methodName);

		String target = (methodName + way).substring(1);

		Class clz = this.getClass();

		Method targetMethod = clz.getDeclaredMethod(target, HttpServletRequest.class, HttpServletResponse.class);

		String result = (String) targetMethod.invoke(this, request, response);

		return result;
	}

}
