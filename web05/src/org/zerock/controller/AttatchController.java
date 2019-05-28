package org.zerock.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j;
@Log4j
@WebServlet("/attatch/*")
public class AttatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AttatchController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		log.info(request.getPathInfo());
		
		String fileName = "C://zzz//"+request.getPathInfo().substring(1);
		
		OutputStream os = response.getOutputStream();
		
		InputStream fin = new FileInputStream(fileName);
		
		byte[]	buffer = new byte[1024*8];
		
		while(true) {
			int count = fin.read(buffer);
			if (count ==-1) {break;}
			os.write(buffer,0,count);
			
		}
	}

}
