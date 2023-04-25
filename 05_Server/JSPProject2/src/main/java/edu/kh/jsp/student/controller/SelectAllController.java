package edu.kh.jsp.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.jsp.student.model.dto.Student;
import edu.kh.jsp.student.model.service.StudentService;

@WebServlet("/jstl/student/selectAll")  // http://localhost/jstl/student/selectAll  개발자 마음대로 
public class SelectAllController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			// 서비스 객체 생성
			StudentService service = new StudentService();
			
			String path = null;
			
			try {
				
				// 학생 전체 조회 서비스
				List<Student> stuList = service.selectAll();
				
				// request scope 에 stdList를 담아서 JSP로 위임
				req.setAttribute("stdList", stuList);
				
				path = "/WEB-INF/views/student/select.jsp";  //   파일경로 !== 요청 주소
				
				
			}catch(Exception e) {
				e.printStackTrace();
				
			}
			
			// 요청 위임
			req.getRequestDispatcher(path).forward(req, resp);
		
		
		
	}

}
