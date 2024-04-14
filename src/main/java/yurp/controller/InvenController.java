package yurp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.annotation.Resource;
import yurp.model.SellDTO;
import yurp.model.SellMapper;

@Controller
@RequestMapping("/stock")
public class InvenController {
	
	@Resource
	SellMapper sellmapper;

	@RequestMapping("inven/list")
	String invenList(Model mm, SellDTO dto) {
//		mm.addAttribute("sellData",sellmapper.list(dto));
//		mm.addAttribute("totData",sellmapper.tot(dto));
		return "stock/inven/list";
	}
	
	
}
