package yurp.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SellMapper {

	@Select("select "
			+ "a.sell_no,  "
			+ "a.s_code,  "
			+ "c.s_name,  "
			+ "a.sell_date,  "
			+ "b.p_num,  "
			+ "b.color,  "
			+ "b.p_size,  "
			+ "b.season,  "
			+ "b.p_name,  "
			+ "b.li_price,  "
			+ "b.discount,  "
			+ "b.p_price,  "
			+ "a.cnt,  "
			+ "b.p_price*a.cnt as tot_price  "
			+ "from sell as a  "
			+ "left join product as b on a.p_code = b.p_code  "
			+ "left join store as c on a.s_code =c.s_code")
	List<SellDTO> list();
	
	@Select("select "
			+ "sum(b.p_price*a.cnt) as all_tot "
			+ "from sell as a "
			+ "left join product as b on a.p_code = b.p_code ")
	List<SellDTO> tot();
}
