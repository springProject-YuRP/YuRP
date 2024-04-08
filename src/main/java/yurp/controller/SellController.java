package yurp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.annotation.Resource;
import yurp.model.SellMapper;

@Controller
@RequestMapping("/stock")
public class SellController {
	
	@Resource
	SellMapper sellmapper;

	@RequestMapping("product/list")
	String sellList(Model mm) {
		mm.addAttribute("sellData",sellmapper.list());
		return "stock/product/list";
	}
	
}
