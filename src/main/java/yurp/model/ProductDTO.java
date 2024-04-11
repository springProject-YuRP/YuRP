package yurp.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {
	

	Integer pNo, grade, liPrice, discount, pPrice, iNo, cnt, reqCnt;
	String pCode, pNum, season, pName, color, pSize, bCode, sCode;
	
	
}
