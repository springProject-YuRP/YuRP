package yurp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
		List<BrandOrderDTO>listData = mapper.list();
		model.addAttribute("listData",listData);
		return "brandOrder/order/list";
	}
	
	@RequestMapping("order/request")
	void request(Model model) {}
	
	@RequestMapping("order/prodAdd")
	void prodAdd(Model model) {}
	
	@RequestMapping("order/detail")
	String detail(Model model, @RequestParam String oStat) {
		System.out.println("브랜드발주 전표번호 : " + oStat);
		List<BrandOrderDTO> detailData = mapper.list();
		model.addAttribute("detailData",detailData);
		return "brandOrder/order/detail";
	}
	
	@RequestMapping("brand/list")
	String blist(Model model) {
		List<BrandDTO> blist = mapper.blist();
		model.addAttribute("blist",blist);
		return "brandOrder/brand/list";
	}
	
	@RequestMapping("brand/{bName}")
	@ResponseBody
	public BrandDTO bdetail(@PathVariable String bName) {
	    BrandDTO bdetail = mapper.bdetail(bName);
	    System.out.println(bdetail);
	    return bdetail;
	}

	
	
	
}
