package yurp.model;

import java.util.Date;

import lombok.Data;

@Data
public class AsDTO {
	
	// 		as번호, 접수번호, 수선비
	Integer aNo, asNum, asPrice;  
	// 		처리결과, 진행여부, 처리내용, 고객성함, 고객전화, 의뢰내용, 매장코드, 매장명, 상품코드, 상품명
	String asRes, asProg, resCon, asName, asTel, asNote, sCode, sName, pCode, pName, start, end;
	// 	   접수날짜, 처리날짜, 구입날짜
	Date regDate, fixDate, purDate;

}
