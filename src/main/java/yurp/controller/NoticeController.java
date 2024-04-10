package yurp.controller;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
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
	String detail(Model mm, @PathVariable int nNo, NoticeDTO dto) {
		mm.addAttribute("dto", mapper.detail(nNo));
//		System.out.println(mapper.detail(n_no));
		return "notice/detail";
	}

	// 추가 - insert.html 열기
	@GetMapping("insert")
	void insertFrom() {}
	
	@PostMapping("insert")
	String insertReg(Model mm, NoticeDTO dto, MultipartHttpServletRequest mr, HttpServletRequest request) {
	
		String file = "";
		for (MultipartFile mpf : mr.getFiles("upFile")) {
			file += mpf.getOriginalFilename()+", ";
//			System.out.println(mpf.getOriginalFilename()+"-----------");
//			System.out.println(mpf.getName());	
//			System.out.println(mpf.getContentType());
//			System.out.println(mpf.getSize());
//			System.out.println(mpf.isEmpty());
			
			fileUpload(mpf, request);
		}
		mm.addAttribute("file",file);
		dto.setFile(file); // 파일명을 DTO에 설정
		mm.addAttribute("dto", mapper.insert(dto));
		return "redirect:/notice/list";
	}
	

	// 수정
	@GetMapping("modify/{nNo}")
	String modifyForm(Model mm, NoticeDTO dto) {
		mm.addAttribute("dto",mapper.detail(dto.getNNo()));
		return "notice/modify";
	}
	
	@PostMapping("modify/{nNo}")
	String modifyReg(Model mm, NoticeDTO dto, MultipartHttpServletRequest mr, HttpServletRequest request) {
		
		String file = "";
		for (MultipartFile mpf : mr.getFiles("upFile")) {
			file += mpf.getOriginalFilename()+", ";			
			fileUpload(mpf, request);
		}
		mm.addAttribute("file",file);
		dto.setFile(file); // 파일명을 DTO에 설정
		mm.addAttribute("dto", mapper.modify(dto));
		return "redirect:/notice/list";		//작성 후 상세보기로 이동
	}
	
	// 삭제
	@GetMapping("delete/{nNo}")
	String delete(Model mm, NoticeDTO dto) {
		mm.addAttribute("dto",  mapper.delete(dto));
		return "redirect:/notice/list";
	}

	
	
	// 파일 업로드
	void fileUpload(MultipartFile mf, HttpServletRequest request) {
        
		int pos = mf.getContentType().indexOf("/");
		String type = mf.getContentType().substring(0,pos);
		//System.out.println(type.equals("image")+","+type);
		
		if(mf.isEmpty()) {	// 파일 없으면 저장 x
			System.out.println("파일 없음");
			return;

		}else if(!type.equals("image")) {
			System.out.println("파일형식에러");
			return;
		}else{
			// 업로드된 파일이 비어 있는지 확인
			if (!mf.isEmpty()) {
				try {
					// 파일 저장 경로
					String path = request.getServletContext().getRealPath("fff")+"\\";
					//path = "C:\\GYUHWI\\workspace\\YuRP\\src\\main\\webapp\\view\\notice\\fff\\";
					path = "workspace\\YuRP\\src\\main\\webapp\\view\\notice\\fff\\";
					
					// 업로드된 파일을 지정된 경로에 저장
					FileOutputStream fos = new FileOutputStream(path+mf.getOriginalFilename());
					fos.write(mf.getBytes());
					fos.close();
					
					System.out.println("성공띠");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("모한");
			}
			
		}
		
    }
	
}
