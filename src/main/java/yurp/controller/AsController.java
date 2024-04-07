package yurp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/as")
public class AsController {

	@RequestMapping("list")
	String list() {
		return "as/list";
	}
	
	@RequestMapping("detail")
	String detail() {
		return "as/detail";
	}
	
	@RequestMapping("modify")
	String modify() {
		return "as/modify";
	}
	
	@RequestMapping("delete")
	String delete() {
		return "as/delete";
	}
	
	//매장	
	@RequestMapping("store/detail")
	String storeDetail() {
		return "as/store/detail";
	}
	
	@RequestMapping("store/insert")
	String storeInsert() {
		return "as/store/insert";
	}
	
	@RequestMapping("store/modify")
	String storeModify() {
		return "as/store/modify";
	}
	
	@RequestMapping("store/delete")
	String storeDelete() {
		return "as/store/delete";
	}
}
