package yurp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.annotation.Resource;
import yurp.model.StoreDTO;
import yurp.model.StoreMapper;

@Controller
@RequestMapping("manage")
public class ManageController {

	@Resource
	StoreMapper mapper;
	
	@RequestMapping
	String manageList(Model mm, StoreDTO dto) {
		System.out.println("manageList----"+dto);
		mm.addAttribute("storeList",mapper.list(dto));
		System.out.println("manageList"+mm);
		return "manage/list";
	}
	
	@GetMapping("insert")
	void insertForm() {}
	
	@PostMapping("insert")
	String insertReg(StoreDTO dto) {
		System.out.println("insertReg---");
		int cnt = mapper.insert(dto);
		System.out.println("---insertReg"+cnt);
		return "redirect:/manage";
	}
	
	@GetMapping("delete/{sNo}")
	String delete(@PathVariable int sNo) {
		System.out.println("삭제할껴?");
		int cnt = mapper.delete(sNo);
		System.out.println("delete 실행 : "+cnt);
		return "redirect:/manage";
	}
	
	@GetMapping("modify/{sNo}")
	String modifyForm(Model mm, @PathVariable int sNo) {
		System.out.println("modifyForm 실행 : "+sNo);
		mm.addAttribute("dto",mapper.detail(sNo));
		return "manage/modify";
	}
	
	@PostMapping("modify/{sNo}")
	String modifyReg(StoreDTO dto) {

		int cnt = mapper.modify(dto);
		System.out.println("---modifyReg"+cnt);
		return "redirect:/manage";
	}
	
}
