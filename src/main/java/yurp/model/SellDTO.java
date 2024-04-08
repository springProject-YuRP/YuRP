package yurp.model;

import lombok.Data;

@Data
public class SellDTO {
	int sellNo, liPrice, discount, pPrice, cnt, totPrice;
	String pCode, pNum, sCode, sName, color, pSize, season, pName, sellDate;
}
