package yurp.model;


import java.util.ArrayList;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {
	

	Integer pNo, grade,  discount, pPrice, iNo, cnt, liPrice;
	String pCode, pNum, season, pName, color, pSize, bCode, sCode;

	
}
