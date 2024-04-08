package yurp.model;

import java.util.Date;

import lombok.Data;

@Data
public class BrandOrderDTO {
	int o_no;
	String o_stat, excel, b_code;
	int tot_price, tot_cnt;
	Date reg_date;

}
