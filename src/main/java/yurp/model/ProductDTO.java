package yurp.model;

import lombok.Data;

@Data
public class ProductDTO {
	Integer pNo, grade, liPrice, discount, pPrice;
	String pCode, pNum, season, pName, color, pSize, bCode;
	
}
