package yurp.model;

import java.util.Date;

import lombok.Data;

@Data
public class BrandOrderDTO {
	Integer oNo;
	String oStat, excel, bCode;
	int totPrice, totCnt;
	Date regDate;

}
