package yurp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.annotation.Resource;
import yurp.model.BrandDTO;
import yurp.model.DTOs;
import yurp.model.ProductDTO;
import yurp.model.ProductMapper;

@Controller
@RequestMapping("stock/product")
public class ProductController {

	@Resource
	ProductMapper mapper;

	@RequestMapping
	String productList(Model mm, ProductDTO dto) {
//		System.out.println("productList----"+dto);
		mm.addAttribute("productData", mapper.list(dto));
//		System.out.println("productList"+mm);
		return "stock/product/list";
	}

	@GetMapping("insert")
	void productInsertForm() {
	}

	@PostMapping("insert")
	String productInsertReg(DTOs dtos) {
		System.out.println("상품등록reg 왔음 : " + dtos.getProdArr());
		System.out.println("상품등록reg 완료 : " + mapper.insert(dtos.getProdArr()));
		return "redirect:/stock/product";
	}

	@PostMapping("delete")
	String delete(DTOs dtos) {
		System.out.println("delete 왔음 : " + dtos.getProdArr());
		System.out.println("상품삭제reg 완료 : " + mapper.delete(dtos.getProdArr()));
		return "redirect:/stock/product";
	}

	@PostMapping("modify")
	void productModifyForm(Model mm, DTOs dtos) {
		System.out.println("수정form 왔음 mm : " + mm);
		System.out.println("수정form 왔음 brands : " + mapper.brandList());

		mm.addAttribute("productData", mapper.modList(dtos.getProdArr()));
		mm.addAttribute("brandData", mapper.brandList());
	}
	
    @PostMapping("modify/reg") 
    String productModifyReg(DTOs dtos) {
 	    System.out.println("상품수정reg 왔음 : "+dtos.getProdArr());
//	    System.out.println("상품수정reg 완료 : "+ mapper.modReg(dtos.getProdArr())); 
	    return "redirect:/stock/product"; 
    }
    
    
    
}
