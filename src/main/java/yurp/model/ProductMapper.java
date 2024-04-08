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
}
