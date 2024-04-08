package yurp.model;

import java.util.Date;

import lombok.Data;

@Data
public class NoticeDTO {
	
	// 공지번호
	Integer n_no;
	//		제목, 	내용, 	파일
	String title, content, file;
	//	 등록 날짜
	Date reg_date;
	
}
