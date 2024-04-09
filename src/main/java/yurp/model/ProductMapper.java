package yurp.model;

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
	List<ProductDTO> list(ProductDTO dto);
	
	
	
	@Select("select p.b_code, p.p_num, p.color, p.p_size, p.p_name, p.p_price, i.cnt  "
			+ "from product p "
			+ "join inventory i "
			+ "where i.p_code = p.p_code and i.s_code  = 'admin'")
	List<ProductDTO> prodList(ProductDTO dto);

}
