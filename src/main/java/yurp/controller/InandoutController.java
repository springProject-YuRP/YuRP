package yurp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.annotation.Resource;
import yurp.model.SellDTO;
import yurp.model.InandoutDTO;
import yurp.model.InandoutMapper;

@Controller
@RequestMapping("/stock")
public class InandoutController {
	
	@Resource
	InandoutMapper inandoutmapper;

	@RequestMapping("inandout/list")
	String sellList(Model mm, InandoutDTO dto) {
		mm.addAttribute("inandoutData",inandoutmapper.list(dto));
		mm.addAttribute("totData",inandoutmapper.tot(dto));
		return "stock/inandout/list";
	}
	
	@RequestMapping("inandout/detail")
	String sNameSearch(Model mm, InandoutDTO dto) {
		mm.addAttribute("detail", inandoutmapper.detail(dto));
		return "stock/inandout/detail";
	}
	
}
