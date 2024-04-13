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
@RequestMapping("/{subCate}/{service}")
public class SellController {
	
	@Resource
	SellMapper sellmapper;

	@RequestMapping("list")
	String sellList(Model mm, SellDTO dto) {
		mm.addAttribute("sellData",sellmapper.list(dto));
		mm.addAttribute("totData",sellmapper.tot(dto));
		return "stock/sales/list";
	}
	
	
	@RequestMapping("sNameSearch")
	String sNameSearch(Model mm, SellDTO dto) {
		mm.addAttribute("sNameSearch", sellmapper.sNameSearch(dto));
		return "stock/sales/sNameSearch";
	}
	
	@RequestMapping("pNumSearch")
	String pNumSearch(Model mm, SellDTO dto) {
		mm.addAttribute("pNumSearch", sellmapper.pNumSearch(dto));
		return "stock/sales/pNumSearch";
	}
	
//	@RequestMapping()
//	String viewTotal() {
//		System.out.println("viewTotal");
//		return "template";
//	}
	
}
