package yurp.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProductMapper {

	@Select(
			"<script>"
			+ "select * from product "
			+ "<where> "
			+ "<if test='pCode != null and pCode != \"\"'> "
			+ "p_code like concat('%',#{pCode},'%') "
			+ "</if>"
			+ "</where>"
			+ "</script>")
	List<ProductDTO> list(ArrayList<ProductDTO> arr);
	
//	@Select("select p.b_code, p.p_num, p.color, p.p_size, p.p_name, p.p_price, li_price, i.cnt, i.i_no  "
//			+ "from product p "
//			+ "join inventory i "
//			+ "where i.p_code = p.p_code and i.s_code  = 'admin' and p.b_code  = '117901'")
	@Select("<script>"
			+ "select "
			+"p.b_code, p.p_num, p.color, p.p_size, p.p_name, p.p_price, li_price, i.cnt, i.i_no  "
			+ "from product p "
			+ "join inventory i "
			+ "<where>"
			+ " i.p_code = p.p_code and i.s_code  = 'admin'"
			+ "	<trim prefix=' ' suffixOverrides = 'and | or'> "
			+ "		<if test='bCode != null' > "
			+ "			and p.b_code = #{bCode} and"
			+ "		</if> "
			+ "	</trim>"
			+ "</where> "
			+ "</script> "
			 )
	List<ProductDTO> prodList(ProductDTO dto);
	
	
	
	@Select({
		"<script>"
		, "<foreach collection='arr' item='prod' separator=';' index='i'>"
			, "select p.b_code, p.p_num, p.color, p.p_size, p.p_name, p.p_price, i.cnt, i.i_no, li_price "
			, "from product p "
			, "join inventory i "
			, "where i.i_no = #{prod.iNo}"
		, "</foreach>"
		,"</script>"})
	ArrayList<ProductDTO> excelArr(ArrayList<ProductDTO> arr);

	

	
	

}
