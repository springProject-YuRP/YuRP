package yurp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.annotation.Resource;
import yurp.model.InvenDTO;
import yurp.model.InvenMapper;

@Controller
@RequestMapping("/stock")
public class InvenController {
	
	@Resource
	InvenMapper invenMapper;

	@RequestMapping("inven/list")
	String invenList(Model mm, InvenDTO dto) {
		mm.addAttribute("invenData",invenMapper.list(dto));
		return "stock/inven/list";
	}
	
	
}
