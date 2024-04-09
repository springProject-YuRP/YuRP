package yurp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.annotation.Resource;
import yurp.model.BrandDTO;
import yurp.model.BrandOrderDTO;
import yurp.model.BrandOrderMapper;

@Controller
@RequestMapping("/brandOrder")
public class BrandOrderController {

	@Resource
	BrandOrderMapper mapper;
	
	@RequestMapping("order/list")
	String list(Model model) {
		model.addAttribute("listData", mapper.list());
		return "brandOrder/order/list";
	}
	
	@RequestMapping("order/request")
	void request(Model model) {}
	
	@RequestMapping("order/prodAdd")
	void prodAdd(Model model) {}
	
	@RequestMapping("order/detail")
	String detail(Model model, @RequestParam String oStat) {
		model.addAttribute("detailData",mapper.list());
		return "brandOrder/order/detail";
	}
	
	@GetMapping("brand/list")
	String blist(Model model) {
		model.addAttribute("blist",mapper.blist());
		return "brandOrder/brand/list";
	}
	
	@RequestMapping("brand/{bName}")
	@ResponseBody
	BrandDTO bdetail(@PathVariable String bName, Model model) {
	    return mapper.bdetail(bName);
	}

	
	@PostMapping("brand/list")
	void insert(BrandDTO dto) {
		mapper.insert(dto);
	}
	
	@PostMapping("brand/{bNo}")
	String modify(BrandDTO dto) {
		mapper.modify(dto);
		return "brandOrder/brand/list";
	}
	
	@GetMapping("brand/delete/{bNo}")
	String delete(BrandDTO dto) {
		mapper.delete(dto);
		return "redirect:/brandOrder/brand/list";
	}

	
	
	
}
