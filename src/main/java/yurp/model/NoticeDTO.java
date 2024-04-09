package yurp.model;

import java.util.Date;

import lombok.Data;

@Data
public class NoticeDTO {
	
	// 공지번호
	Integer nNo;
	//		제목, 	내용, 	파일
	String title, content, file;
	//	 등록 날짜
	Date regDate;
	
}
