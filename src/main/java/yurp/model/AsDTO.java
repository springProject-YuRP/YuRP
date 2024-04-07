package yurp.model;

import java.util.Date;

import lombok.Data;

@Data
public class AsDTO {

	//  접수번호, as번호, 수선비
	int asNum, aNo, asPrice;
	// 		처리결과, 진행여부, 처리내용, 고객성함, 고객전화, 의뢰내용, 매장코드, 상품코드
	String asRes, asProg, resCon, asName, asTel, asNote, sCode, pCode;
	// 	   접수날짜, 처리날짜, 구입날짜
	Date regDate, fixDate, purDate;
}
