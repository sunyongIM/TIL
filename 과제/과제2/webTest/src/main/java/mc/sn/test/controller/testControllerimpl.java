package mc.sn.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mc.sn.test.vo.LonginVO;

public class testControllerimpl implements testController {
	@Override
	public ModelAndView login(LonginVO testvo, RedirectAttributes rAttr, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
