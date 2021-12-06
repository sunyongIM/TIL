package mc.sn.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mc.sn.test.vo.LonginVO;

public interface testController {
	public ModelAndView login(@ModelAttribute("member") LonginVO testvo, RedirectAttributes rAttr,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
}
