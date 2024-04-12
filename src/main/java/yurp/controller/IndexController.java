package yurp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@PostMapping("/login")
	String index(Model mm) {
		System.out.println("그로인" + mm);
		String url = "main/dashboard";
		
		
		return url;
	}
}
