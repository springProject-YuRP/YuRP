package yurp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.annotation.Resource;
import yurp.model.AsDTO;
import yurp.model.AsMapper;
import yurp.model.NoticeDTO;

@Controller
@RequestMapping("/as")
public class AsController {

	@Resource
	AsMapper mapper;
	
	//------본사
	// 목록보기
	@RequestMapping("list")
	String list(Model mm) {
		mm.addAttribute("aList",mapper.list());
		return "as/list";
	}
	
	// 상세보기
	@RequestMapping("detail/{aNo}")
	String detail(Model mm, @PathVariable int aNo) {
		mm.addAttribute("dto", mapper.detail(aNo));
		return "as/detail";
	}
	
	// 수정
	@GetMapping("modify/{aNo}")
	String modifyForm(Model mm, AsDTO dto) {
		mm.addAttribute("dto",mapper.detail(dto.getANo()));
		return "as/modify";
	}
	
	@PostMapping("modify/{aNo}")
	String modifyReg(Model mm, AsDTO dto) {
		mm.addAttribute("dto", mapper.modify(dto));
		return "redirect:/";	//작성 후 상세보기로 이동
	}
	
	
	
	//------매장	
	@RequestMapping("store/detail/{aNo}")
	String storeDetail(Model mm, @PathVariable int aNo) {
		mm.addAttribute("dto", mapper.detail(aNo));
		return "as/store/detail";
	}
	
	@GetMapping("store/insert")
	void storeInsertFrom() {}	// insert.html 열기

	@PostMapping("store/insert")
	String storeInsert(Model mm, AsDTO dto) {
		mm.addAttribute("dto", mapper.storeInsert(dto));
		return "redirect:/";
	}
	
	// 수정
	@GetMapping("store/modify/{aNo}")
	String storeModifyForm(Model mm, AsDTO dto) {
		mm.addAttribute("dto",mapper.detail(dto.getANo()));
		return "as/store/modify";
	}
	
	@PostMapping("store/modify/{aNo}")
	String storeModifyReg(Model mm, AsDTO dto) {
		mm.addAttribute("dto", mapper.storeModify(dto));
		return "redirect:/";	//작성 후 상세보기로 이동
	}
	
	
	@RequestMapping("store/delete/{aNo}")
	String storeDelete(Model mm, AsDTO dto) {
		mm.addAttribute("dto", mapper.delete(dto));
		return "redirect:/";
	}
}
