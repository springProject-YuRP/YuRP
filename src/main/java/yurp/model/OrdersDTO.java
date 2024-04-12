package yurp.model;

import java.util.Date;

import lombok.Data;

@Data
public class OrdersDTO {
	Integer oNo;
	String oStat, excel, bCode,pNum,pName,color,pSize;
	int totPrice, totCnt,reqCnt;
	Date regDate;
	String pCode = pNum + color + pSize;
}
