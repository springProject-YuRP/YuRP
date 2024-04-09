package yurp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.annotation.Resource;
import yurp.model.NoticeDTO;
import yurp.model.NoticeMapper;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Resource
	NoticeMapper mapper;
	
	// 목록보기
	@RequestMapping("list")
	String list(Model mm) {
//		List<NoticeDTO> nList = mapper.list();
//		System.out.println("nList : "+nList);
		mm.addAttribute("nList", mapper.list());
		return "notice/list";
	}
	
	// 상세보기
	@RequestMapping("detail/{nNo}")
	String detail(Model mm, @PathVariable int nNo) {
		mm.addAttribute("dto", mapper.detail(nNo));
//		System.out.println(mapper.detail(n_no));
		return "notice/detail";
	}
	
	// 추가
	@GetMapping("insert")
	void insertFrom() {}	// insert.html 열기
	
	@PostMapping("insert")
	String insertReg(Model mm, NoticeDTO dto) {
//		System.out.println(mapper.insert(dto));
		mm.addAttribute("dto", mapper.insert(dto));
		return "redirect:/";
	}
	

	// 수정
	@GetMapping("modify/{nNo}")
	String modifyForm(Model mm, NoticeDTO dto) {
		mm.addAttribute("dto",mapper.detail(dto.getNNo()));
		return "notice/modify";
	}
	
	@PostMapping("modify/{nNo}")
	String modifyReg(Model mm, NoticeDTO dto) {
//		System.out.println(mapper.insert(dto));
		mm.addAttribute("dto", mapper.modify(dto));
		return "redirect:/";	//작성 후 상세보기로 이동
	}
	
	// 삭제
	@GetMapping("delete/{nNo}")
	String delete(Model mm, NoticeDTO dto) {
		mm.addAttribute("dto",  mapper.delete(dto));
		return "redirect:/";
	}

}
