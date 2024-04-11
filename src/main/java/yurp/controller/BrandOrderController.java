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
import jakarta.servlet.http.HttpServletResponse;
import yurp.model.ArrayDTO;
import yurp.model.BrandDTO;
import yurp.model.BrandOrderDTO;
import yurp.model.BrandOrderMapper;
import yurp.model.Excel;
import yurp.model.ProductDTO;
import yurp.model.ProductMapper;

@Controller
@RequestMapping("/brandOrder")
public class BrandOrderController {

	@Resource
	BrandOrderMapper mapper;
	
	@Resource
	ProductMapper pmapper;
	
	@RequestMapping("order/list")
	String list(Model model) {
		model.addAttribute("listData", mapper.list());
		return "brandOrder/order/list";
	}
	
	@GetMapping("order/request")
	void request(Model model, ProductDTO dto) {
		List<BrandDTO> bdto = mapper.blist();
		model.addAttribute("bdto",bdto);
	}
	
	@GetMapping("order/prodAdd")
	void prodAdd(Model model, ProductDTO dto) {
		List<ProductDTO> prod = pmapper.prodList(dto);
		model.addAttribute("prod",prod);
		
	}

	
	@RequestMapping("order/detail")
	String detail(Model model, @RequestParam String oStat) {
		model.addAttribute("detailData",mapper.list());
		return "brandOrder/order/detail";
	}
	
	@PostMapping("excel")
	void excel(HttpServletResponse response,ArrayDTO arr,@RequestParam int reqCnt) {
		System.out.println(reqCnt);
		Excel ex = new Excel(response,pmapper.excelArr(arr.getArr()),reqCnt);
		
	}
	
	
	
	
	//브랜드 관리
	@GetMapping("brand/list")
	String blist(Model model) {
		model.addAttribute("blist",mapper.blist());
		return "brandOrder/brand/list";
	}
	
	@PostMapping("brand/list")
	void insert(BrandDTO dto) {
		mapper.insert(dto);
	}
	
	@RequestMapping("brand/{bName}")
	@ResponseBody
	BrandDTO bdetail(@PathVariable String bName, Model model) {
	    return mapper.bdetail(bName);
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
