package yurp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.annotation.Resource;
import yurp.model.BrandOrderDTO;
import yurp.model.BrandOrderMapper;

@Controller
@RequestMapping("/brandOrder/order")
public class BrandOrderController {

	@Resource
	BrandOrderMapper mapper;
	
	@RequestMapping("list")
	String list(Model model) {
		List<BrandOrderDTO>listData = mapper.list();
		model.addAttribute("listData",listData);
		return "brandOrder/order/list";
	}
	
	@RequestMapping("request")
	void request(Model model) {}
	
	@RequestMapping("prodAdd")
	void prodAdd(Model model) {}
	
	@RequestMapping("{o_stat}")
	String detail(Model mm) {
		return "brandOrder/order/detail";
	}
	
	
}
