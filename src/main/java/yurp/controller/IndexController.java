package yurp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import yurp.model.StoreDTO;
import yurp.model.StoreMapper;

@Controller
public class IndexController {
	
	@Resource
	StoreMapper sMapper;
	
	@RequestMapping("template")
	String index(HttpServletRequest request) {
		String url="index";
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginStore") != null) {
			url = "main/dashboard";
		}

		return "template";
	}
	
	@PostMapping("login")
	String login(HttpServletRequest request, StoreDTO dto) {
		System.out.println("그로인" + dto);
		StoreDTO data =sMapper.login(dto); 
		
		if(data==null) {
			return "index";
		}else {
			HttpSession session = request.getSession();
			System.out.println(data);
			session.setAttribute("loginStore", data);
			return "main/dashboard";
		}		
	}
	
	@GetMapping("logout")
	String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
}
