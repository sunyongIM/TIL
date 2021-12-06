package mc.sn.test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import mc.sn.test.service.LonginService;
import mc.sn.test.vo.LonginVO;

@Controller
@RequestMapping("/controller/*")
public class LonginController extends HttpServlet {
	
	@Autowired
	private LonginService service;
	@Autowired
	private LonginVO vo;
	
	
	@RequestMapping("/login")
//	@RequestMapping(value="/login", method = RequestMethod.POST)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("checkId");
		String pw = req.getParameter("checkPw");
		vo = service.loginTest(id, pw);
		if(!vo.equals(null)) {
			resp.getWriter().print(vo.getUserName());
		}
	}
	
}
