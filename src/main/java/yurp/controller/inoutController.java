package yurp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.annotation.Resource;
import yurp.model.InoutDTO;
import yurp.model.InoutMapper;

@Controller
@RequestMapping("/stock")
public class inoutController {
	
	@Resource
	InoutMapper inoutmapper;

	@RequestMapping("inout/list")
	String sellList(Model mm, InoutDTO dto) {
		mm.addAttribute("inoutData",inoutmapper.list(dto));
		mm.addAttribute("totData",inoutmapper.tot(dto));
		return "stock/inout/list";
	}
	
	
}
