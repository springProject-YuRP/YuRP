package yurp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.annotation.Resource;
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
	String viewDetail(Model mm, InandoutDTO dto) {
		mm.addAttribute("viewDetail", inandoutmapper.viewDetail(dto));
		System.out.println(mm);
		return "stock/inandout/detail";
	}
	
}
