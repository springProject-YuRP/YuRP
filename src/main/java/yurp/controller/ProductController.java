package yurp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.annotation.Resource;
import yurp.model.DTOs;
import yurp.model.ProductDTO;
import yurp.model.ProductMapper;

@Controller
@RequestMapping("stock/product")
public class ProductController {

	@Resource
	ProductMapper mapper;
	
	@RequestMapping
	String productList(Model mm, DTOs dtos) {
		System.out.println("productList----"+dtos);
		mm.addAttribute("productData",mapper.list(dtos.getProductArr()));
		System.out.println("productList"+mm);
		return "stock/product/list";
	}
	
	@GetMapping("insert")
	void insertForm() {}
}
